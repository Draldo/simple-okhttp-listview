
package com.example.admin.okhttplistview;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Country {

    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("capital")
    @Expose
    public String capital;
    @SerializedName("altSpellings")
    @Expose
    public List<String> altSpellings = new ArrayList<String>();
    @SerializedName("relevance")
    @Expose
    public String relevance;
    @SerializedName("region")
    @Expose
    public String region;
    @SerializedName("subregion")
    @Expose
    public String subregion;
    @SerializedName("translations")
    @Expose
    public Translations translations;
    @SerializedName("population")
    @Expose
    public Integer population;
    @SerializedName("latlng")
    @Expose
    public List<Double> latlng = new ArrayList<Double>();
    @SerializedName("demonym")
    @Expose
    public String demonym;
    @SerializedName("area")
    @Expose
    public Double area;
    @SerializedName("gini")
    @Expose
    public Double gini;
    @SerializedName("timezones")
    @Expose
    public List<String> timezones = new ArrayList<String>();
    @SerializedName("borders")
    @Expose
    public List<String> borders = new ArrayList<String>();
    @SerializedName("nativeName")
    @Expose
    public String nativeName;
    @SerializedName("callingCodes")
    @Expose
    public List<String> callingCodes = new ArrayList<String>();
    @SerializedName("topLevelDomain")
    @Expose
    public List<String> topLevelDomain = new ArrayList<String>();
    @SerializedName("alpha2Code")
    @Expose
    public String alpha2Code;
    @SerializedName("alpha3Code")
    @Expose
    public String alpha3Code;
    @SerializedName("currencies")
    @Expose
    public List<String> currencies = new ArrayList<String>();
    @SerializedName("languages")
    @Expose
    public List<String> languages = new ArrayList<String>();

}
