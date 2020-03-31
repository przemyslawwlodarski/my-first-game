package com.kodilla.finalGame;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Queen implements GameElement {
    private PlayerColor color;
    private Image whiteQueen = new Image("file:resources/whiteQueen.png");
    private Image blackQueen = new Image("file:resources/blackQueen.png");
    private boolean movePossibility;
    private int strength = 2;

    @Override
    public int getStrength(){
        return strength;
    }

    public boolean isMovePossible() {
        return movePossibility;
    }

    @Override
    public void setMovePossibility(boolean movePossibility) {
        this.movePossibility = movePossibility;
    }

    public Queen(PlayerColor color, boolean movePossibility) {
        this.color = color;
        this.movePossibility = movePossibility;
    }

    @Override
    public ImageView getImageView() {
        return (color == PlayerColor.WHITE) ? new ImageView(whiteQueen) : new ImageView(blackQueen);
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
