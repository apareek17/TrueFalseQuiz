package com.example.per2.truefalsequiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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
    private Button buttonfalse;
    private Button buttontrue;
    private TextView textViewQuestion;
    private TextView textViewScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        wirewidgets();
        //setListeners();
        initializeQuiz();
        //displayNextQuestion();


    }

//    private void displayNextQuestion() {
//        if(quiz.hasMoreQuestions())
//        {
//            Question question = quiz.getNextQuestion();
//            textViewQuestion.setText(question.getQuestion());
//        }
//        else
//        {
//            textViewQuestion.setText(R.string.)
//        }
//    }

    private void initializeQuiz() {
        InputStream stream = getResources().openRawResource(R.raw.questions); // getting XML

        String jsonString = readTextFile(stream);
        Gson gson = new Gson();
        Question[] questions = gson.fromJson(ReadQuestions(), Question[].class);
        List<Question> questionList = Arrays.asList(questions);
        quiz = new Quiz(questionList);


        PlayGame();

    }

    private String ReadQuestions() {
        InputStream XmlFileInputStream = getResources().openRawResource(R.raw.questions);
        return readTextFile(XmlFileInputStream);
    }


//    private void setListeners() {
//        buttontrue.setOnClickListener(this);
//        buttonfalse.setOnClickListener(this);
//        textViewQuestion.setOnClickListener(this);
//        textViewScore.setOnClickListener(this);

    //}

    private void wirewidgets() {
        buttontrue = findViewById(R.id.button_mainactivity_buttontrue);
        buttonfalse = findViewById(R.id.button_mainactivity_buttonfalse);
        textViewQuestion = findViewById(R.id.textView_mainactivity_textViewQuestion);
        textViewScore = findViewById(R.id.textView_mainactivity_textViewScore);
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

    private void PlayGame() {

        textViewQuestion.setText("" + quiz.getNextQuestionText());
        textViewScore.setText("Score: " + quiz.getScore());

        buttontrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quiz.isTrue()) {
                    quiz.setScore(quiz.getScore() + 1);
                    Toast.makeText(QuizActivity.this, "Correct!", Toast.LENGTH_SHORT).show();
                } else {
                    quiz.setScore(quiz.getScore() - 1);

                    Toast.makeText(QuizActivity.this, "Wrong!", Toast.LENGTH_SHORT).show();
                }
                if (quiz.hasMoreQuestions()) {

                    PlayGame();
                } else {

                    int s = quiz.getScore();

                    Intent intentScore = new Intent(QuizActivity.this, FinishActivity.class);


                    intentScore.putExtra(Intent.EXTRA_TEXT, s);


                    startActivity(intentScore);
                }
            }
        });
        buttonfalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!quiz.isTrue()) {
                    quiz.setScore(quiz.getScore() + 1);
                    Toast.makeText(QuizActivity.this, "You're Right!", Toast.LENGTH_SHORT).show();
                } else {
                    quiz.setScore(quiz.getScore() - 1);

                    Toast.makeText(QuizActivity.this, "Wrong!", Toast.LENGTH_SHORT).show();
                }
                if (quiz.hasMoreQuestions()) {

                    PlayGame();
                } else {
                    int s = quiz.getScore();

                    Intent intentScore = new Intent(QuizActivity.this, FinishActivity.class);


                    intentScore.putExtra(Intent.EXTRA_TEXT, s);


                    startActivity(intentScore);
                }
            }
        });
    }
}
