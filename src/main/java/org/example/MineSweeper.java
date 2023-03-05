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
        grid.init(WIDTH, HEIGHT);
        buttons = new JButton[WIDTH][HEIGHT];
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
        JFrame frame = new JFrame("Minesweeper");


        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(WIDTH, HEIGHT));


        // create the buttons and add them to the panel
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                JButton button = new JButton();
                button.setPreferredSize(new Dimension(100, 100)); // set button size
                panel.add(button);
                buttons[i][j] = button;
            }
        }

        // add numbers to the buttons
        for(int i = 0; i< WIDTH; i++){
            for(int j = 0; j < HEIGHT; j++){
                buttons[i][j].setIcon(new ImageIcon("Minesweeper_generic.svg.jpg"));
                int key = (i+1) * WIDTH + (j+1);
                int contains = grid.getGrid().get(key).getContains();
                switch (contains) {
                    case 0 :


                        break;
                    case 1 :
                        buttons[i][j].setIcon(new ImageIcon("1024px-Minesweeper_1.png"));
                        break;
                    case 2 :

                        break;
                    case 3 :

                        break;
                    case 4 :

                        break;
                    case 5 :

                        break;
                    case 9 :
                        buttons[i][j].setIcon(new ImageIcon("png-transparent-red-circle-minesweeper-minesweeper-deluxe-minesweeper-adfree-video-games-land-mine-naval-mine-android-thumbnail.png"));
                        break;

                }
               // buttons[i][j].setText(String.valueOf(grid.getGrid().get((i+1) * WIDTH + (j+1)).getContains()));

            }
        }

        // add the panel to the window
        frame.add(panel, BorderLayout.CENTER);

        frame.pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(3000, 3000);
    }

    public class ImageButton extends JButton {

        protected ImageButton(){
        }

        @Override
        public void paint(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            Image img = Toolkit.getDefaultToolkit().getImage("1024px-Minesweeper_1.png");

            g2.drawImage(img, 45, 35, this);
            g2.dispose();
        }
    }

}
