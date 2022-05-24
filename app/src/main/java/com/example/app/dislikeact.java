package com.example.app;

import android.app.NotificationManager;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class dislikeact extends AppCompatActivity {
    TextView dtv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dislikeact);
        dtv=findViewById(R.id.dtv);
        NotificationManager manager=(NotificationManager)getApplicationContext().getSystemService(NOTIFICATION_SERVICE);
        manager.cancelAll();
        if(getIntent().hasExtra("DISLIKE")) {
            dtv.setText("You DISLIKED");
            dtv.setTextColor(Color.RED);
        }
    }
}