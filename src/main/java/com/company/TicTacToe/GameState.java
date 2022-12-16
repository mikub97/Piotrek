package com.company.TicTacToe;

import java.util.Arrays;

public class GameState {
    private GameCharacter[] characters;
    public static final int GAME_DRAW = 0;
    public static final int GAME_X_WINNER = 1;
    public static final int GAME_O_WINNER = 2;
    public static final int GAME_NOT_FINISHED = 3;

    private int gameState = 3;

    GameState(){
        characters = new GameCharacter[9];
        Arrays.fill(characters, GameCharacter.EMPTY);
    }

    public GameCharacter[] getCharacters() {
        return characters;
    }

    public void setCharacters(GameCharacter[] gameCharacters){
        characters = gameCharacters;
    }


    public boolean isEmpty(int position) {
        return characters[position] == GameCharacter.EMPTY;
    }

    public void  set(int position, GameCharacter gameCharacter){
        characters[position] = gameCharacter;
    }
}
