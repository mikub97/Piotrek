package com.company.TicTacToe;

public class GameController{
    private boolean isPlayer1Now;
    private int movesLeft;
    private GameState currentGameState;

    public GameController(){
        currentGameState = new GameState();
        this.movesLeft=9;
        this.isPlayer1Now=true;

    }

    public GameState nextMove(int position) {
        if (currentGameState.isEmpty(position)){
            if (isPlayer1Now)currentGameState.set(position, GameCharacter.O);
            else currentGameState.set(position, GameCharacter.X);
            isPlayer1Now=!isPlayer1Now;
        }else return null;

        return currentGameState;

    }
}
