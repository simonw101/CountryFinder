package com.example.countryfinder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ahmadrosid.svgloader.SvgLoader;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CountryInfoActivty extends AppCompatActivity {

    private static final String TAG = "CountryInfoActivty";

    ImageView imageView;
    TextView countryNameTextView;
    TextView caputalCityTextView;
    TextView areaTextView;
    TextView populationTextView;
    TextView phoneCodetextView;
    TextView domainTextView;
    TextView currencyTextView;
    TextView langTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_info_activty);

        imageView = findViewById(R.id.imageView);
        countryNameTextView = findViewById(R.id.countryNameTextView);
        caputalCityTextView = findViewById(R.id.capitalCityTextView);
        areaTextView = findViewById(R.id.areaTextView);
        populationTextView = findViewById(R.id.populationTextView);
        phoneCodetextView = findViewById(R.id.phoneCodeTextView);
        domainTextView = findViewById(R.id.domainTextView);
        currencyTextView = findViewById(R.id.currencyTextView);
        langTextView = findViewById(R.id.langTextView);

        Intent intent = getIntent();

        String capital = (intent).getStringExtra("capital");

        if (!capital.equals("")) {

            caputalCityTextView.setText(String.format("Capital City: %s", capital));

        } else {

            caputalCityTextView.setText("Capital City: N/A");

        }

        String area = intent.getStringExtra("area");

        try {

            double areaDouble = Double.parseDouble(area);

            areaTextView.setText(String.format("Area: %s㎞", String.format("%.0f", areaDouble)));

        } catch (NumberFormatException e) {

            areaTextView.setText("Area: N/A");

        }

        String population = intent.getStringExtra("population");

        if (population != null) {

            populationTextView.setText(String.format("Population: %s", population));

        } else {

            populationTextView.setText("N/A");
        }


        String phoneCode = intent.getStringExtra("phoneCodes");

        if (phoneCode.equals("")) {

            phoneCodetextView.setText("Country code: N/A");


        } else {

            phoneCodetextView.setText(String.format("Country code: +%s", phoneCode));


        }

        String domain = intent.getStringExtra("domain");

        if (domain != null) {

            domainTextView.setText(String.format("Internet Domain: %s", domain));

        }

        String currency = intent.getStringExtra("currency");

        if (currency != null) {

            currencyTextView.setText(String.format("Currency: %s", currency));

        } else {

            currencyTextView.setText("Currency: N/A");

        }

        String languages = intent.getStringExtra("lang");

        if (languages != null) {

            langTextView.setText("Language: " + languages);

        } else {

            langTextView.setText("Language: N/A");
        }

        Log.i(TAG, languages);

        String flag = intent.getStringExtra("flagUrl");

        SvgLoader.pluck()
                .with(this)
                .setPlaceHolder(R.mipmap.ic_launcher, R.mipmap.ic_launcher)
                .load(flag, imageView);

        String countryName = intent.getStringExtra("countryName");

        countryNameTextView.setText(countryName);




    }
}
