package com.lavakumar.tictactoe;

public class Board {
    private int row;
    private int column;
    private final String[][] board;

    public String[][] getBoard() {
        return board;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public Board(int row, int column) {
        this.row = row;
        this.column = column;
        board = new String[row][column];
        setBoardValues();
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getPositionX(String move) {
        String xPosition = move.substring(0, 1);
        switch (xPosition) {
            case "A":
                return 0;
            case "B":
                return 1;
            case "C":
                return 2;
            default:
                return -1;
        }

    }

    public int getPositionY(String move) {
        String yPosition = move.substring(1, 2);
        switch (yPosition) {
            case "1":
                return 0;
            case "2":
                return 1;
            case "3":
                return 2;
            default:
                return -1;
        }

    }

    public void setPosition(String move, String character) throws Exception {
        int x = getPositionX(move);
        int y = getPositionY(move);

        if(x == -1 || y == -1) {
            throw new Exception("Wrong Command");
        } else {
            this.board[x][y] = character;
        }
    }

    public void setBoardValues() {
        for(int i = 0; i < column; i++) {
            board[0][i] = "A" + (i + 1);
        }

        for(int i = 0; i < column; i++) {
            board[1][i] = "B" + (i + 1);
        }

        for(int i = 0; i < column; i++) {
            board[2][i] = "C" + (i + 1);
        }
    }

}
