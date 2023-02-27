package org.example;

import javax.swing.*;

import java.awt.*;

import static org.example.Difficulty.EASY;

public class Main {

    public static void main(String[] args) {
        MineSweeper mineSweeper = new MineSweeper(EASY);
        mineSweeper.display();
    }

}