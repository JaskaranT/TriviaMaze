/*
 * TCSS 360 Autumn 2023
 * Course Project
 */

package test;

import model.question.AbstractQuestionAnswer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.Serial;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Jaskaran Toor
 * @author Tu Phan
 * @author Michael Castro
 *
 * Tests for Question_Answer class.
 */

class QuestionAnswerTest {

    private AbstractQuestionAnswer questionAnswer;

    @BeforeEach
    void setUp() {
        // Create an anonymous subclass of Question_Answer for testing
        questionAnswer = new AbstractQuestionAnswer("What is 2+2?", "4") {
            @Serial
            private static final long serialVersionUID = 2760800308205024609L;

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