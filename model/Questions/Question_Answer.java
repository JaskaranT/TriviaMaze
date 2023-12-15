package model.Questions;

import java.io.Serializable;

public abstract class Question_Answer implements Serializable {

    private final String myQuestion;
    private final String myAnswer;

    public Question_Answer(final String theQuestion, final String theAnswer) {
        myQuestion = theQuestion;
        myAnswer = theAnswer;
    }


    public abstract String getQuestionText();

    public abstract String getCorrectAnswer();

    public String getQuestion() {
        return myQuestion;
    }

    public String getAnswer() {
        return myAnswer;
    }
}