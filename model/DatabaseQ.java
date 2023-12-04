package model;

import org.sqlite.SQLiteDataSource;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseQ implements Serializable {

  public static Question_Answer getQuestion() {
    SQLiteDataSource ds = null;

    //establish connection (creates db file if it does not exist :-)
    try {
      ds = new SQLiteDataSource();
      ds.setUrl("jdbc:sqlite:TriviaMazeQuestions.db");
    } catch ( Exception e ) {
      e.printStackTrace();
      System.exit(0);
    }

    String query = "SELECT * FROM questions ORDER BY RANDOM() Limit 1";
    try ( Connection conn = ds.getConnection();
          Statement stmt = conn.createStatement(); ) {

      ResultSet rs = stmt.executeQuery(query);

      //walk through a random 'row' of results, grab data by column/field name
      if ( rs.next() ) {
        String question = rs.getString( "QUESTION" );
        String answer = rs.getString( "ANSWER" );

        return new Question_Answer(question, answer);

      }
    } catch ( SQLException e ) {
      e.printStackTrace();
      System.exit( 0 );
    }
    return null;
  }
}
