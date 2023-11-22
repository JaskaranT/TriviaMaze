package view;

import model.Question;

import javax.swing.*;
import javax.swing.border.Border;
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

        questionAnswerPanel.add(Box.createHorizontalStrut(10));

        // Initialize and set maximum size for the answer field
        answerField = new JTextField(10);
        answerField.setMaximumSize(new Dimension(200, 30));
        questionAnswerPanel.add(answerField);

        submitButton = new JButton("Submit Answer");
        questionAnswerPanel.add(submitButton);

        add(questionAnswerPanel, BorderLayout.CENTER);

        ImageIcon doorIcon = (new ImageIcon("images/door.png"));
        northButton = createButtonWithIcon(doorIcon);
        southButton = createButtonWithIcon(doorIcon);
        eastButton = createButtonWithIcon(doorIcon);
        westButton = createButtonWithIcon(doorIcon);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));

        // Initialize buttons with resized images


        // Add buttons with glue between them for even spacing
        buttonPanel.add(Box.createHorizontalGlue());
        buttonPanel.add(northButton);
        buttonPanel.add(Box.createHorizontalGlue());
        buttonPanel.add(eastButton);
        buttonPanel.add(Box.createHorizontalGlue());
        buttonPanel.add(southButton);
        buttonPanel.add(Box.createHorizontalGlue());
        buttonPanel.add(westButton);
        buttonPanel.add(Box.createHorizontalGlue());

        // Add the button panel to the top (North) of the frame
        add(buttonPanel, BorderLayout.NORTH);


    }

    private JButton createButtonWithIcon(ImageIcon icon) {
        JButton button = new JButton(icon);
        button.setBorderPainted(false);
        button.setBorder(null);
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
        button.setOpaque(true);
        button.setBackground(Color.BLACK);
        return button;
    }

    public Icon resizeImage(String icon) {
        ImageIcon charIcon = new ImageIcon(icon);
        Image image = charIcon.getImage();
        Image newing = image.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
        charIcon = new ImageIcon(newing);
        Icon picture = (Icon)charIcon;
        return picture;
    }

    public Question getQuestionText() {
        return getQuestionText();
    }





        // setupListeners();


    }

/**
    private void setupListeners() {

        // Listener for exitGame menu item
        exitGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
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
**/