package com.kodilla.finalGame;

import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;

public class Game {
    private Board board;
    private GridPane gridPane;
    private int oldX=-1;
    private int oldY=-1;
    private int x,y;
    private GameElement temporaryElement = new None(PlayerColor.NONE, false);


    public Game(Board board, GridPane gridPane) {
        this.board = board;
        this.gridPane = gridPane;
    }

    public Board getBoard() {
        return board;
    }

    public GridPane getGridPane() {
        return gridPane;
    }

    public void displayBoard() {
        for (int row = 0;row<10; row++){
            for (int col = 0;col <10;col++){
                GameElement element = board.getElement(col, row);
                ImageView view = element.getImageView();
                gridPane.add(view, col, row);
            }
        }
        if (oldX!=-1) {
            GameElement element = board.getElement(oldX, oldY);
            if ((!(element instanceof None))&&(element.isMovePossible())) {
                Region rectangle = new Region();
                rectangle.setStyle("-fx-background-color: transparent; -fx-border-style: solid; -fx-border-width: 3; -fx-border-color: green; -fx-min-width: 75; -fx-min-height:75; -fx-max-width:75; -fx-max-height: 75;");
                gridPane.add(rectangle, oldX, oldY);
                System.out.println(board.getElement(oldX, oldY).getClass().toString());
            }
        }
    }

    public void doClick(int x, int y){
        if (!(temporaryElement.isMovePossible())) {
            temporaryElement = board.getElement(x, y);
            System.out.println(temporaryElement);
            oldX = x;
            oldY = y;
        }else {
           if (canMove(oldX, oldY, x, y)) {
                temporaryElement.setMovePossibility(false);
                board.moveElement(oldX, oldY, x, y);
                temporaryElement = new None(PlayerColor.NONE, false);
                oldX = -1;
                oldY = -1;
           }else {
               GameAlertBoxInt.display("Error", "Your move is invalid");
               oldX = -1;
               oldY = -1;
               temporaryElement = new None(PlayerColor.NONE, false);
           }
        }
        displayBoard();
    }

    private boolean canMove(int oldX, int oldY, int x, int y) {
        GameElement firstElement = board.getElement(oldX, oldY);
        GameElement secondElement = board.getElement(x, y);
        if (firstElement.getStrength()==3)
            return true;
        else if (firstElement.getStrength()>secondElement.getStrength())
            return true;
        else
            return false;
    }



    public void initGame(){
        board.initBoard();
    }
    public void setWhiteSoldier(int col, int row){
        board.setWhiteSoldier(col, row);
    }
    public void setBlackSoldier(int col, int row){
        board.setBlackSoldier(col, row);
    }
    public void setWhiteQueen(int col, int row){
        board.setWhiteQueen(col, row);
    }
    public void setBlackQueen(int col, int row){
        board.setBlackQueen(col, row);
    }
    public void setWhiteKing(int col, int row){
        board.setWhiteKing(col, row);
    }
    public void setBlackKing(int col, int row){
        board.setBlackKing(col, row);
    }
    public int calculateIncomeWhite(){
        return board.calculateIncomeWhite();
    }
    public int calculateIncomeBlack(){
        return board.calculateIncomeBlack();
    }
    public int calculateUpkeepWhite(){
        return board.calculateUpkeepWhite();
    }
    public int calculateUpkeepBlack(){
        return board.calculateUpkeepBlack();
    }

    public int calculateRealIncomeWhite() {
        return board.calculateRealIncomeWhite();
    }

    public void whiteAllDie() {
        board.whiteAllDie();
    }

    public int calculateRealIncomeBlack() {
        return board.calculateRealIncomeBlack();
    }
    public void calculateAll(){
        calculateIncomeWhite();
        calculateUpkeepWhite();
        calculateRealIncomeWhite();
        calculateIncomeBlack();
        calculateUpkeepBlack();
        calculateRealIncomeBlack();

    }

    public void blackAllDie() {
        board.blackAllDie();
    }
}

