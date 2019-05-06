package com.example.jw263.ifit1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ProgressBar;

import com.example.jw263.ifit1.R;

public class Flexibility extends AppCompatActivity {
    Switch aSwitch;
    boolean progress = false;
    public static final String PREFS_NAME6 = "MyPrefsFile6";
    public static final String PREFS_NAME7 = "MyPrefsFile7";
    public static final String PREFS_NAME8 = "MyPrefsFile8";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flexibility);

        //Implement Progress Bar AAC
        final ProgressBar ProgressBarAAC = (ProgressBar) findViewById(R.id.ProgressBarAAC);


        aSwitch = findViewById(R.id.Flexibility1Switch);

        SharedPreferences aac = getSharedPreferences(PREFS_NAME6, 0);
        boolean silent6 = aac.getBoolean("switchkey", false);
        aSwitch.setChecked(silent6);
        if (silent6 == true){
            ProgressBarAAC.setProgress(200);
        }
        else{
            ProgressBarAAC.setProgress(0);
        }

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                progress = b;

                if (progress) {

                    UserDBHandler handler = new UserDBHandler(Flexibility.this);

                    handler.addProgress("aac");

                    ProgressBarAAC.setProgress(200);

                    //Tell user it worked
                    Toast.makeText(Flexibility.this, "Activity Completed", Toast.LENGTH_LONG).show();
                }

                else {
                    ProgressBarAAC.setProgress(0);
                }
                SharedPreferences settings6 = getSharedPreferences(PREFS_NAME6, 0);
                SharedPreferences.Editor editor = settings6.edit();
                editor.putBoolean("switchkey", progress);
                editor.commit();

            }
        });

        //Implement Progress Bar Triceps
        final ProgressBar ProgressBarTriceps = (ProgressBar) findViewById(R.id.ProgressBarTriceps);


        aSwitch = findViewById(R.id.Flexibility2Switch);

        SharedPreferences triceps = getSharedPreferences(PREFS_NAME7, 0);
        boolean silent7 = triceps.getBoolean("switchkey", false);
        aSwitch.setChecked(silent7);
        if (silent7 == true){
            ProgressBarTriceps.setProgress(200);
        }
        else{
            ProgressBarTriceps.setProgress(0);
        }

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                progress = b;

                if (progress) {

                    UserDBHandler handler = new UserDBHandler(Flexibility.this);

                    handler.addProgress("triceps");

                    ProgressBarTriceps.setProgress(200);

                    //Tell user it worked
                    Toast.makeText(Flexibility.this, "Activity Completed", Toast.LENGTH_LONG).show();
                }

                else {
                    ProgressBarTriceps.setProgress(0);
                }

                SharedPreferences settings7 = getSharedPreferences(PREFS_NAME7, 0);
                SharedPreferences.Editor editor = settings7.edit();
                editor.putBoolean("switchkey", progress);
                editor.commit();

            }
        });

        //Implement Progress Bar Quadriceps
        final ProgressBar ProgressBarQuadriceps = (ProgressBar) findViewById(R.id.ProgressBarQuadriceps);


        aSwitch = findViewById(R.id.Flexibility3Switch);

        SharedPreferences quadriceps = getSharedPreferences(PREFS_NAME8, 0);
        boolean silent8 = quadriceps.getBoolean("switchkey", false);
        aSwitch.setChecked(silent8);
        if (silent8 == true){
            ProgressBarQuadriceps.setProgress(200);
        }
        else{
            ProgressBarQuadriceps.setProgress(0);
        }

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                progress = b;

                if (progress) {

                    UserDBHandler handler = new UserDBHandler(Flexibility.this);

                    handler.addProgress("quadriceps");

                    ProgressBarQuadriceps.setProgress(200);

                    //Tell user it worked
                    Toast.makeText(Flexibility.this, "Activity Completed", Toast.LENGTH_LONG).show();
                }

                else {
                    ProgressBarQuadriceps.setProgress(0);
                }

                SharedPreferences settings8 = getSharedPreferences(PREFS_NAME8, 0);
                SharedPreferences.Editor editor = settings8.edit();
                editor.putBoolean("switchkey", progress);
                editor.commit();

            }
        });

    }

//    public void addClick(View v){
//        //get name and age to add to table
//        String name = mNameView.getText().toString();
//        Integer age = Integer.parseInt(mAgeView.getText().toString());
//
//        //make new student object
//        User user = new User(name, age);
//
//        //Create db handler
//        UserDBHandler handler = new UserDBHandler(this);
//
//        //add user to db using handler
//        handler.addProgress(bodyPart);
//
//        //clear input fields
//        mNameView.setText("");
//        mAgeView.setText("");
//
//        //Tell user it worked
//        Toast.makeText(this, name + "was added to db", Toast.LENGTH_LONG).show();
//
//    }

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

    public void onButtonClickVideos(View v){
        //Create new intent
        Intent myIntent = new Intent(this, Videos.class);

        //start new activity
        startActivity(myIntent);

    }

    public void onButtonClickAudio(View v){
        //Create new intent
        Intent myIntent = new Intent(this, Audio.class);

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
