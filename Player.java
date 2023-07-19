package com.lavakumar.tictactoe;

public class Player {
    private String name;
    private String character;

    public String getName() {
        return name;
    }

    public Player(String name, String character) {
        this.name = name;
        this.character = character;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }
}
