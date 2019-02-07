package com.example.android.stopwatch;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
        int second = 0;
        boolean running;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        runTimer();

    }
    public  void startTimer(View v){

        running=true;

    }
    public  void pauseTimer(View v){

        running=false;

    }

    public  void resetTimer(View v){

        running=false;
        second = 0;

    }

  private void  runTimer()
    {
        final TextView textView = findViewById(R.id.showCase);
        final Handler handler = new Handler();

        handler.post(new Runnable() {
            @Override
            public void run() {

                int hours = second/3600;
                int mins = (second%3600)/60;
                int secs = second%60;

                String time = String.format("%d:%02d:%02d",hours,mins,secs);
                textView.setText(time);

                if(running)
                {

                    second ++;
                }

                handler.postDelayed(this,1000);

            }
        });
    }
}
