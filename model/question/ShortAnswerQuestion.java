package model.question;

import java.io.Serial;
import java.io.Serializable;

/**
 * The ShortAnswerQuestion class represents a short answer question
 * with a single correct answer. It extends the AbstractQuestionAnswer class.
 */
public class ShortAnswerQuestion extends AbstractQuestionAnswer implements Serializable {

    @Serial
    private static final long serialVersionUID = -6489742442100851157L;

    /**
     * Constructs a ShortAnswerQuestion object with the specified
     * question and answer.
     *
     * @param theQuestion The text of the short answer question.
     * @param theAnswer   The correct answer to the question.
     */
    public ShortAnswerQuestion(final String theQuestion, final String theAnswer) {
        super(theQuestion, theAnswer);
    }

    /**
     * Returns the text of the short answer question.
     *
     * @return The question.
     */
    @Override
    public String getQuestionText() {
        return getQuestion();
    }

    /**
     * Returns the correct answer to the short answer question.
     *
     * @return The correct answer.
     */
    @Override
    public String getCorrectAnswer() {
        return getAnswer();
    }
}
