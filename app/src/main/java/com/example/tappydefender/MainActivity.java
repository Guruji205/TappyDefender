package com.example.tappydefender;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button playBtn = findViewById(R.id.playBtn);
        playBtn.setOnClickListener(this);

        SharedPreferences prefs;
        SharedPreferences.Editor editor;
        prefs = getSharedPreferences("HiScores", MODE_PRIVATE);
        final TextView textFastestTime = (TextView)findViewById(R.id.scoreTextView);
        long fastestTime = prefs.getLong("fastestTime", 1000000);
        textFastestTime.setText("Fastest Time:" + fastestTime);
    }

    @Override
    public void onClick(View v)
    {
        Intent i = new Intent(this, GameActivity.class);
        startActivity(i);
        finish();
    }

    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if (keyCode == KeyEvent.KEYCODE_BACK)
        {
            finish();
            return true;
        }
        return false;
    }
}