package org.example;

import javax.swing.*;

import java.awt.*;

import static org.example.Difficulty.EASY;

public class Main {

    public static void main(String[] args) {

//        Grille grille = new Grille();
//        grille.init(16, 16);
//
//        for (int i = 0; i < grille.getWIDTH() + 2 ;i++) {
//            for(int j = 0; j < grille.getWIDTH() + 2; j++) {
//                System.out.printf("%d", grille.getGrid().get(i * (grille.getWIDTH()+2) + j).getContains());
//            }
//            System.out.printf("\n");
//
//        }
        MineSweeper mineSweeper = new MineSweeper(EASY);
        mineSweeper.display();

    }

}