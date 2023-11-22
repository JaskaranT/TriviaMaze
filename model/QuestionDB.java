package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.sqlite.SQLiteDataSource;


public class QuestionDB {

    public QuestionDB() {

    }


    private static Connection connect() {
        String url = "jdbc:sqlite:sqlDBs/TriviaMazeDBSQLite.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }


    public static List<Question> createMultipleChoiceTrivia() {
        List<Question> list = new ArrayList<>();

        String sql = "SELECT Question, Choice1, Choice2, Choice3, Choice4, Answer FROM TriviaMC";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // loop thru result set
            while (rs.next()) {
                String question = rs.getString("Question");
                String answer = rs.getString("Answer");
                String choice1 = rs.getString("Choice1");
                String choice2 = rs.getString("Choice2");
                String choice3 = rs.getString("Choice3");
                String choice4 = rs.getString("Choice4");

                String[] choices = { choice1, choice2, choice3, choice4 };
                Question QA = new Question();
                list.add(QA);

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }


    public static List<Question> createTrueFalseTrivia() {
        List<Question> list = new ArrayList<>();

        String sql = "SELECT Question, CHOICE1, CHOICE2, Answer FROM QuestionTF";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // loop thru result set
            while (rs.next()) {
                String question = rs.getString("Question");
                String answer = rs.getString("Answer");
                String choice1 = rs.getString("Choice1");
                String choice2 = rs.getString("Choice2");

                String[] choices = { choice1, choice2 };
                Question QA = new Question();
                list.add(QA);

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

}