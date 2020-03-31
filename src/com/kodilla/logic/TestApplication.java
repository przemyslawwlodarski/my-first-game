package com.kodilla.logic;

public class TestApplication {
    public static void main(String[] args) {
        Board board = new Board();
        board.setElement(2,5, new Soldier(PlayerColor.WHITE));
        System.out.println(board);
        System.out.println(board.getElement(2,5));
        board.removeElement(2,5);
//        System.out.println(board);
//        board.setElement(2,6, new Soldier(PlayerColor.WHITE));
        board.moveElement(2,5, new Soldier (PlayerColor.WHITE), 2,4);
        System.out.println(board);
    }
}
