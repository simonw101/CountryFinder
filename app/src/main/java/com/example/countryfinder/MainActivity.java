package com.example.countryfinder;

import android.content.DialogInterface;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    static ArrayList<String> countryNames = new ArrayList<>();

    static ArrayList<String> flagUrls = new ArrayList<>();

    static ArrayList<String> capitalCities = new ArrayList<>();

    static ArrayList<String> area = new ArrayList<>();

    static  ArrayList<String> population = new ArrayList<>();

    static  ArrayList<String> phoneCodes = new ArrayList<>();

    static  ArrayList<String> domains = new ArrayList<>();

    static  ArrayList<String> currencies = new ArrayList<>();

    static ArrayList<String> languages = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new AlertDialog.Builder(this)
                .setIcon(R.mipmap.ic_launcher)
                .setTitle("Country Finder")
                .setMessage("Press on the country you want for more information")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        try {

                            run();


                        } catch (Exception e) {

                            e.printStackTrace();

                        }

                    }
                })
                .show();


    }

    void run() {

        String url = "https://restcountries.eu/rest/v2/all";

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

                call.cancel();

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {

                final String myResponse = response.body().string();

                ParseJson parseJson = new ParseJson();

                parseJson.parseJson(myResponse);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        initRecyclerView();

                    }
                });

            }
        });




    }

    private void initRecyclerView() {

        Log.d(TAG, "initRecyclerView: init recyclerView");

        RecyclerView recyclerView = findViewById(R.id.countryRecyclerView);

        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(this, countryNames, flagUrls, capitalCities, area, population,
                phoneCodes, domains, currencies, languages);

        recyclerView.setAdapter(recyclerViewAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

}
