package com.kodilla.finalGame;

import javafx.scene.image.ImageView;

public interface GameElement {
    PlayerColor getColor();

    ImageView getImageView();

    boolean isMovePossible();

    void setMovePossibility(boolean movePossibility);

    int getStrength();
}
