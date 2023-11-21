package view;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Display {


        private JLabel questionLabel;
        private JTextField answerField;
        private JButton submitButton;
        private JButton northButton, southButton, eastButton, westButton;

        public Display() {
            setTitle("TriviaMaze");
            setSize(600, 400);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLayout(new BorderLayout());

            questionLabel = new JLabel("Question will appear here");
            add(questionLabel, BorderLayout.CENTER);

            answerField = new JTextField(20);
            submitButton = new JButton("Submit Answer");
            JPanel answerPanel = new JPanel();
            answerPanel.add(answerField);
            answerPanel.add(submitButton);
            add(answerPanel, BorderLayout.SOUTH);

            JPanel navigationPanel = new JPanel(new GridLayout(1, 4));
            northButton = new JButton("North");
            southButton = new JButton("South");
            eastButton = new JButton("East");
            westButton = new JButton("West");
            navigationPanel.add(northButton);
            navigationPanel.add(southButton);
            navigationPanel.add(eastButton);
            navigationPanel.add(westButton);
            add(navigationPanel, BorderLayout.NORTH);

            // Setup action listeners for buttons
            setupButtonListeners();
        }

        private void setupButtonListeners() {
            submitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Handle answer submission
                    String answer = answerField.getText();
                    System.out.println("Answer submitted: " + answer);

                }
            });

            northButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Handle moving north
                    System.out.println("Move North");

                }
            });

            // Add listeners for other direction buttons similarly
        }

        public void setQuestion(String question) {
            questionLabel.setText(question);
        }

        // Additional methods to update UI based on game state
    }
}
