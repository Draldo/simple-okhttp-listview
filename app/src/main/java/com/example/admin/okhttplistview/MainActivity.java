package com.example.admin.okhttplistview;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private static final String APIURL = "https://restcountries.eu/rest/v1/region/europe";
    private static final String TAG = MainActivity.class.getSimpleName() + "TAG_";

    private ArrayList<Country> mCountry;
    private ListView mListview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListview = (ListView) findViewById(R.id.a_main_listview);
        getInfo();
    }

    private void getInfo() {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(APIURL)
                .build();

        //Response response = client.newCall(request).execute(); --> synchronously
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                Gson gson = new GsonBuilder().create();
                Type listType = new TypeToken<List<Country>>() {}.getType();
                mCountry = gson.fromJson(json, listType);
                loadList(mCountry);
            }
        });
    }

    private void loadList(final ArrayList<Country> countries) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                List arr = new ArrayList<String>();
                for(Country country : countries){
                    arr.add(country.name);
                }

                final ArrayAdapter adapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.list_item,R.id.text_item, arr);
                mListview.setAdapter(adapter);

                mListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Log.d(TAG, "onItemClick: " + adapter.getItem(i));
                        Intent intent = new Intent(getApplication(), DetailsActivity.class);
                        intent.putExtra("keyvalue", adapter.getItem(i).toString());
                        startActivity(intent);
                    }
                });
            }
        });
    }
}
