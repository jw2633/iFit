package com.example.jw263.ifit1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.jw263.ifit1.R;


public class HashMap extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hash_map);

    }


    public void onButtonClickArrayListAct(View v){
        //Create new intent
        Intent myIntent = new Intent(this, ArrayListAct.class);

        //start new activity
        startActivity(myIntent);

    }

    public void onButtonClickHashSet(View v){
        //Create new intent
        Intent myIntent = new Intent(this, HashSet.class);

        //start new activity
        startActivity(myIntent);

    }

    public void onButtonClickHashMap(View v){
        //Create new intent
        Intent myIntent = new Intent(this, HashMap.class);

        //start new activity
        startActivity(myIntent);

    }
}
