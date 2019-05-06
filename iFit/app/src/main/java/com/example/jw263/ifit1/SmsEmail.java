package com.example.jw263.ifit1;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jw263.ifit1.R;

public class SmsEmail extends AppCompatActivity {

    EditText msg;
    EditText email;
    EditText phonenumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smsemail);

        msg = (EditText)findViewById(R.id.MsgBody1);
        email = (EditText)findViewById(R.id.EmailAddress1);
        phonenumber = (EditText)findViewById(R.id.PhoneNumber1);


        int SMS_PERMISSION_REQ_CODE_SUBMIT = 101;
        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.RECEIVE_SMS)
                != PackageManager.PERMISSION_GRANTED ||
                ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.SEND_SMS)
                        != PackageManager.PERMISSION_GRANTED) {


            ActivityCompat.requestPermissions(SmsEmail.this, new String[]{Manifest.permission.RECEIVE_SMS},
                    SMS_PERMISSION_REQ_CODE_SUBMIT);
            ActivityCompat.requestPermissions(SmsEmail.this, new String[]{Manifest.permission.SEND_SMS},
                    SMS_PERMISSION_REQ_CODE_SUBMIT);
        }


    }






    public void onButtonClick1(View v){

        String number = phonenumber.getText().toString();
        String sms = msg.getText().toString();

        try {

            Intent sendIntent = new Intent(Intent.ACTION_VIEW);

            sendIntent.putExtra("sms_body", sms);
            sendIntent.putExtra("address", number);


            sendIntent.setData(Uri.parse("sms:")); // This is for new Android versions

            startActivity(sendIntent);


            Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_LONG).show();

        }
        catch (Exception e){

            Toast.makeText(getApplicationContext(),"Message Failed",Toast.LENGTH_LONG).show();


        }


    }

    public void onButtonClick2(View v){

        String number = phonenumber.getText().toString();
        String sms = msg.getText().toString();

        try {
            SmsManager smsManager = SmsManager.getDefault();

            smsManager.sendTextMessage(number,null,sms,null,null);

            Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_LONG).show();

        }
        catch (Exception e){

            Toast.makeText(getApplicationContext(),"Message Failed",Toast.LENGTH_LONG).show();


        }


    }

    public void onButtonClick3(View v){

        String email = phonenumber.getText().toString();
        String msgBody = msg.getText().toString();

        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");

        emailIntent.putExtra(Intent.EXTRA_EMAIL, email);
        emailIntent.putExtra(Intent.EXTRA_TEXT, msgBody);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Email from my App!");

        startActivity(Intent.createChooser(emailIntent, "Send Email"));


        try {
            SmsManager smsManager = SmsManager.getDefault();

            smsManager.sendTextMessage(email,null,msgBody,null,null);

            Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_LONG).show();

        }
        catch (Exception e){

            Toast.makeText(getApplicationContext(),"Message Failed",Toast.LENGTH_LONG).show();


        }


    }
}
