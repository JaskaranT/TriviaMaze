package model;

import java.io.Serializable;

public class Door implements Serializable {

    private boolean myLocked;

    private boolean myForeverLocked;

    private boolean myAnswered;

    private boolean myBlocked;

    private Question myQuestion;


    public Door() {
        myLocked = true;
        myForeverLocked = false;
        myAnswered = false;
       myQuestion= new Question();


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

    public String getAnswer() {
        return myQuestion.getAnswer();

    }

    public boolean getAnswered() {
        return myAnswered;
    }

    public void setQuestionAnswered(final boolean theValue) {
        myAnswered = theValue;
    }



    public boolean unlock(String answer) {
        if (myForeverLocked) {
            return false;
        }

        if (myQuestion.getAnswer().equalsIgnoreCase(answer)) {
            myLocked = false;
            return true;
        } else {
            myForeverLocked = true;
            return false;
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
