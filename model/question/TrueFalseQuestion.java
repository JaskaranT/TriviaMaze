/*
 * TCSS 360 Autumn 2023
 * Course Project
 */

package model.question;

import java.io.Serial;
import java.io.Serializable;

/**
 * The TrueFalseQuestion class represents a true or false question
 * with a single correct answer. It extends the AbstractQuestionAnswer class.
 *
 * @author Jaskaran Toor
 * @author Michael Castro
 * @author Tu Phan
 * @version 12/15/2023
 */
public class TrueFalseQuestion extends AbstractQuestionAnswer implements Serializable {
    @Serial
    private static final long serialVersionUID = -3356095585811631580L;

    /**
     * Constructs a TrueFalseQuestion object with the specified
     * question and answer.
     *
     * @param theQuestion The text of the true or false question.
     * @param theAnswer   The correct answer to the question.
     */
    public TrueFalseQuestion(final String theQuestion, final String theAnswer) {
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
     * Returns the correct answer to the true or false question.
     *
     * @return The correct answer.
     */
    @Override
    public String getCorrectAnswer() {
        return getAnswer();
    }
}
