package com.uc.iot_group3_fantomatic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private TextView textView_HelloWorld;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textView_HelloWorld.setText("haloo");






        // Find View By ID
        textView_HelloWorld = findViewById(R.id.textView_HelloWorld);

    }
}