package com.company.TicTacToe;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TTTFrame extends Application {

    private static final int WIDTH = 600;
    private static final int HEIGHT = 600;
    private GameController gameController;
    private Pane root= new Pane();
    private Tile gameWiner = new Tile(600, 600, 30);
    private Tile[][] board = new Tile[3][3];
    private GameController controller;
    private Parent createContent() {

        root.setPrefSize(HEIGHT, WIDTH);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Tile tile = new Tile();
                tile.setTranslateX(j * 200);
                tile.setTranslateY(i * 200);
                root.getChildren().add(tile);
                board[j][i] = tile;
            }
        }
        return root;
    }

        @Override
        public void start (Stage primaryStage) throws Exception {
            gameWiner.setTranslateX(0);
            gameWiner.setTranslateY(0);
            gameController = new GameController();
            primaryStage.setScene(new Scene(createContent()));
            primaryStage.show();
        }

        private void remove(String s){
            gameWiner.setValue(s);
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    root.getChildren().remove(board[i][j]);
                }
            }

            root.getChildren().add(gameWiner);
        }

    private class Tile extends StackPane {
        private Text text = new Text();

        public Tile(){
            this(200, 200, 72);
        }

        public Tile(int with, int height, int font) {
            Rectangle border = new Rectangle(with, height);
            border.setFill(null);
            border.setStroke(Color.BLACK);
            text.setFont(Font.font(font));
            setAlignment(Pos.CENTER);
            getChildren().addAll(border, text);


            setOnMouseClicked(event -> {
                int x = ((int)event.getSceneX()/200);
                int y = ((int)event.getSceneY()/200);
                //System.out.println("("+""+event.getSceneX()+", " + event.getSceneY()+")");
                System.out.println(x+y*3);
                GameState gameState = null;
                try {
                    gameState = gameController.nextMove(x+y*3);
                } catch (Exception e) {
                    System.out.println("an exception from controller.nextMove()");
                }
                if(gameState != null){
                    for (int i = 0; i < board.length; i++) {
                        for (int j = 0; j < board.length; j++) {
                                if (gameState.getCharacters()[i*3+j]==GameCharacter.X){
                                    board[i][j].drawX();
                                }else if(gameState.getCharacters()[i*3+j]==GameCharacter.O) {
                                    board[i][j].drawO();
                            }else{
                                    System.out.println("An Error - not a X, not a O, on the board");
                            }

                        }                    }
//                    if (gameState.getCharacters()[x+y*3] == GameCharacter.O) drawO();
//                    if (gameState.getCharacters()[x+y*3] == GameCharacter.X) drawX();
                }
                if(gameState.getGameState() == gameState.GAME_X_WINNER) remove("X winner");
                if(gameState.getGameState() == gameState.GAME_O_WINNER) remove("O winner");
                if(gameState.getGameState() == gameState.GAME_DRAW) remove("Draw");
            });
        }

        public double getCenterX() {
            return getTranslateX() + 100;
        }

        public double getCenterY() {
            return getTranslateY() + 100;
        }

        public String getValue() {
            return text.getText();
        }

        public void setValue(String s){
            text.setText(s);
        }

        private void drawX() {
            text.setText("X");
        }

        private void drawO() {
            text.setText("O");
        }
    }


}

