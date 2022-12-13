package com.company.TicTacToe;

import java.util.Arrays;

public class GameState {
    private GameCharacter[] characters;

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
