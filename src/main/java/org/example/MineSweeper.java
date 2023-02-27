package org.example;

import javax.swing.*;
import java.awt.*;

public class MineSweeper extends JFrame {
    private final int WIDTH;
    private final int HEIGHT;
    private final Grille grid;
    private final JButton[][] buttons;

    public MineSweeper(Difficulty difficulty) {
        this.WIDTH = difficulty.getX();
        this.HEIGHT = difficulty.getY();
        grid = new Grille();
        buttons = new JButton[WIDTH][HEIGHT];
    }

    public void gridInit() {
        grid.init(WIDTH, HEIGHT);
    }

    public void display() {
//        JFrame frame = new JFrame("Minesweeper");
//
//        JPanel panel = new JPanel();
//        panel.setLayout(new GridLayout(WIDTH, HEIGHT));
//
//        for (int i = 0; i <= 31; i++) {
//            JButton button = new JButton();
//            button.setPreferredSize(new Dimension(5, 5));
//            panel.add(button);
//        }

//
//        frame.add(panel, BorderLayout.CENTER);
//        frame.pack();
//        frame.setSize(1000, 1000);
//        frame.setVisible(true);
//
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(WIDTH, HEIGHT));


        // create the buttons and add them to the panel
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                JButton button = new JButton();
                button.setPreferredSize(new Dimension(40, 30)); // set button size
                panel.add(button);
                buttons[i][j] = button;
            }
        }

        // add numbers to the buttons
        int count = 1;
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                buttons[i][j].setText(String.valueOf(count++));
            }
        }

        // add the panel to the window
        add(panel, BorderLayout.CENTER);

        pack();
        setVisible(true);
    }

}
