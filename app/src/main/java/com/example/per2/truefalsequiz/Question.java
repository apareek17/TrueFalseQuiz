package com.example.per2.truefalsequiz;

public class Question {
    private String question;
    private boolean answer;


    public Question() {
    }

    public Question(Question q){
        question = q;
        answer = a;
    }

    public String getQuestion() {
        return question;
    }

    public boolean isAnswer() {
        return answer;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }
}
