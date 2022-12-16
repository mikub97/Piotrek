package com.company.TicTacToe;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameNode {

    private GameState state;
    private double value;
    private List<GameNode> children;
    private boolean isLeaf;
    public GameNode(GameState state){
        this.state= state;
        children=new ArrayList<>();
    }

    private List<GameState> getPossibleGameStates(GameCharacter botCharacter){
        List<GameState> possibilities = new ArrayList<>();
        GameCharacter[] characters = state.getCharacters();
        characters.clone();
        for (int i = 0; i < characters.length; i++) {
            if(characters[i] == GameCharacter.EMPTY) {
                GameCharacter[] poss = characters.clone();
                poss[i]=botCharacter;
                possibilities.add(new GameState(poss));
            }
        }
        return possibilities;
    }

    public void deeper(int depth,GameCharacter gameCharacter){
        if (depth<1) {
            this.isLeaf = true;
            this.assess();
        }
        //
        if (!children.isEmpty() || gameCharacter == GameCharacter.EMPTY){
            return;
        }
        List<GameState> list = getPossibleGameStates(gameCharacter);
        for (int i = 0; i < list.size(); i++) {
            children.add(new GameNode(list.get(i)));
        }
        if (gameCharacter == GameCharacter.X) {
            for (int i = 0; i < children.size(); i++) {
                children.get(i).deeper(depth-1,GameCharacter.O);
            }
        }else {
            for (int i = 0; i < children.size(); i++) {
                children.get(i).deeper(depth-1,GameCharacter.X);
            }
        }

    }
    public void assess(){
        value = 10;// ewaluacje gamestate
    }

    public GameState getGameState(){
        return this.state;
    }

    public GameState getRandomChild() {
        if (children.isEmpty()){
            return null;
        }
        return children.get(0).getGameState();
    }
}
