package Questions;

import java.io.Serializable;

public class MultipleChoiceQuestion extends Question implements Serializable {

    public MultipleChoiceQuestion(final String theQuestion, final String theAnswer) {
        super(theQuestion, theAnswer);
    }


    public String getQuestionText() {
        return getQuestion();
    }


    public String getCorrectAnswer() {
        return getAnswer();
    }
}