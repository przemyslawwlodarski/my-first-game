package com.kodilla.finalGame;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class None implements GameElement {
    private PlayerColor color;
    private Image backgroundWhite = new Image("file:resources/backgroundWhite.png");
    private Image backgroundBlack = new Image("file:resources/backgroundBlack.png");
    private Image backgroundNeutral = new Image("file:resources/backgroundNeutral.png");
    private boolean movePossibility;
    private int strength = 0;

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

    public None(PlayerColor color, boolean movePossibility) {
        this.color = color;
        this.movePossibility = movePossibility;
    }

    @Override
    public ImageView getImageView() {
        if(color==PlayerColor.WHITE)
            return new ImageView(backgroundWhite);
        else if(color==PlayerColor.BLACK)
            return new ImageView(backgroundBlack);
        else
            return new ImageView(backgroundNeutral);
    }

    @Override
    public PlayerColor getColor() {
        return color;
    }
    @Override
    public String toString(){
        return " ";
    }
}
