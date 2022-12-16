package com.company.TicTacToe;

public class BotPlayer implements PlayerI{

    private final GameCharacter myCharacter;
    private GameNode root;

    public BotPlayer(GameCharacter character){
        this.myCharacter = character;
    }

    @Override
    public GameState nextMove(GameState gameState) {
        this.root = new GameNode(gameState);
        root.deeper(3,myCharacter);
        return root.getRandomChild();
    }
}
