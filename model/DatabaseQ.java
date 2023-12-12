package model;

import org.sqlite.SQLiteDataSource;

import model.question.Question_Answer;
import model.question.ShortAnswerQuestion;
import model.question.TrueFalseQuestion;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class DatabaseQ implements Serializable {

    public static Question_Answer getQuestion() {
        Random rand = new Random();
        return switch (rand.nextInt(3)) {
            case 0 -> getShortAnswerQuestion();
            case 1 -> getTrueFalseQuestion();
            case 2 -> getMultipleChoiceQuestion();
            default -> null;
        };
    }


  private static Question_Answer getShortAnswerQuestion() {
    SQLiteDataSource ds = null;

    //establish connection (creates db file if it does not exist :-)
    try {
      ds = new SQLiteDataSource();
      ds.setUrl("jdbc:sqlite:TriviaMazeQuestions.db");
    } catch ( Exception e ) {
      e.printStackTrace();
      System.exit(0);
    }

    String query = "SELECT * FROM shortanswer ORDER BY RANDOM() Limit 1";
    try ( Connection conn = ds.getConnection();
          Statement stmt = conn.createStatement(); ) {

      ResultSet rs = stmt.executeQuery(query);

      //walk through a random 'row' of results, grab data by column/field name
      if ( rs.next() ) {
        String question = rs.getString( "QUESTION" );
        String answer = rs.getString( "ANSWER" );

        return new ShortAnswerQuestion(question, answer);

      }
    } catch ( SQLException e ) {
      e.printStackTrace();
      System.exit( 0 );
    }
    return null;
  }

    private static Question_Answer getTrueFalseQuestion() {
        SQLiteDataSource ds = null;

        //establish connection (creates db file if it does not exist :-)
        try {
            ds = new SQLiteDataSource();
            ds.setUrl("jdbc:sqlite:TriviaMazeQuestions.db");
        } catch ( Exception e ) {
            e.printStackTrace();
            System.exit(0);
        }

        String query = "SELECT * FROM truefalse ORDER BY RANDOM() Limit 1";
        try ( Connection conn = ds.getConnection();
              Statement stmt = conn.createStatement(); ) {

            ResultSet rs = stmt.executeQuery(query);

            //walk through a random 'row' of results, grab data by column/field name
            if ( rs.next() ) {
                String question = rs.getString( "QUESTION" );
                String answer = rs.getString( "ANSWER" );

                return new TrueFalseQuestion(question, answer);

            }
        } catch ( SQLException e ) {
            e.printStackTrace();
            System.exit( 0 );
        }
        return null;
    }

    private static Question_Answer getMultipleChoiceQuestion() {
        SQLiteDataSource ds = null;

        //establish connection (creates db file if it does not exist :-)
        try {
            ds = new SQLiteDataSource();
            ds.setUrl("jdbc:sqlite:TriviaMazeQuestions.db");
        } catch ( Exception e ) {
            e.printStackTrace();
            System.exit(0);
        }

        String query = "SELECT * FROM multiplechoice ORDER BY RANDOM() Limit 1";
        try ( Connection conn = ds.getConnection();
              Statement stmt = conn.createStatement(); ) {

            ResultSet rs = stmt.executeQuery(query);

            //walk through a random 'row' of results, grab data by column/field name
            if ( rs.next() ) {
                String question = rs.getString( "QUESTION" );
                String answer = rs.getString( "ANSWER" );

                return new ShortAnswerQuestion(question, answer);

            }
        } catch ( SQLException e ) {
            e.printStackTrace();
            System.exit( 0 );
        }
        return null;
    }


}
