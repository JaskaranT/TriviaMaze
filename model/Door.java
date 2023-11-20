package model;

public class Door {

    private boolean myIsLocked;

    private boolean myForeverLocked;

    private Question myQuestion;



    public Door(){
        myIsLocked = true;
        myForeverLocked = false;

    }


    public boolean isDoorLocked() {
        return myIsLocked;

    }

    public boolean isDoorForeverLocked() {
        return myForeverLocked;
    }

    public void setDoorLocked(boolean lock) {
        myIsLocked = lock;
    }

    public void setMyForeverLocked(boolean lock) {
        myForeverLocked = lock;
    }

    public String getQuestion() {
        return myQuestion.getQuestionText();
    }

    public String getAnswer() {
        return myQuestion.getCorrectAnswer();
    }

    public boolean unlock(String answer) {
        if (myForeverLocked) {
            return false; // Door cannot be unlocked as it is forever locked.
        }

        if (myQuestion.checkAnswer(answer)) {
            myIsLocked = false;
            return true;
        } else {
            myForeverLocked = true; // Lock the door forever if the answer is incorrect.
            return false;
        }
    }



}
