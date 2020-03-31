package com.kodilla.logic;

public class None implements GameElement {
    @Override
    public PlayerColor getColor() {
        return PlayerColor.NONE;
    }
    @Override
    public String toString(){
        return "  ";
    }
}
