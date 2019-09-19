package com.example.countryfinder;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.ahmadrosid.svgloader.SvgLoader;

import java.util.ArrayList;

public class RecyclerViewAdapter  extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<String> countryNames;

    private ArrayList<String> flagUrl;

    private ArrayList<String> capitalCities;

    private ArrayList<String> area;

    private  ArrayList<String> population;

    private ArrayList<String> phoneCodes;

    private ArrayList<String> domains;

    private ArrayList<String> currencies;

    private ArrayList<String> languages;

    private Context context;

    RecyclerViewAdapter(Context context, ArrayList<String> countryNames, ArrayList<String> flagUrl,
                        ArrayList<String> capitalCities, ArrayList<String> area, ArrayList<String> population, ArrayList<String> phoneCodes,
                        ArrayList<String> domains, ArrayList<String> currencies, ArrayList<String> languages) {
        this.context = context;
        this.countryNames = countryNames;
        this.flagUrl = flagUrl;
        this.capitalCities  = capitalCities;
        this.area = area;
        this.population = population;
        this.phoneCodes = phoneCodes;
        this.domains = domains;
        this.currencies = currencies;
        this.languages = languages;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_listitem, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int i) {

        Log.d(TAG, "onBindViewHolder: called");

        SvgLoader.pluck()
                .with((Activity) context)
                .setPlaceHolder(R.mipmap.ic_launcher, R.mipmap.ic_launcher)
                .load(flagUrl.get(i), viewHolder.image);

        viewHolder.imageName.setText(countryNames.get(i));

        viewHolder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, CountryInfoActivty.class);

                intent.putExtra("capital", capitalCities.get(i));

                intent.putExtra("flagUrl", flagUrl.get(i));

                intent.putExtra("countryName", countryNames.get(i));

                intent.putExtra("area", area.get(i));

                intent.putExtra("population", population.get(i));

                intent.putExtra("phoneCodes", phoneCodes.get(i));

                intent.putExtra("domain", domains.get(i));

                intent.putExtra("currency", currencies.get(i));

                intent.putExtra("lang", languages.get(i));

                context.startActivity(intent);


            }
        });

    }

    @Override
    public int getItemCount() {
        return flagUrl.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

//        CircleImageView image;

        ImageView image;

        TextView imageName;

        RelativeLayout parentLayout;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.image);

            imageName = itemView.findViewById(R.id.image_name);

            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }

}
