package view;

import javax.swing.*;

public class Launcher {
        public static void main(String[] args) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    Display view = new Display();
                    view.setVisible(true);
                }
            });
        }
    }

