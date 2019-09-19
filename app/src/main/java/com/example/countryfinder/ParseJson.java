package com.example.countryfinder;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ParseJson {

    private static final String TAG = "ParseJson";

    public CountryModel parseJson(String jsonData) {

        CountryModel countryModel = new CountryModel();

        try {
            JSONArray jsonArray = new JSONArray(jsonData);

            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject jsonObject = jsonArray.getJSONObject(i);

                String countryName = jsonObject.getString("name");

                countryModel.setName(countryName);

                MainActivity.countryNames.add(countryModel.getName());

                String flagUrl = jsonObject.getString("flag");

                countryModel.setFlagUrl(flagUrl);

                MainActivity.flagUrls.add(countryModel.getFlagUrl());

                String capitalCity = jsonObject.getString("capital");

                countryModel.setCapitalCity(capitalCity);

                MainActivity.capitalCities.add(countryModel.getCapitalCity());

                String area = jsonObject.getString("area");

                countryModel.setArea(area);

                MainActivity.area.add(countryModel.getArea());

                String population = jsonObject.getString("population");

                countryModel.setPopulation(population);

                MainActivity.population.add(countryModel.getPopulation());

                String phoneCode = jsonObject.getJSONArray("callingCodes").getString(0);

                countryModel.setPhoneCode(phoneCode);

                MainActivity.phoneCodes.add(countryModel.getPhoneCode());

                String domain = jsonObject.getJSONArray("topLevelDomain").getString(0);

                countryModel.setDomain(domain);

                MainActivity.domains.add(countryModel.getDomain());

                String currency = jsonObject.getJSONArray("currencies").getJSONObject(0).getString("name");

                countryModel.setCurrency(currency);

                MainActivity.currencies.add(countryModel.getCurrency());

                Log.i(countryName, currency);

                JSONArray languageArray = jsonObject.getJSONArray("languages");


                JSONObject lang = languageArray.getJSONObject(0);

                String name = lang.getString("name");

                countryModel.setLanguages(name);

                MainActivity.languages.add(countryModel.getLanguages());

                Log.i(TAG, name);


            }


        } catch (JSONException e) {
            e.printStackTrace();
        }

        return countryModel;

    }
}
