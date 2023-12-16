package model.question;

import java.io.Serial;
import java.io.Serializable;

/**
 * The MultipleChoiceQuestion class represents a multiple-choice question
 * with a single correct answer. It extends the AbstractQuestionAnswer class.
 */
public class MultipleChoiceQuestion extends AbstractQuestionAnswer implements Serializable {
    @Serial
    private static final long serialVersionUID = -719527959262704256L;

    /**
     * Constructs a MultipleChoiceQuestion object with the specified
     * question and answer.
     *
     * @param theQuestion The text of the multiple-choice question.
     * @param theAnswer   The correct answer to the question.
     */
    public MultipleChoiceQuestion(final String theQuestion, final String theAnswer) {
        super(theQuestion, theAnswer);
    }

    /**
     * Returns the text of the multiple-choice question.
     *
     * @return The question.
     */
    @Override
    public String getQuestionText() {
        return getQuestion();
    }

    /**
     * Returns the correct answer to the multiple-choice question.
     *
     * @return The correct answer.
     */
    @Override
    public String getCorrectAnswer() {
        return getAnswer();
    }
}
