package com.example.admin.okhttplistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    private TextView mTextview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Country country = getIntent().getExtras().getParcelable("keyvalue");
        mTextview = (TextView) findViewById(R.id.country_text);
        mTextview.setText(country.printString());
    }
}
