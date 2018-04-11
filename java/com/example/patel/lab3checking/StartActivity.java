package com.example.patel.lab3checking;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.patel.lab3checking.R;

public class StartActivity extends Activity {

    protected static final String ACTIVITY_NAME = "StartActivity";
    int requestCode, resultCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_start);


    Log.i(ACTIVITY_NAME, "In onCreate()");

    Button button2 = (Button) findViewById(R.id.button);
    Button forecastbtn = (Button)findViewById(R.id.weather);
    Button toolbarbtn = (Button)findViewById(R.id.toolbar);

    button2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            final Intent intent = new Intent(StartActivity.this, ListItemActivity.class);
            startActivity(intent);
            startActivityForResult(intent, 50);

        }
    });

    Button chatbutton = (Button) findViewById(R.id.chatbutton);
    chatbutton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Log.i(ACTIVITY_NAME,"User clicked start chat");
            final Intent intent = new Intent(StartActivity.this, ChatWindow.class);
            startActivity(intent);
            startActivityForResult(intent, 50);

        }
    });

    forecastbtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            final Intent intent = new Intent(StartActivity.this, WeatherForecast.class);
            startActivity(intent);
        }
    });

    toolbarbtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            final Intent intent = new Intent( StartActivity.this, TestToolbar.class);
            startActivity(intent);
        }
    });
}
        @Override
        protected void onResume () {
            super.onResume();

            Log.i(ACTIVITY_NAME, "In onResume()");
        }

        @Override
        protected void onStart () {
            super.onStart();

            Log.i(ACTIVITY_NAME, "In onStart()");
        }

        @Override
        protected void onPause () {
            super.onPause();

            Log.i(ACTIVITY_NAME, "In onPause()");
        }

        @Override
        protected void onStop () {
            super.onStop();

            Log.i(ACTIVITY_NAME, "In onStop()");
        }

        @Override
        protected void onDestroy () {
            super.onDestroy();

            Log.i(ACTIVITY_NAME, "In onDestroy()");
        }
    }