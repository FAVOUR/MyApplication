package com.example.olijefavour.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class NotificationActivity extends AppCompatActivity {

    TextView textView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        String datamessage= getIntent().getStringExtra("message");
        String   dataFrom=getIntent().getStringExtra("from_user_id");

        textView= (TextView)findViewById(R.id.notification_message);

        textView.setText(" FROM : " + dataFrom +  "| MESSAGE : " + datamessage);
    }
}
