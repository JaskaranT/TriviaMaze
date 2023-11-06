package model;

public class Door {

    private boolean myIsLocked;

    private Question_Answer myQuestion;



    public Door() {
        myIsLocked = true;
        myQuestion = DatabaseQ.getQuestion();
    }

    public void unlock() {
        myIsLocked = false;
    }

    public void lock() {
        myIsLocked = true;
    }

    public String getQuestion() {
        return myQuestion.getQuestionText();
    }

    public String getAnswer() {
        return myQuestion.getCorrectAnswer();
    }


}
