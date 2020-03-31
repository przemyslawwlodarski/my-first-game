package com.kodilla.finalGame;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class King implements GameElement {
    private PlayerColor color;
    private Image whiteKing = new Image("file:resources/whiteKing.png");
    private Image blackKing = new Image("file:resources/blackKing.png");
    private boolean movePossibility;
    private int strength = 3;

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

    public King(PlayerColor color, boolean movePossibility) {
        this.color = color;
        this.movePossibility = movePossibility;
    }

    @Override
    public PlayerColor getColor() {
        return color;
    }

    @Override
    public ImageView getImageView() {
        return (color==PlayerColor.WHITE) ? new ImageView(whiteKing) : new ImageView(blackKing);
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
