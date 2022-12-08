package com.company.TicTacToe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameUI implements GameUII{
    @Override
    public void visualise(GameState gameState) {

    }

    @Override
    public void start() {
        System.out.println("1|2|3\n- - -\n4|5|6\n- - -\n7|8|9");
    }

    @Override
    public void finish() {

    }
    public <T> void printBoard(T [] values){
        int f= 0;
        for (int i = 0; i < 3; i++) {
            System.out.print(" ");
            for (int j = 0; j < 3; j++) {
                System.out.print(" " + values[f] + " ");
                f++;
                if (j < 3 - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < 3 - 1) {
                System.out.println(" ---+---+---");
            }
        }
    }


    public static void main(String[] args){
        GameUI ui = new GameUI();
        ui.printBoard(new Integer[]{1,2,3,4,5,6,7,8,9});
    }

}
