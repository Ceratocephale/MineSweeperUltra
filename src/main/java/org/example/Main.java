package org.example;

import static org.example.Difficulty.EASY;

public class Main {

    public static void main(String[] args) {
        MineSweeper mineSweeper = new MineSweeper(EASY);
        mineSweeper.gridInit();
        mineSweeper.display();
    }

}