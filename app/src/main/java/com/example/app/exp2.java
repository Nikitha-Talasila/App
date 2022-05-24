package com.example.app;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class exp2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exp2);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        Log.d("Lifecycle","Oncreate invoked");
    }
    protected void onStart() {
        super.onStart();
        Log.d("lifecycle","onStart invoked");
    }
    protected void onResume(){
        super.onResume();
        Log.d("Lifecycle","onResume invoked");
    }
    protected void onPause() {
        super.onPause();
        Log.d("lifecycle","onPause invoked");
    }
    protected void onStop() {
        super.onStop();
        Log.d("lifecycle","onStop invoked");
    }
    protected void onRestart() {
        super.onRestart();
        Log.d("lifecycle","onRestart invoked");
    }
    protected void onDestroy() {
        super.onDestroy();
        Log.d("lifecycle","onDestroy invoked");
    }
}


