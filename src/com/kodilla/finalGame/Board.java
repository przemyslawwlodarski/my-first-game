package com.kodilla.finalGame;

import java.util.ArrayList;
import java.util.List;


public class Board {
    private List<BoardRow> rows = new ArrayList<>();
    private GameElement element;
    private GameElement element2;


    public Board() {
        for (int i =0;i<10;i++)
            rows.add(new BoardRow());
    }

    public GameElement getElement(int col, int row){
        return rows.get(row).getCols().get(col);
    }
    public void setElement(int col, int row, GameElement element){
        rows.get(row).getCols().set(col, element);
    }
    public void moveElement(int col1, int row1, int col2, int row2){
        element = getElement(col1, row1);
        element2 = getElement(col2, row2);
        if (((col2 == col1)||(col2 == col1-1)||(col2 ==col1+1))&&((row1 == row2)||(row1==row2-1)||row1==row2+1)) {
            if (element.getColor() == PlayerColor.WHITE) {
                setElement(col1, row1, new None(PlayerColor.WHITE, false));
            } else if (element.getColor() == PlayerColor.BLACK) {
                setElement(col1, row1, new None(PlayerColor.BLACK, false));
            }
            setElement(col2, row2, element);
        } else
            GameAlertBoxInt.display("Error", "You can move the pawn to a field next to it");
    }

    @Override
    public String toString() {
        String s = "|-----------------------------|\n";
        for (int row = 0; row<10;row++){
            s+="|";
            for(int col=0;col<10;col++){
                s+=getElement(col,row).toString()+"|";
            }
            s+="\n";
        }
        s+="|-----------------------------|\n";
        return s;
    }

    public void initBoard() {
        for (int row =0; row<4; row++){
            for (int col = 0; col<10; col ++){
                setElement(col, row, new None(PlayerColor.WHITE, false));
            }
        }
        setElement(5,0, new King(PlayerColor.WHITE, true));
        setElement(4,0, new Queen(PlayerColor.WHITE, true));
        setElement(3,3, new Soldier(PlayerColor.WHITE, true));
        setElement(4,3, new Soldier(PlayerColor.WHITE, true));
        setElement(5,3, new Soldier(PlayerColor.WHITE, true));
        setElement(6,3, new Soldier(PlayerColor.WHITE, true));
        for (int row =7; row<10; row++){
            for (int col = 0; col<10; col ++){
                setElement(col, row, new None(PlayerColor.BLACK, false));
            }
        }
        setElement(4,9, new King(PlayerColor.BLACK, false));
        setElement(5,9, new Queen(PlayerColor.BLACK, false));
        setElement(3,7, new Soldier(PlayerColor.BLACK, false));
        setElement(4,7, new Soldier(PlayerColor.BLACK, false));
        setElement(5,7, new Soldier(PlayerColor.BLACK, false));
        setElement(6,7, new Soldier(PlayerColor.BLACK, false));
    }
    public void setWhiteSoldier(int col, int row){
        setElement(col, row, new Soldier(PlayerColor.WHITE, true));
    }
    public void setBlackSoldier(int col, int row){
        setElement(col, row, new Soldier(PlayerColor.BLACK, true));
    }
    public void setWhiteQueen(int col, int row){
        setElement(col, row, new Queen(PlayerColor.WHITE, true));
    }
    public void setBlackQueen(int col, int row){
        setElement(col, row, new Queen(PlayerColor.BLACK, true));
    }
    public void setWhiteKing(int col, int row){
        setElement(col, row, new King(PlayerColor.WHITE, true));
    }
    public void setBlackKing(int col, int row){
        setElement(col, row, new King(PlayerColor.BLACK, true));
    }

    public int calculateIncomeWhite() {
        int x = 0;
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                element = getElement(col, row);
                if (element.getColor() == PlayerColor.WHITE) {
                    x++;
                }
            }
        }
        return x;
    }
    public int calculateIncomeBlack() {
        int x = 0;
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                element = getElement(col, row);
                if (element.getColor() == PlayerColor.BLACK) {
                    x++;
                }
            }
        }
        return x;
    }
    public int calculateUpkeepBlack() {
        int x = 0;
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                element = getElement(col, row);
                if (element.getColor() == PlayerColor.BLACK) {
                    if (element instanceof King) {
                        x += 10;
                    } else if (element instanceof Queen) {
                        x += 5;
                    } else if (element instanceof Soldier) {
                        x += 1;
                    }
                }
            }
        }
        return x;
    }
    public int calculateUpkeepWhite() {
        int x = 0;
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                element = getElement(col, row);
                if (element.getColor() == PlayerColor.WHITE) {
                    if (element instanceof King) {
                        x += 10;
                    } else if (element instanceof Queen) {
                        x += 5;
                    } else if (element instanceof Soldier) {
                        x += 1;
                    }
                }
            }
        }
        return x;
    }

    public int calculateRealIncomeWhite() {
        int x = calculateIncomeWhite();
        int y = calculateUpkeepWhite();
        return x-y;
    }

    public void whiteAllDie() {
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                element = getElement(col, row);
                if (element.getColor() == PlayerColor.WHITE)
                    setElement(col, row, new None(PlayerColor.WHITE, false));
            }
        }
    }

    public void whiteCanMove() {
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                element = getElement(col, row);
                if (element.getColor() == PlayerColor.WHITE) {
                    element.setMovePossibility(true);
                }
            }
        }
    }
    public void blackAllDie() {
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                element = getElement(col, row);
                if (element.getColor() == PlayerColor.BLACK)
                    setElement(col, row, new None(PlayerColor.BLACK, false));
            }
        }
    }

    public void blackCanMove() {
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                element = getElement(col, row);
                if (element.getColor() == PlayerColor.BLACK) {
                    element.setMovePossibility(true);
                }
            }
        }
    }

    public int calculateRealIncomeBlack() {
        int x = calculateIncomeBlack();
        int y = calculateUpkeepBlack();
        return x-y;
    }

    public void blackCanNotMove() {
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                element = getElement(col, row);
                if (element.getColor() == PlayerColor.BLACK) {
                    element.setMovePossibility(false);
                }
            }
        }
    }
    public void whiteCanNotMove() {
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                element = getElement(col, row);
                if (element.getColor() == PlayerColor.WHITE) {
                    element.setMovePossibility(false);
                }
            }
        }
    }
}