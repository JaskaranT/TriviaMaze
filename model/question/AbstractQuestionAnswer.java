/*
 * TCSS 360 Autumn 2023
 * Course Project
 */

package model.question;

import java.io.Serial;
import java.io.Serializable;

/**
 * The AbstractQuestionAnswer class is an abstract base class for representing
 * questions and answers. It implements the Serializable interface to allow
 * objects of its subclasses to be serialized.
 *
 * @author Jaskaran Toor
 * @author Michael Castro
 * @author Tu Phan
 * @version 12/15/2023
 */
public abstract class AbstractQuestionAnswer implements Serializable {
    @Serial
    private static final long serialVersionUID = -1450652153408258514L;
    /**
     * The text of the question.
     */
    private final String myQuestion;

    /**
     * The correct answer to the question.
     */
    private final String myAnswer;

    /**
     * Constructs an AbstractQuestionAnswer object with the specified question and
     * answer.
     *
     * @param theQuestion The text of the question.
     * @param theAnswer   The correct answer to the question.
     */
    public AbstractQuestionAnswer(final String theQuestion, final String theAnswer) {
        myQuestion = theQuestion;
        myAnswer = theAnswer;
    }

    /**
     * Abstract method to get the text of the question.
     *
     * @return The question.
     */
    public abstract String getQuestionText();

    /**
     * Abstract method to get the correct answer to the question.
     *
     * @return The correct answer.
     */
    public abstract String getCorrectAnswer();

    /**
     * Returns the text of the question.
     *
     * @return The question.
     */
    public String getQuestion() {
        return myQuestion;
    }

    /**
     * Returns the correct answer to the question.
     *
     * @return The correct answer.
     */
    public String getAnswer() {
        return myAnswer;
    }
}
