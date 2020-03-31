package com.kodilla.logic;

public class King implements GameElement {
    private PlayerColor color;

    public King(PlayerColor color) {
        this.color = color;
    }

    @Override
    public PlayerColor getColor() {
        return color;
    }
    @Override
    public String toString() {
        return getColorSymbol()+"K";
    }

    private String getColorSymbol() {
        if(color == PlayerColor.WHITE) return "w";
        if(color == PlayerColor.BLACK) return "b";
        return " ";
    }
}
