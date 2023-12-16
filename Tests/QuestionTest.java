package Tests;

import model.Questions.Question_Answer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Jaskaran Toor
 * @author Tu Phan
 * @author Michael Castro
 *
 * Tests for Question_Answer class.
 */

class QuestionTest {

    private Question_Answer questionAnswer;

    @BeforeEach
    void setUp() {
        // Create an anonymous subclass of Question_Answer for testing
        questionAnswer = new Question_Answer("What is 2+2?", "4") {
            @Override
            public String getQuestionText() {
                return getQuestion();
            }

            @Override
            public String getCorrectAnswer() {
                return getAnswer();
            }
        };
    }

    @Test
    void testGetQuestionText() {
        assertEquals("What is 2+2?", questionAnswer.getQuestionText());
    }

    @Test
    void testGetCorrectAnswer() {
        assertEquals("4", questionAnswer.getCorrectAnswer());
    }
}