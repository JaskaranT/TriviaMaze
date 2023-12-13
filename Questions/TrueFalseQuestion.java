package Questions;

import java.io.Serializable;

public class TrueFalseQuestion extends Question implements Serializable {
    public TrueFalseQuestion(final String theQuestion, final String theAnswer) {
        super(theQuestion, theAnswer);
    }


    public String getQuestionText() {
        return getQuestion();
    }


    public String getCorrectAnswer() {
        return getAnswer();
    }
}