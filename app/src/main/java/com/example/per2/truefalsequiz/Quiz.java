package com.example.per2.truefalsequiz;

import java.util.List;

public class Quiz {
    private List<Question> questionList;
    private int score = 0;
    private int questionNumber;
    private int AllQuestions = 3;

    public Quiz() {
    }

    public Quiz(List<Question> questionList) {
        this.questionList = questionList;
        this.questionNumber = -1;
    }

    public int getQuestionNumber(){
        return questionNumber;}

    public void setQuestion(List<Question> question) {
        this.questionList = question;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


    public boolean isTrue(){
        boolean correct = true;
        boolean answer = getQuestion().getAnswer();
        return correct==answer;

    }

    public Question getQuestion(){
        Question s;

        s = questionList.get(questionNumber);
        return s;
    }


    public String getNextQuestionText(){
        return getNextQuestion().getQuestionText();
    }

    public Question getNextQuestion() {
        Question s = null;
        if (hasMoreQuestions()) {
            questionNumber++;
            s = questionList.get(questionNumber);

            return s;

        }
        return s;
    }


    public Boolean hasMoreQuestions(){
            boolean x = true;
            if (questionNumber + 1 >= AllQuestions) {
                x = false;
            }
            return x;
        }
}
