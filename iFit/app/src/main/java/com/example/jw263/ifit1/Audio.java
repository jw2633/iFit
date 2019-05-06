package com.example.jw263.ifit1;

import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.jw263.ifit1.R;

import java.io.IOException;

public class Audio extends AppCompatActivity {

    //Declare Member Vars
    private static Button mRecordButton;
    private static Button mStopRecordButton;
    private static Button mPlayButton;
    private static Button mStopPlayButton;
    private static TextView mTextView;

    private static MediaRecorder mRecorder;
    private static MediaPlayer mPlayer;

    private static String mAudioFileName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);

        //Get pointers to button so we can enable/disable them
        mRecordButton = (Button)findViewById(R.id.Record);
        mStopRecordButton = (Button)findViewById(R.id.StopRecord);
        mPlayButton = (Button)findViewById(R.id.Play);
        mStopPlayButton = (Button)findViewById(R.id.StopPlay);
        mTextView = (TextView)findViewById(R.id.debugTextView);

        //Check to see if there's a mic
        PackageManager myManager = this.getPackageManager();
        if(myManager.hasSystemFeature(PackageManager.FEATURE_MICROPHONE)) {
            Log.i("TAG", "has mic");
            mRecordButton.setEnabled(true);
        }
        else {
            Log.i("TAG", "no mic");
            mRecordButton.setEnabled(false);
        }
        //disable all buttons except record button
        mStopRecordButton.setEnabled(false);
        mPlayButton.setEnabled(false);
        mStopPlayButton.setEnabled(false);

        //Set path for audio file
        mAudioFileName = Environment.getExternalStorageDirectory().getAbsolutePath()
                + "/myAudio.3gp";

        //print msg to check file name and state
        mTextView.setText("file: " + mAudioFileName +
                "\nstate: " + Environment.getExternalStorageState());
    }

    public void onRecordClick(View v) throws IOException{
        //disable this button and enable StopRecord Button
        mRecordButton.setEnabled(false);
        mStopRecordButton.setEnabled(true);

        //Create media recorder
        try{
            mRecorder = new MediaRecorder();
            mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
            mRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
            mRecorder.setOutputFile(mAudioFileName);
            mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
            mRecorder.prepare();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        //start the recording
        mRecorder.start();
    }

    public void onStopRecordClick(View v){
        //disable button and enable play button
        mStopRecordButton.setEnabled(false);
        mPlayButton.setEnabled(true);

        //Stop recording and release resource
        mRecorder.stop();
        mRecorder.release();
        mRecorder = null;
    }

    public void onPlayClick(View v) throws IOException{
        //disable button and enable StopPlay button
        mPlayButton.setEnabled(false);
        mStopPlayButton.setEnabled(true);

        //use try/catch when creating media player
        try{
            mPlayer = new MediaPlayer();
            mPlayer.setDataSource(mAudioFileName);
            mPlayer.prepare();
        } catch (Exception e){
            e.printStackTrace();
        }

        //start playback
        mPlayer.start();
    }

    public void onStopPlayClick(View v){
        //disable button and enable record button
        mStopPlayButton.setEnabled(false);
        mRecordButton.setEnabled(true);

        //stop playback and release resource
        mPlayer.stop();
        mPlayer.release();
        mPlayer = null;
    }
}
