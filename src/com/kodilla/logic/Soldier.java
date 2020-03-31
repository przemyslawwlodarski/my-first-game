package com.kodilla.logic;

public class Soldier implements GameElement {
    public Soldier(PlayerColor color) {
        this.color = color;
    }

    private PlayerColor color;

    @Override
    public PlayerColor getColor() {
        return color;
    }

    @Override
    public String toString() {
        return getColorSymbol()+"S";
    }

    private String getColorSymbol() {
        if(color == PlayerColor.WHITE) return "w";
        if(color == PlayerColor.BLACK) return "b";
        return " ";
    }
}
