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

public class Muscular extends AppCompatActivity {
    Switch aSwitch;
    boolean progress = false;
    public static final String PREFS_NAME3 = "MyPrefsFile3";
    public static final String PREFS_NAME4 = "MyPrefsFile4";
    public static final String PREFS_NAME5 = "MyPrefsFile5";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muscular);

        //Implement Progress Bar Pulldown
        final ProgressBar ProgressBarPulldown = (ProgressBar) findViewById(R.id.ProgressBarPulldown);


        aSwitch = findViewById(R.id.Muscular1Switch);

        SharedPreferences pulldown = getSharedPreferences(PREFS_NAME3, 0);
        boolean silent3 = pulldown.getBoolean("switchkey", false);
        aSwitch.setChecked(silent3);
        if (silent3 == true){
            ProgressBarPulldown.setProgress(200);
        }
        else{
            ProgressBarPulldown.setProgress(0);
        }

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                progress = b;

                if (progress) {

                    UserDBHandler handler = new UserDBHandler(Muscular.this);

                    handler.addProgress("pulldown");

                    ProgressBarPulldown.setProgress(200);

                    //Tell user it worked
                    Toast.makeText(Muscular.this, "Activity Completed", Toast.LENGTH_LONG).show();
                }

                else {
                    ProgressBarPulldown.setProgress(0);
                }
                SharedPreferences settings3 = getSharedPreferences(PREFS_NAME3, 0);
                SharedPreferences.Editor editor = settings3.edit();
                editor.putBoolean("switchkey", progress);
                editor.commit();
            }
        });

        //Implement Progress Bar Pushdown
        final ProgressBar ProgressBarPushdown = (ProgressBar) findViewById(R.id.ProgressBarPushdown);


        aSwitch = findViewById(R.id.Muscular2Switch);

        SharedPreferences pushdown = getSharedPreferences(PREFS_NAME4, 0);
        boolean silent4 = pushdown.getBoolean("switchkey", false);
        aSwitch.setChecked(silent4);
        if (silent4 == true){
            ProgressBarPushdown.setProgress(200);
        }
        else{
            ProgressBarPushdown.setProgress(0);
        }

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                progress = b;

                if (progress) {

                    UserDBHandler handler = new UserDBHandler(Muscular.this);

                    handler.addProgress("pushdown");

                    ProgressBarPushdown.setProgress(200);

                    //Tell user it worked
                    Toast.makeText(Muscular.this, "Activity Completed", Toast.LENGTH_LONG).show();
                }

                else {
                    ProgressBarPushdown.setProgress(0);
                }

                SharedPreferences settings4 = getSharedPreferences(PREFS_NAME4, 0);
                SharedPreferences.Editor editor = settings4.edit();
                editor.putBoolean("switchkey", progress);
                editor.commit();

            }
        });

        //Implement Progress Bar ShoulderPress
        final ProgressBar ProgressBarShoulderPress = (ProgressBar) findViewById(R.id.ProgressBarShoulderPress);


        aSwitch = findViewById(R.id.Muscular3Switch);

        SharedPreferences shoulderpress = getSharedPreferences(PREFS_NAME5, 0);
        boolean silent5 = shoulderpress.getBoolean("switchkey", false);
        aSwitch.setChecked(silent5);
        if (silent5 == true){
            ProgressBarShoulderPress.setProgress(200);
        }
        else{
            ProgressBarShoulderPress.setProgress(0);
        }

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                progress = b;

                if (progress) {

                    UserDBHandler handler = new UserDBHandler(Muscular.this);

                    handler.addProgress("shoulderpress");

                    ProgressBarShoulderPress.setProgress(200);

                    //Tell user it worked
                    Toast.makeText(Muscular.this, "Activity Completed", Toast.LENGTH_LONG).show();
                }

                else {
                    ProgressBarShoulderPress.setProgress(0);
                }

                SharedPreferences settings5 = getSharedPreferences(PREFS_NAME5, 0);
                SharedPreferences.Editor editor = settings5.edit();
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
