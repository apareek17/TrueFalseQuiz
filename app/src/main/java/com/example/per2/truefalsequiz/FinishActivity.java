package com.example.per2.truefalsequiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Toast;

public class FinishActivity extends AppCompatActivity{

    private TextView Score;
    private int ScoreValue;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finishactivity);

        WireWidgets();

        ScoreValue = getIntent().getIntExtra(Intent.EXTRA_TEXT, 0);
        Score.setText("You scored: "+ ScoreValue);
        Toast.makeText(FinishActivity.this, "Thanks for playing!", Toast.LENGTH_LONG).show();
    }

    private void WireWidgets() {
        Score = findViewById(R.id.textview_finishactivity_finalscore);
    }
}
