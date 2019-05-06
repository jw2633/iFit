package com.example.jw263.ifit1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.Toast;

import com.example.jw263.ifit1.R;

public class Cardiovascular extends AppCompatActivity {
    Switch aSwitch;
    boolean progress = false;
    public static final String PREFS_NAME = "MyPrefsFile";
    public static final String PREFS_NAME1 = "MyPrefsFile1";
    public static final String PREFS_NAME2 = "MyPrefsFile2";

//    SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
//    boolean silent = settings.getBoolean("switchkey", false);
//    mySwitch.setChecked(silent);




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardiovascular);


        //Implement Progress Bar Running
        final ProgressBar ProgressBarRunning = (ProgressBar) findViewById(R.id.ProgressBarRunning);


        aSwitch = findViewById(R.id.Cardio1Switch);

        SharedPreferences running = getSharedPreferences(PREFS_NAME, 0);
        boolean silent = running.getBoolean("switchkey", false);
        aSwitch.setChecked(silent);
        if (silent == true){
            ProgressBarRunning.setProgress(200);
        }
        else{
            ProgressBarRunning.setProgress(0);
        }

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                progress = b;

                if (progress) {

                    UserDBHandler handler = new UserDBHandler(Cardiovascular.this);

                    handler.addProgress("running");

                    ProgressBarRunning.setProgress(200);

                    //Tell user it worked
                    Toast.makeText(Cardiovascular.this, "Activity Completed", Toast.LENGTH_LONG).show();
                }

                else {
                    ProgressBarRunning.setProgress(0);
                }
                SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
                SharedPreferences.Editor editor = settings.edit();
                editor.putBoolean("switchkey", progress);
                editor.commit();

            }
        });

        //Implement Progress Bar Cycling
        final ProgressBar ProgressBarCycling = (ProgressBar) findViewById(R.id.ProgressBarCycling);


        aSwitch = findViewById(R.id.Cardio2Switch);

        SharedPreferences cycling = getSharedPreferences(PREFS_NAME1, 0);
        boolean silent1 = cycling.getBoolean("switchkey", false);
        aSwitch.setChecked(silent1);
        if (silent1 == true){
            ProgressBarCycling.setProgress(200);
        }
        else{
            ProgressBarCycling.setProgress(0);
        }

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                progress = b;

                if (progress) {

                    UserDBHandler handler = new UserDBHandler(Cardiovascular.this);

                    handler.addProgress("cycling");

                    ProgressBarCycling.setProgress(200);

                    //Tell user it worked
                    Toast.makeText(Cardiovascular.this, "Activity Completed", Toast.LENGTH_LONG).show();
                }

                else {
                    ProgressBarCycling.setProgress(0);
                }

                SharedPreferences settings1 = getSharedPreferences(PREFS_NAME1, 0);
                SharedPreferences.Editor editor = settings1.edit();
                editor.putBoolean("switchkey", progress);
                editor.commit();

            }
        });

        //Implement Progress Bar Swimming
        final ProgressBar ProgressBarSwimming = (ProgressBar) findViewById(R.id.ProgressBarSwimming);


        aSwitch = findViewById(R.id.Cardio3Switch);

        SharedPreferences swimming = getSharedPreferences(PREFS_NAME2, 0);
        boolean silent2 = swimming.getBoolean("switchkey", false);
        aSwitch.setChecked(silent2);
        if (silent2 == true){
            ProgressBarSwimming.setProgress(200);
        }
        else{
            ProgressBarSwimming.setProgress(0);
        }

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                progress = b;

                if (progress) {

                    UserDBHandler handler = new UserDBHandler(Cardiovascular.this);

                    handler.addProgress("swimming");

                    ProgressBarSwimming.setProgress(200);

                    //Tell user it worked
                    Toast.makeText(Cardiovascular.this, "Activity Completed", Toast.LENGTH_LONG).show();
                }

                else {
                    ProgressBarSwimming.setProgress(0);
                }

                SharedPreferences settings2 = getSharedPreferences(PREFS_NAME2, 0);
                SharedPreferences.Editor editor = settings2.edit();
                editor.putBoolean("switchkey", progress);
                editor.commit();

            }
        });


    }

    public void onButtonClick(View v){
        //Create new intent
        Intent myIntent = new Intent(this, MainActivity2.class);

        //start new activity
        startActivity(myIntent);


    }

    public void onButtonClickNotes(View v){
        //Create new intent
        Intent myIntent = new Intent(this, Notes.class);

        //start new activity
        startActivity(myIntent);

    }

    public void onButtonClickStopwatch(View v){
        //Create new intent
        Intent myIntent = new Intent(this, Stopwatch.class);

        //start new activity
        startActivity(myIntent);

    }
}
