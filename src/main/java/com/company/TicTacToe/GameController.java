package com.company.TicTacToe;

public class GameController implements GameControllerI{


    private final PlayerI player1;
    private final PlayerI player2;
    private boolean isPlayer1Now;
    private int movesLeft;
    GameState currentGameState;

    public GameController(PlayerI player1, PlayerI player2){
        currentGameState = new GameState();
        this.player1 = player1;
        this.player2 = player2;
        this.movesLeft=9;
        this.isPlayer1Now=true;

    }

    @Override
    public void startGame() {
    }


    @Override
    public void nextMove() {
        // depending on who's now, player1.nextMove(gameState) or player2.nextMove(gameState)

    }
}
