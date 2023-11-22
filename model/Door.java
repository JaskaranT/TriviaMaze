package model;

public class Door {

    private boolean myIsLocked;

    private boolean myForeverLocked;

    private Question myQuestion;

    private boolean myAnswered;



    public Door(){
        myIsLocked = true;
        myForeverLocked = false;
        myQuestion = new Question();
        myAnswered = false;

    }


    public boolean isDoorLocked() {
        return myIsLocked;

    }
    public void setDoorLocked(boolean theLock) {
        myIsLocked = theLock;
    }

    public boolean isDoorForeverLocked() {
        return myForeverLocked;
    }

    public void setMyForeverLocked(boolean theLock) {
        myForeverLocked = theLock;
    }

    public String getQuestion() {
        return myQuestion.getQuestionText();
    }

    public String getAnswer() {
        return myQuestion.getCorrectAnswer();
    }

    public boolean getAnswered() {
        return myAnswered;
    }

    public boolean unlock(String answer) {
        if (myForeverLocked) {
            return false;
        }

        if (myQuestion.checkAnswer(answer)) {
            myIsLocked = false;
            return true;
        } else {
            myForeverLocked = true;
            return false;
        }
    }



}
