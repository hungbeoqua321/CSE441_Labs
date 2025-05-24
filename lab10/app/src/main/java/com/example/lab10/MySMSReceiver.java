package com.example.lab10;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class MySMSReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        processReceive(context, intent);
    }

    public void processReceive(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        String message = "";
        String body = "";
        String address = "";
        if (extras != null) {
            Object[] smsEtra = (Object[]) extras.get("pdus");
            for (Object sms : smsEtra) {
                SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) sms);
                body = smsMessage.getMessageBody();
                address = smsMessage.getDisplayOriginatingAddress();
                message += "From: " + address + "\n" + body + "came";
            }
            Toast.makeText(context, message, Toast.LENGTH_LONG).show();
        }
    }
}