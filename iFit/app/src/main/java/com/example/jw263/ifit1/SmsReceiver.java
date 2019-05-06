package com.example.jw263.ifit1;

import android.content.BroadcastReceiver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class SmsReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent)
    {

        Bundle myBundle = intent.getExtras();
        SmsMessage [] messages = null;
        String strMessage = "";

        if (myBundle != null)
        {

            Object [] pdus = (Object[]) myBundle.get("pdus");

            messages = new SmsMessage[pdus.length];

            for (int i = 0; i < messages.length; i++)
            {

                messages[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);

                strMessage += "SMS From: " + messages[i].getOriginatingAddress();
                strMessage += " : ";

                strMessage += messages[i].getMessageBody();
                strMessage += "\n";
            }

            Toast.makeText(context, strMessage, Toast.LENGTH_SHORT).show();
        }
    }
}