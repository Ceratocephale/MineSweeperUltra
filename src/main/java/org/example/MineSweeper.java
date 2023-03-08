package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        JFrame frame = new JFrame("Minesweeper");
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(WIDTH, HEIGHT));


        // create the buttons and add them to the panel
//        for (int i = 0; i < WIDTH; i++) {
//            for (int j = 0; j < HEIGHT; j++) {
//
//
////              button.setText(String.format("%d", grid.getGrille().get(key).getContains()));
//
//
//
//            }
//        }

        // add numbers to the buttons
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                //  buttons[i][j].setIcon(new ImageIcon("Minesweeper_generic.svg.jpg"));
                final int key = (i + 1) * (WIDTH + 2) + (j + 1);
                int contains = grid.getGrid().get(key).getContains();
                JButton button = new JButton();
                button.setPreferredSize(new Dimension(30, 30));
                button.addActionListener(e -> {
                    int k = key;
                    click(k, buttons);
                    switchButtons(key, contains);


                });
                button.setIcon(new ImageIcon(new ImageIcon("800px-Minesweeper_unopened_square.svg.png")
                        .getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT)));
                panel.add(button);
                buttons[i][j] = button;


                //        if(grid.getGrid().get(key).getState().equals(CellState.HIDDEN))


                //              else if(grid.getGrid().get(key).getState().equals(CellState.VISIBLE)) {


                //               }

            }
        }

        // add the panel to the window
        frame.add(panel, BorderLayout.CENTER);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(500, 500);
    }

    public void click(int key, JButton[][] buttons) {
        int i = key / (HEIGHT + 2) - 1;
        int j = key % (HEIGHT + 2) - 1;
        grid.getGrille().get(key).setState(CellState.VISIBLE);
        buttons[i][j].setEnabled(false);
        if (grid.getGrille().get(key).getContains() == 0) {
            flood(key, buttons);
        }

//        int x = key / (HEIGHT+2);
//        int y = key % (HEIGHT+2);
//        System.out.printf("KEY IS %d \n", key);
//        System.out.printf("X IS %d \n",x);
//        System.out.printf("Y IS %d \n",y);
//        System.out.printf("Cell number of %d is %d \n",key,grid.getGrille().get(key).getContains());
//        System.out.printf("Cell state of %d is %s \n",key,grid.getGrille().get(key).getState());


        //  return grid.getGrille().get(key).getContains() == 9;
    }

    public void flood(int key, JButton[][] buttons) {
        int x = key / (HEIGHT + 2);
        int y = key % (HEIGHT + 2);
//        System.out.printf("KEY IS %d \n", key);
//        System.out.printf("X IS %d \n", x);
//        System.out.printf("Y IS %d \n", y);


        int tab[] = {((HEIGHT + 2) * (x - 1) + (y - 1)), ((HEIGHT + 2) * (x - 1) + y), ((HEIGHT + 2) * (x - 1) + (y + 1)), ((HEIGHT + 2) * (x) + (y - 1)), ((HEIGHT + 2) * (x) + (y + 1)), ((HEIGHT + 2) * (x + 1) + (y - 1)), ((HEIGHT + 2) * (x + 1) + y), ((HEIGHT + 2) * (x + 1) + (y + 1))};
        for (int i : tab) {
//                if( && grid.get(i).getState() == CellState.HIDDEN) {
//                    grid.get(i).setState(CellState.VISIBLE);
//                    flood(i);
//                }
//                System.out.println(i);
//                System.out.printf("Cell number of %d is %d \n",i,grid.getGrille().get(i).getContains());
//                System.out.printf("Cell state of %d is %s \n",i,grid.getGrille().get(i).getState());
            if (grid.getGrille().get(i).getContains() != 0 && grid.getGrille().get(i).getState().equals(CellState.HIDDEN))
                grid.getGrille().get(i).setState(CellState.VISIBLE);
            else if (grid.getGrille().get(i).getContains() == 0 && grid.getGrille().get(i).getState().equals(CellState.HIDDEN)) {
                grid.getGrille().get(i).setState(CellState.VISIBLE);
                buttons[x-1][y-1].setEnabled(false);
                flood(i, buttons);
            }
//                System.out.printf("Cell state of %d is %s \n",i,grid.getGrille().get(i).getState());


        }
    }

    public void switchButtons(int key, int contains) {
        int i = key / (HEIGHT + 2) - 1;
        int j = key % (HEIGHT + 2) - 1;

        switch (contains) {
            case 0:
//                buttons[i][j].setIcon(new ImageIcon(new ImageIcon("1024px-Minesweeper_0.svg.png")
//                        .getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT)));
                buttons[i][j].setDisabledIcon(new ImageIcon(new ImageIcon("1024px-Minesweeper_0.svg.png")
                        .getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT)));
                break;
            case 1:

//                buttons[i][j].setIcon(new ImageIcon(new ImageIcon("1024px-Minesweeper_1.png")
//                        .getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT)));
                buttons[i][j].setDisabledIcon(new ImageIcon(new ImageIcon("1024px-Minesweeper_1.png")
                        .getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT)));
                break;
            case 2:
//                buttons[i][j].setIcon(new ImageIcon(new ImageIcon("1200px-Minesweeper_2.png")
//                        .getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT)));
                buttons[i][j].setDisabledIcon(new ImageIcon(new ImageIcon("1200px-Minesweeper_2.png")
                        .getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT)));
                break;
            case 3:
//                buttons[i][j].setIcon(new ImageIcon(new ImageIcon("1024px-Minesweeper_3.png")
//                        .getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT)));
                buttons[i][j].setDisabledIcon(new ImageIcon(new ImageIcon("1024px-Minesweeper_3.png")
                        .getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT)));
                break;
            case 4:
//                buttons[i][j].setIcon(new ImageIcon(new ImageIcon("1024px-Minesweeper_4.png")
//                        .getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT)));
                buttons[i][j].setDisabledIcon(new ImageIcon(new ImageIcon("1024px-Minesweeper_4.png")
                        .getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT)));
                break;
            case 5:
//                buttons[i][j].setIcon(new ImageIcon(new ImageIcon("1200px-Minesweeper_5.png")
//                        .getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT)));
                buttons[i][j].setDisabledIcon(new ImageIcon(new ImageIcon("1200px-Minesweeper_5.png")
                        .getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT)));

                break;
            case 9:
//                buttons[i][j].setIcon(new ImageIcon(new ImageIcon("pngwing.com.png")
//                        .getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT)));
                buttons[i][j].setDisabledIcon(new ImageIcon(new ImageIcon("pngwing.com.png")
                        .getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT)));
                break;
        }


    }


}
