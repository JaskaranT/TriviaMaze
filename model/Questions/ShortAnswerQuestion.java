package model.Questions;

import java.io.Serializable;

public class ShortAnswerQuestion extends Question_Answer implements Serializable {

    public ShortAnswerQuestion(final String theQuestion, final String theAnswer) {
        super(theQuestion, theAnswer);
    }

    @Override
    public String getQuestionText() {
        return getQuestion();
    }

    @Override
    public String getCorrectAnswer() {
        return getAnswer();
    }
}