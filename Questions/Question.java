package Questions;



import java.io.Serializable;

public  class Question implements Serializable {

    private final String myQuestion;
    private final String myAnswer;

    public Question(final String theQuestion, final String theAnswer) {
        myQuestion = theQuestion;
        myAnswer = theAnswer;
    }




    public String getQuestion() {
        return myQuestion;
    }

    public String getAnswer() {
        return myAnswer;
    }

    public boolean checkAnswer(String theAnswer) {
        boolean result = false;

            theAnswer = theAnswer.toLowerCase();
            result = myAnswer.equals(theAnswer);

        return result;
    }
}