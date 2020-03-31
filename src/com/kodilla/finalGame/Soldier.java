package com.kodilla.finalGame;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Soldier implements GameElement {
    private PlayerColor color;
    private Image whiteSoldier = new Image("file:resources/whiteSoldier.png");
    private Image blackSoldier = new Image("file:resources/blackSoldier.png");
    private boolean movePossibility;
    private int strength = 1;

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

    public Soldier(PlayerColor color, boolean movePossibility) {
        this.color = color;
        this.movePossibility = movePossibility;
    }

    @Override
    public ImageView getImageView() {
        return (color==PlayerColor.WHITE) ? new ImageView(whiteSoldier) : new ImageView(blackSoldier);
    }

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
