package model;

import java.io.Serializable;

public class Question implements Serializable {

    private String myQuestion;

    private String myAnswer;





    public Question() {
        myQuestion = DatabaseQ.getQuestion();
        myAnswer = DatabaseQ.getAnswer();

    }


    public String getQuestion() {
        return myQuestion;
    }

    public String getAnswer() {
        return myAnswer;

    }
    public boolean checkAnswer(String theAnswer) {
        return myAnswer.equalsIgnoreCase(theAnswer.trim());
    }




        public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("\n" + myQuestion + "\"");
        return sb.toString();
  }
}
