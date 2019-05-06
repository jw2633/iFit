package com.example.jw263.ifit1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.Toast;

import com.example.jw263.ifit1.R;

public class Body_Composition extends AppCompatActivity {
    Switch aSwitch;
    boolean progress = false;
    public static final String PREFS_NAME9 = "MyPrefsFile9";
    public static final String PREFS_NAME10 = "MyPrefsFile10";
    public static final String PREFS_NAME11 = "MyPrefsFile11";

//    //Set member variables for progress bar and button
//    ProgressBar prg;
//    Button add,sub;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body__composition);

        //Reference variables
//        prg = (ProgressBar)findViewById(R.id.progressBar1);
//        add = (Button)findViewById(R.id.Add);
//        sub = (Button)findViewById(R.id.Subtract);

        //Implement Progress Bar PushUp
        final ProgressBar ProgressBarPushUp = (ProgressBar) findViewById(R.id.ProgressBarPushUp);


        aSwitch = findViewById(R.id.BodyComp1Switch);

        SharedPreferences pushup = getSharedPreferences(PREFS_NAME9, 0);
        boolean silent9 = pushup.getBoolean("switchkey", false);
        aSwitch.setChecked(silent9);
        if (silent9 == true){
            ProgressBarPushUp.setProgress(200);
        }
        else{
            ProgressBarPushUp.setProgress(0);
        }

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                progress = b;

                if (progress) {

                    UserDBHandler handler = new UserDBHandler(Body_Composition.this);

                    handler.addProgress("pushups");

                    ProgressBarPushUp.setProgress(200);

                    //Tell user it worked
                    Toast.makeText(Body_Composition.this, "Activity Completed", Toast.LENGTH_LONG).show();
                }

                else {
                    ProgressBarPushUp.setProgress(0);
                }
                SharedPreferences settings9 = getSharedPreferences(PREFS_NAME9, 0);
                SharedPreferences.Editor editor = settings9.edit();
                editor.putBoolean("switchkey", progress);
                editor.commit();
            }
        });

        //Implement Progress Bar Squat
        final ProgressBar ProgressBarSquat = (ProgressBar) findViewById(R.id.ProgressBarSquat);


        aSwitch = findViewById(R.id.BodyComp2Switch);

        SharedPreferences squat = getSharedPreferences(PREFS_NAME10, 0);
        boolean silent10 = squat.getBoolean("switchkey", false);
        aSwitch.setChecked(silent10);
        if (silent10 == true){
            ProgressBarSquat.setProgress(200);
        }
        else{
            ProgressBarSquat.setProgress(0);
        }

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                progress = b;

                if (progress) {

                    UserDBHandler handler = new UserDBHandler(Body_Composition.this);

                    handler.addProgress("squat");

                    ProgressBarSquat.setProgress(200);

                    //Tell user it worked
                    Toast.makeText(Body_Composition.this, "Activity Completed", Toast.LENGTH_LONG).show();
                }

                else {
                    ProgressBarSquat.setProgress(0);
                }
                SharedPreferences settings10 = getSharedPreferences(PREFS_NAME10, 0);
                SharedPreferences.Editor editor = settings10.edit();
                editor.putBoolean("switchkey", progress);
                editor.commit();

            }
        });

        //Implement Progress Bar Lunge
        final ProgressBar ProgressBarLunge = (ProgressBar) findViewById(R.id.ProgressBarLunge);


        aSwitch = findViewById(R.id.BodyComp3Switch);

        SharedPreferences lunge = getSharedPreferences(PREFS_NAME11, 0);
        boolean silent11 = lunge.getBoolean("switchkey", false);
        aSwitch.setChecked(silent11);
        if (silent11 == true){
            ProgressBarLunge.setProgress(200);
        }
        else{
            ProgressBarLunge.setProgress(0);
        }

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                progress = b;

                if (progress) {

                    UserDBHandler handler = new UserDBHandler(Body_Composition.this);

                    handler.addProgress("lunge");

                    ProgressBarLunge.setProgress(200);

                    //Tell user it worked
                    Toast.makeText(Body_Composition.this, "Activity Completed", Toast.LENGTH_LONG).show();
                }

                else {
                    ProgressBarLunge.setProgress(0);
                }
                SharedPreferences settings11 = getSharedPreferences(PREFS_NAME11, 0);
                SharedPreferences.Editor editor = settings11.edit();
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
