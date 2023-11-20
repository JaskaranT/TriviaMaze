package model;

public class Question_Answer {

    private final String myQuestion;

    private final String myAnswer;

    public Question_Answer(String theQuestion, String theAnswer) {
        myQuestion = theQuestion;
        myAnswer = theAnswer;
    }


    public String getQuestionText() {
        return myQuestion;
    }

    public String getCorrectAnswer() {
        return myAnswer;

    }
}
