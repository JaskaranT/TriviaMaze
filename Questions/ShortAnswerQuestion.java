package Questions;

import java.io.Serializable;

public class ShortAnswerQuestion extends Question implements Serializable {

    public ShortAnswerQuestion(final String theQuestion, final String theAnswer) {
        super(theQuestion, theAnswer);
    }


    public String getQuestionText() {
        return getQuestion();
    }


    public String getCorrectAnswer() {
        return getAnswer();
    }
}