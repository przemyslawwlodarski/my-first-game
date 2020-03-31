package com.kodilla.logic;

import java.util.ArrayList;
import java.util.List;


public class Board {
    private int axisX = 0;
    private int axisY = 0;
    private List<BoardRow> rows = new ArrayList<>();
    private List<BoardFieldRow> fieldRows = new ArrayList<>();

    public Board() {
        for (int i =0;i<10;i++) {
            rows.add(new BoardRow());
            fieldRows.add(new BoardFieldRow());
        }
    }
    public FieldColor getField(int col, int row){
        return fieldRows.get(row).getFields().get(col).getColor();
    }
    public void setField(int col, int row, FieldColor color){
        fieldRows.get(row).getFields().get(col).setColor(color);
    }
    public GameElement getElement(int col, int row){
        return rows.get(row).getCols().get(col);
    }
    public void setElement(int col, int row, GameElement element){
        rows.get(row).getCols().set(col, element);
        axisX = col;
    }
    public void removeElement(int col, int row){
        rows.get(row).getCols().remove(col);
    }

    public void moveElement(int col1, int row1, GameElement element, int col2, int row2 ){
        setElement(col1, row1, new None());
        setElement(col2, row2, element);
    }
    public int getAxisX(){
        return axisX;
    }

    @Override
    public String toString() {
        String s = "|---------------------------------------|\n";
        for (int row = 0; row<10;row++){
            s+="|";
            for(int col=0;col<10;col++){
                s+=getElement(col,row).toString()+"|";
            }
            s+="\n";
        }
        s+="|---------------------------------------|\n";
        return s;
    }
//    public void move(x1, y1, x2, y2)
}