package com.kodilla.logic;

import java.util.ArrayList;
import java.util.List;

public class BoardRow {
    private List<GameElement> cols = new ArrayList<>();

    public List<GameElement> getCols() {
        return cols;
    }

    public BoardRow() {
        for (int i =0;i<10; i++)
            cols.add(new None());
    }
}
