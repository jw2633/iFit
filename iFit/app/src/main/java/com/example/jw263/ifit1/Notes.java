package com.example.jw263.ifit1;

import android.app.Activity;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jw263.ifit1.R;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Notes extends Activity {

    //Save user input text into a txt file
    private final static String STORETEXT = "storetext.txt";
    private EditText txtEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        txtEditor = (EditText) findViewById(R.id.textbox);

        //needed in onCreate to implement readFileInEditor()
        readFileInEditor();

    }

    //Reads the storetext.txt file
    public void readFileInEditor()
    {
        try {
            InputStream in = openFileInput(STORETEXT);
            if (in != null) {
                InputStreamReader tmp=new InputStreamReader(in);
                BufferedReader reader=new BufferedReader(tmp);
                String str;
                StringBuilder buf=new StringBuilder();
                while ((str = reader.readLine()) != null) {
                    buf.append(str);
                }
                in.close();
                txtEditor.setText(buf.toString());
            }
        }
        catch (java.io.FileNotFoundException e) {
        }
        catch (Throwable t) {
            Toast
                    .makeText(this, "Exception: "+t.toString(), Toast.LENGTH_LONG)
                    .show();
        }
    }


    //Save contents of txt when user clicks on Save button
    public void saveClicked(View v) {
        try {
            OutputStreamWriter out =
                    new OutputStreamWriter(openFileOutput(STORETEXT, 0));
            out.write(txtEditor.getText().toString());
            out.close();
            Toast
                    .makeText(this, "Contents are saved.", Toast.LENGTH_LONG)
                    .show();
        } catch (Throwable t) {
            Toast
                    .makeText(this, "Exception: " + t.toString(), Toast.LENGTH_LONG)
                    .show();
        }
    }

}