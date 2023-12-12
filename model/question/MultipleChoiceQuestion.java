package model.question;

import java.io.Serializable;

public class MultipleChoiceQuestion extends Question_Answer implements Serializable {
    public MultipleChoiceQuestion(final String theQuestion, final String theAnswer) {
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
