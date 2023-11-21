package model;

public class Question{

    private String myQuestion;

    private String myAnswer;


    public String getQuestionText() {
        return myQuestion;
    }

    public String getCorrectAnswer() {
        return myAnswer;

    }

    public boolean checkAnswer(String answer) {
        return myAnswer.equalsIgnoreCase(answer.trim());

    }
}
