package com.example.countryfinder;

public class CountryModel {

    String name;

    String flagUrl;

    String capitalCity;

    String area;

    String population;

    String phoneCode;

    String domain;

    String currency;

    String languages;

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCapitalCity() {
        return capitalCity;
    }

    public void setCapitalCity(String capitalCity) {
        this.capitalCity = capitalCity;
    }

    public String getName() {
        return name;
    }

    public String setName(String name) {
        this.name = name;

        return this.name;
    }

    public String getFlagUrl() {
        return flagUrl;
    }

    public void setFlagUrl(String flagUrl) {
        this.flagUrl = flagUrl;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }
}
