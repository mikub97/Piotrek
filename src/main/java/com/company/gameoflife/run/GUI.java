package com.company.gameoflife.run;

import com.company.gameoflife.OutOfBounds;
import com.company.gameoflife.World;
import com.company.gameoflife.worldobjects.*;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Random;
import java.util.List;

public class GUI extends JPanel implements ActionListener {
    static int SCREEN_WIDTH = 600;
    static int SCREEN_HEIGHT = 600;
    static final int UNIT_SIZE = 25;
    boolean running = false;
    static final int DELAY = 100;
    Timer timer = new Timer(DELAY, this);
    World world;
    Random random = new Random();

    GUI() throws InterruptedException, OutOfBounds {
        Dimension dimension = new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT);
        world = new World(SCREEN_WIDTH / UNIT_SIZE, SCREEN_HEIGHT / UNIT_SIZE);

        //WorldObject s = new RandomWorld(0,0 , SCREEN_WIDTH / UNIT_SIZE, SCREEN_HEIGHT / UNIT_SIZE);
        //WorldObject s = new Fill(6,6, 12,12);
       //world.add/(s);

        MyKeyAdapter myKeyAdapter = new MyKeyAdapter();
        MouseListener mouseListener   = new MouseListener();

        this.setPreferredSize(dimension);
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(myKeyAdapter);
        this.addMouseListener(mouseListener);

        startGame();


    }
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        draw(graphics);
    }

    public void draw(Graphics graphics) {

        if (running) {


            for (int i = 0; i < SCREEN_HEIGHT / UNIT_SIZE; i++) {
                graphics.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, SCREEN_WIDTH);
                graphics.drawLine(0, i * UNIT_SIZE, SCREEN_WIDTH, i * UNIT_SIZE);
            }



            for (int i = 0; i < world.cells.size(); i++) {
                if (world.cells.get(i)) {
                    graphics.setColor(Color.WHITE);
                    //graphics.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
                    graphics.fillRect((world.getX(i) * UNIT_SIZE) - UNIT_SIZE , (world.getY(i) * UNIT_SIZE) - UNIT_SIZE, UNIT_SIZE, UNIT_SIZE);

                } else {
                    graphics.setColor(Color.BLACK);
                    graphics.fillRect((world.getX(i) * UNIT_SIZE) - UNIT_SIZE, (world.getY(i) * UNIT_SIZE) -  UNIT_SIZE, UNIT_SIZE, UNIT_SIZE);
                }
            }

        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
    public void startGame() {

        running = true;
        timer.start();
    }

    public class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent keyEvent)  {
            try {
                Thread.sleep(60);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            switch (keyEvent.getKeyCode()) {
                case KeyEvent.VK_SPACE:
                    try {
                            world.tick();


                    } catch (OutOfBounds e) {
                        throw new RuntimeException(e);
                    }
                    repaint();
                    break;
            }
        }
    }
    private class MouseListener extends MouseAdapter
    {
        public void mouseClicked(MouseEvent e) {

            int x =  e.getX();
            int y =  e.getY();
            System.out.println("Mouse x: " + x);
            System.out.println("Mouse y: " + y);

            int xTile = (x + UNIT_SIZE ) /UNIT_SIZE ;
            int yTile = (y+ UNIT_SIZE) /UNIT_SIZE ;

            try {
                if(!world.cells.get(world.getId(xTile ,yTile))){
                    world.create(xTile,yTile );
                }else {
                    world.kill(xTile,yTile);
                }
            } catch (OutOfBounds ex) {
                throw new RuntimeException(ex);
            }


            System.out.println("X Tile: " + xTile);
            System.out.println("Y Tile: " + yTile);

        }
    }
}
