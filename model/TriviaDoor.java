/*
 * TCSS 360 Autumn 2023
 * Course Project
 */

package model;

import model.question.AbstractQuestionAnswer;

import java.io.Serial;
import java.io.Serializable;

/**
 * The TriviaDoor class represents a door in a game, which may be locked or
 * permanently locked based on a question. Players need to answer the question
 * correctly to unlock the door.
 *
 * @author Jaskaran Toor
 * @author Michael Castro
 * @author Tu Phan
 * @version 12/15/2023
 */
public class TriviaDoor implements Serializable {

    @Serial
    private static final long serialVersionUID = -4754827587014977439L;

    /**
     * A boolean indicating whether the door is currently locked.
     */
    private boolean myDoorLock;

    /**
     * A boolean indicating whether the door is permanently locked.
     */
    private boolean myDoorLockForever;

    /**
     * The question associated with the door.
     */
    private final AbstractQuestionAnswer myQuestion;


    /**
     * Constructs a TriviaDoor object. The door is initially locked, not
     * permanently locked, and associated with a random question.
     */
    public TriviaDoor() {
        myDoorLock = true;
        myDoorLockForever = false;
        myQuestion = DatabaseQ.getQuestion();
    }

    /**
     * Checks if the door is currently locked.
     *
     * @return true if the door is locked, false otherwise.
     */
    public boolean isLocked () {
        return myDoorLock;
    }

    /**
     * Checks if the door is permanently locked.
     *
     * @return true if the door is permanently locked, false otherwise.
     */
    public boolean isLockedForever() {
        return myDoorLockForever;
    }

    /**
     * Checks the player's answer to the associated question and updates the
     * door's lock status accordingly.
     *
     * @param thePlayersAnswer The player's answer to the question.
     */
    public void answer(final String thePlayersAnswer) {
        if (thePlayersAnswer.equalsIgnoreCase(myQuestion.getCorrectAnswer())) {
            myDoorLock = false;
        } else {
            myDoorLockForever = true;
        }
    }

    /**
     * Gets the text of the question associated with the door.
     *
     * @return The question.
     */
    public String getQuestion() {
        return myQuestion.getQuestionText();
    }

    /**
     * Gets the correct answer to the question associated with the door.
     *
     * @return The correct answer.
     */
    public String getAnswer() {
        return myQuestion.getCorrectAnswer();
    }
    public void setMyDoorLockForever(final boolean theLockForever) {
        myDoorLockForever = theLockForever;
    }
}


