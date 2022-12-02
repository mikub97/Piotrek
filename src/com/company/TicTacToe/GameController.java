package com.company.TicTacToe;

public class GameController implements GameControllerI{


    private final PlayerI player1;
    private final PlayerI player2;
    private final GameUI gameUI;
    private boolean isPlayer1Now;
    private int movesLeft;
    GameState currentGameState;

    public GameController(GameUI gameUI, PlayerI player1, PlayerI player2){
        currentGameState = new GameState();
        this.gameUI = gameUI;
        this.player1 = player1;
        this.player2 = player2;
        this.movesLeft=9;
        this.isPlayer1Now=true;

    }

    @Override
    public void startGame() {
        gameUI.start();

        //random who starts?

        while(movesLeft>0){
            gameUI.visualise(currentGameState);
            if (this.isPlayer1Now) {
                currentGameState = player1.nextMove(currentGameState);
            }
            else {
                currentGameState = player2.nextMove(currentGameState);
            }
            movesLeft--;
        }
        gameUI.finish();
        // while not finished nextMove(currentPlayer)

    }


    @Override
    public void nextMove() {
        // depending on who's now, player1.nextMove(gameState) or player2.nextMove(gameState)

    }
}
