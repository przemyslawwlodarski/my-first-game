package com.kodilla.logic;

public class BoardField {
    private FieldColor color;

    public BoardField(FieldColor color) {
        this.color = color;
    }

    public void setColor(FieldColor color) {
        this.color = color;
    }

    public FieldColor getColor() {
        return color;
    }
}
