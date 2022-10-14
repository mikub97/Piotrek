package com.company.gameoflife.run;

import com.company.gameoflife.OutOfBounds;

import javax.swing.*;

public class GUIFrame extends JFrame{
    GUIFrame() throws OutOfBounds, InterruptedException {
        GUI gamePanel = new GUI();

        this.add(gamePanel);
        this.setTitle("GameOfLife");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
