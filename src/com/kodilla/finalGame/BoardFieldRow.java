package com.kodilla.finalGame;

import java.util.ArrayList;
import java.util.List;

public class BoardFieldRow {
    private List<BoardField> fields = new ArrayList<>();

    public List<BoardField> getFields() {
        return fields;
    }

    public BoardFieldRow() {
        for (int i=0;i<10;i++)
            fields.add(new BoardField(FieldColor.NONE));
    }
}
