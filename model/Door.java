package model;

import Questions.DatabaseQ;
import Questions.Question;

import java.io.Serializable;
import java.util.Random;

public class Door implements Serializable {

    private boolean myLocked;

    private boolean myForeverLocked;

    private boolean myAnswered;

    private boolean myBlocked;

    private Question myQuestion;


    public Door() {
        myQuestion = DatabaseQ.getQuestion();
        myForeverLocked = false;
        myAnswered = false;


    }


    public boolean isDoorLocked() {
        return myLocked;

    }

    public void setDoorLocked(boolean theLock) {
        myLocked = theLock;
    }

    public boolean isDoorForeverLocked() {
        return myForeverLocked;
    }

    public void setMyForeverLocked(boolean theLock) {
        myForeverLocked = theLock;
    }

    public Question getQuestion() {
        return myQuestion;
    }



    public boolean getAnswered() {
        return myAnswered;
    }

    public void setQuestionAnswered(final boolean theValue) {
        myAnswered = theValue;
    }



    public void unlock(final String theUserAnswer) {
        /* When the door is still unlockable and the correct answer is given,
        the door will unlock */
        if (!myForeverLocked && theUserAnswer.equalsIgnoreCase(myQuestion.getAnswer())) {
            myLocked = false;
        } else {
            myForeverLocked = true;
        }
    }


    public void setWall(final boolean theWall) {
        myBlocked = theWall;
    }

    public boolean getWall() {
        return myBlocked;
    }

    public void unlockDead() {
        myForeverLocked = false;
    }


}
