package model;

public class Door {
    private boolean isLocked;
    private Question_Answer questionAnswer; // Assuming you have a QuestionAnswer class

    public Door(Question_Answer questionAnswer) {
        this.isLocked = true;
        this.questionAnswer = questionAnswer;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void unlock() {
        isLocked = false;
    }

    public void lock() {
        isLocked = true;
    }

    public String getQuestion() {
        return questionAnswer.getQuestionText();
    }

    public boolean isAnswerCorrect(String userAnswer) {
        return questionAnswer.isCorrect(userAnswer);
    }

    public String getAnswer() {
        return questionAnswer.getCorrectAnswer();
    }
}

