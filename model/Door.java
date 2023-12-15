package model;

import model.Questions.Question_Answer;
import model.Questions.Question_Answer;

import java.io.Serializable;

public class Door implements Serializable {

    private boolean myDoorLock;
    private boolean myDoorLockForever;

    private final Question_Answer myQuestion;



    public Door() {
        myDoorLock = true;
        myDoorLockForever = false;
        myQuestion = DatabaseQ.getQuestion();
    }

    public boolean isLocked () {
        return myDoorLock;
    }

    public boolean isLockedForever() {
        return myDoorLockForever;
    }

    public void answer(final String thePlayersAnswer) {
        if (thePlayersAnswer.equalsIgnoreCase(myQuestion.getCorrectAnswer())) {
            myDoorLock = false;
        } else {
            myDoorLockForever = true;
        }
    }

    public String getQuestion() {
        return myQuestion.getQuestionText();
    }

    public String getAnswer() {
        return myQuestion.getCorrectAnswer();
    }


}