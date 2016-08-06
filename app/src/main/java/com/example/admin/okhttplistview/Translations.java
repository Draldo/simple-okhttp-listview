package com.example.admin.okhttplistview;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Translations implements Parcelable {

    @SerializedName("de")
    @Expose
    public String de;
    @SerializedName("es")
    @Expose
    public String es;
    @SerializedName("fr")
    @Expose
    public String fr;
    @SerializedName("ja")
    @Expose
    public String ja;
    @SerializedName("it")
    @Expose
    public String it;


    protected Translations(Parcel in) {
        de = in.readString();
        es = in.readString();
        fr = in.readString();
        ja = in.readString();
        it = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(de);
        dest.writeString(es);
        dest.writeString(fr);
        dest.writeString(ja);
        dest.writeString(it);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Translations> CREATOR = new Parcelable.Creator<Translations>() {
        @Override
        public Translations createFromParcel(Parcel in) {
            return new Translations(in);
        }

        @Override
        public Translations[] newArray(int size) {
            return new Translations[size];
        }
    };
}