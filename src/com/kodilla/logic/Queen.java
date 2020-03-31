package com.kodilla.logic;

public class Queen implements GameElement {
    private PlayerColor color;

    public Queen(PlayerColor color) {
        this.color = color;
    }

    @Override
    public PlayerColor getColor() {
        return color;
    }
    @Override
    public String toString() {
        return getColorSymbol()+"Q";
    }

    private String getColorSymbol() {
        if(color == PlayerColor.WHITE) return "w";
        if(color == PlayerColor.BLACK) return "b";
        return " ";
    }
}
