package com.example.per2.truefalsequiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

import org.w3c.dom.Text;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class QuizActivity extends AppCompatActivity {
    public static final String TAG = "QuizActivity";

    private Quiz quiz;
    private Button False;
    private Button True;
    private TextView Question;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        wirewidgets();

        InputStream stream = getResources().openRawResource(R.raw.questions); // getting XML

        String jsonString = readTextFile(stream);
        Gson gson = new Gson();
        Question[] questions =  gson.fromJson(jsonString, Question[].class);
        Quiz stuff = new Quiz(questions);
    }

    private void wirewidgets() {
        True = findViewById(R.id.button_mainactiity_true);
        False = findViewById(R.id.button_mainactivity_false);
    }

    public String readTextFile(InputStream inputStream) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        byte buf[] = new byte[1024];
        int len;
        try {
            while ((len = inputStream.read(buf)) != -1) {
                outputStream.write(buf, 0, len);
            }
            outputStream.close();
            inputStream.close();
        } catch (IOException e) {

        }
        return outputStream.toString();

    }
}
