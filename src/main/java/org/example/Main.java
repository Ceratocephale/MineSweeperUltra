package org.example;

import javax.swing.*;

import java.awt.*;

import static org.example.Difficulty.EASY;

public class Main {

    public static void main(String[] args) {

//        for (int i = 1;i < grille.getWIDTH() + 1 ;i++) {
//            for(int j = 1; j < grille.getWIDTH() + 1; j++) {
//                System.out.printf("%d", grille.getGrid().get(i * grille.getWIDTH() + j).getContains());
//            }
//            System.out.printf("\n");
//
//        }
        MineSweeper mineSweeper = new MineSweeper(EASY);
        mineSweeper.display();

    }

}