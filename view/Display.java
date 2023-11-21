package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Display extends JFrame {
    private JLabel roomInfoLabel;
    private JLabel questionLabel;
    private JTextField answerField;
    private JButton submitButton;
    private JButton northButton, southButton, eastButton, westButton;

    public Display() {
        setTitle("Trivia Maze Game");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create menu
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        // File menu
        JMenu fileMenu = new JMenu("File");
        JMenuItem saveGame = new JMenuItem("Save Game");
        JMenuItem loadGame = new JMenuItem("Load Game");
        JMenuItem exitGame = new JMenuItem("Exit");
        fileMenu.add(saveGame);
        fileMenu.add(loadGame);
        fileMenu.add(exitGame);
        menuBar.add(fileMenu);
        // Help menu
        JMenu helpMenu = new JMenu("Help");
        JMenuItem about = new JMenuItem("About");
        JMenuItem gameplayInstructions = new JMenuItem("Gameplay Instructions");
        helpMenu.add(about);
        helpMenu.add(gameplayInstructions);
        menuBar.add(helpMenu);

        roomInfoLabel = new JLabel("Current Room: ");
        add(roomInfoLabel, BorderLayout.NORTH);

        JPanel questionAnswerPanel = new JPanel();
        questionAnswerPanel.setLayout(new BoxLayout(questionAnswerPanel, BoxLayout.LINE_AXIS));

        questionLabel = new JLabel("Question: ");
        questionAnswerPanel.add(questionLabel);

        questionAnswerPanel.add(Box.createHorizontalStrut(10)); // 10-pixel gap

        // Initialize and set maximum size for the answer field
        answerField = new JTextField(10); // Columns set to 10 for initial width
        answerField.setMaximumSize(new Dimension(200, 30)); // Set the maximum size
        questionAnswerPanel.add(answerField);

        submitButton = new JButton("Submit Answer");
        questionAnswerPanel.add(submitButton);

        add(questionAnswerPanel, BorderLayout.CENTER);




        // Navigation Buttons
        JPanel navigationPanel = new JPanel(new GridLayout(1, 4));
        northButton = new JButton("North");
        southButton = new JButton("South");
        eastButton = new JButton("East");
        westButton = new JButton("West");
        navigationPanel.add(northButton);
        navigationPanel.add(southButton);
        navigationPanel.add(eastButton);
        navigationPanel.add(westButton);
        add(navigationPanel, BorderLayout.SOUTH);

        // Setup listeners for menu items and buttons
        setupListeners();
    }

    private void setupListeners() {

        // Listener for exitGame menu item
        exitGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Exit the application
            }
        });

    }

    public void setRoomInfo(String info) {
        roomInfoLabel.setText("Current Room: " + info);
    }

    public void setQuestion(String question) {
        questionLabel.setText("Question: " + question);
    }

    // Additional methods to update UI based on game state
}
