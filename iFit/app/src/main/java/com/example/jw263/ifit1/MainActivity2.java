package com.example.jw263.ifit1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.jw263.ifit1.R;

public class MainActivity2 extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


    }

    public void onButtonClick(View v){
        //Create new intent
        Intent myIntent = new Intent(this, Cardiovascular.class);

        //start new activity
        startActivity(myIntent);

    }

    public void onButtonClick1(View v){
        //Create new intent
        Intent myIntent = new Intent(this, Muscular.class);

        //start new activity
        startActivity(myIntent);

    }

    public void onButtonClick2(View v){
        //Create new intent
        Intent myIntent = new Intent(this, Flexibility.class);

        //start new activity
        startActivity(myIntent);

    }

    public void onButtonClick3(View v){
        //Create new intent
        Intent myIntent = new Intent(this, Body_Composition.class);

        //start new activity
        startActivity(myIntent);

    }

    public void onButtonClick4(View v){
        //Create new intent
        Intent myIntent = new Intent(this, usersettings.class);

        //start new activity
        startActivity(myIntent);

    }

    public void onButtonClick5(View v){
        //Create new intent
        Intent myIntent = new Intent(this, SmsEmail.class);

        //start new activity
        startActivity(myIntent);

    }

    public void onButtonClick6(View v){
        //Create new intent
        Intent myIntent = new Intent(this, MapsActivity.class);

        //start new activity
        startActivity(myIntent);

    }


}
