package com.example.admin.okhttplistview;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Country implements Parcelable {

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


    protected Country(Parcel in) {
        name = in.readString();
        capital = in.readString();
        if (in.readByte() == 0x01) {
            altSpellings = new ArrayList<String>();
            in.readList(altSpellings, String.class.getClassLoader());
        } else {
            altSpellings = null;
        }
        relevance = in.readString();
        region = in.readString();
        subregion = in.readString();
        translations = (Translations) in.readValue(Translations.class.getClassLoader());
        population = in.readByte() == 0x00 ? null : in.readInt();
        if (in.readByte() == 0x01) {
            latlng = new ArrayList<Double>();
            in.readList(latlng, Double.class.getClassLoader());
        } else {
            latlng = null;
        }
        demonym = in.readString();
        area = in.readByte() == 0x00 ? null : in.readDouble();
        gini = in.readByte() == 0x00 ? null : in.readDouble();
        if (in.readByte() == 0x01) {
            timezones = new ArrayList<String>();
            in.readList(timezones, String.class.getClassLoader());
        } else {
            timezones = null;
        }
        if (in.readByte() == 0x01) {
            borders = new ArrayList<String>();
            in.readList(borders, String.class.getClassLoader());
        } else {
            borders = null;
        }
        nativeName = in.readString();
        if (in.readByte() == 0x01) {
            callingCodes = new ArrayList<String>();
            in.readList(callingCodes, String.class.getClassLoader());
        } else {
            callingCodes = null;
        }
        if (in.readByte() == 0x01) {
            topLevelDomain = new ArrayList<String>();
            in.readList(topLevelDomain, String.class.getClassLoader());
        } else {
            topLevelDomain = null;
        }
        alpha2Code = in.readString();
        alpha3Code = in.readString();
        if (in.readByte() == 0x01) {
            currencies = new ArrayList<String>();
            in.readList(currencies, String.class.getClassLoader());
        } else {
            currencies = null;
        }
        if (in.readByte() == 0x01) {
            languages = new ArrayList<String>();
            in.readList(languages, String.class.getClassLoader());
        } else {
            languages = null;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(capital);
        if (altSpellings == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(altSpellings);
        }
        dest.writeString(relevance);
        dest.writeString(region);
        dest.writeString(subregion);
        dest.writeValue(translations);
        if (population == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(population);
        }
        if (latlng == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(latlng);
        }
        dest.writeString(demonym);
        if (area == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeDouble(area);
        }
        if (gini == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeDouble(gini);
        }
        if (timezones == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(timezones);
        }
        if (borders == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(borders);
        }
        dest.writeString(nativeName);
        if (callingCodes == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(callingCodes);
        }
        if (topLevelDomain == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(topLevelDomain);
        }
        dest.writeString(alpha2Code);
        dest.writeString(alpha3Code);
        if (currencies == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(currencies);
        }
        if (languages == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(languages);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Country> CREATOR = new Parcelable.Creator<Country>() {
        @Override
        public Country createFromParcel(Parcel in) {
            return new Country(in);
        }

        @Override
        public Country[] newArray(int size) {
            return new Country[size];
        }
    };

    public String printString() {
        String newline = System.getProperty("line.separator");
        String str = "Country " + name + newline
                + "Capital: " + capital + newline
                + "Population: " + population + newline
                + "Currency: " + currencies.get(0) + newline
                + "Main language: " + languages.get(0);
        return str;
    }
}