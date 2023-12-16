/*
 * TCSS 360 Autumn 2023
 * Course Project
 */

package model;

import model.question.AbstractQuestionAnswer;
import model.question.MultipleChoiceQuestion;
import org.sqlite.SQLiteDataSource;

import model.question.ShortAnswerQuestion;
import model.question.TrueFalseQuestion;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

/**
 * The DatabaseQ class provides methods to retrieve random questions
 * from an SQLite database.
 *
 * @author Jaskaran Toor
 * @author Michael Castro
 * @author Tu Phan
 * @version 12/15/2023
 */
public class DatabaseQ implements Serializable {

    @Serial
    private static final long serialVersionUID = -6067340647728932375L;

    /**
     * Retrieves a random question (either Short Answer, True/False,
     * or Multiple Choice) from the database.
     *
     * @return An AbstractQuestionAnswer object representing a random question.
     */
    public static AbstractQuestionAnswer getQuestion() {
        Random rand = new Random();
        return switch (rand.nextInt(3)) {
            case 0 -> getShortAnswerQuestion();
            case 1 -> getTrueFalseQuestion();
            case 2 -> getMultipleChoiceQuestion();
            default -> null;
        };
    }

    /**
     * Retrieves a random Short Answer question from the database.
     *
     * @return A ShortAnswerQuestion object representing a random
     * Short Answer question.
     */
  private static AbstractQuestionAnswer getShortAnswerQuestion() {
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

    /**
     * Retrieves a random True/False question from the database.
     *
     * @return A TrueFalseQuestion object representing a random True/False question.
     */
    private static AbstractQuestionAnswer getTrueFalseQuestion() {
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

    /**
     * Retrieves a random Multiple Choice question from the database.
     *
     * @return A MultipleChoiceQuestion object representing a random
     * Multiple Choice question.
     */
    private static AbstractQuestionAnswer getMultipleChoiceQuestion() {
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

                return new MultipleChoiceQuestion(question, answer);

            }
        } catch ( SQLException e ) {
            e.printStackTrace();
            System.exit( 0 );
        }
        return null;
    }


}
