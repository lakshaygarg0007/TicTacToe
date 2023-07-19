package com.lavakumar.tictactoe;

import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static int row = 3;
    public static int column = 3;
    public static  Scanner scanner = new Scanner(System.in);
    public static Board boardObject = new Board(row, column);
    public static String[][] board = boardObject.getBoard();
    public static void main(String [] args) throws Exception {
        String playerName1, playerName1Character;
        System.out.println("Enter Player 1 Name : ");
        playerName1 = scanner.nextLine();
        System.out.println("Enter Player 1 Character : ");
        playerName1Character = scanner.nextLine();
        playerName1Character = Objects.equals(playerName1Character, "") ? "X" : playerName1Character;
        String playerName2, playerName2Character;
        System.out.println("Enter Player 2 Name : ");
        playerName2 = scanner.nextLine();
        System.out.println("Enter Player 2 Character : ");
        playerName2Character = scanner.nextLine();
        playerName2Character = Objects.equals(playerName2Character, "") ? "O" : playerName2Character;

        Player player1 = new Player(playerName1, playerName1Character);
        Player player2 = new Player(playerName2, playerName2Character);

        startGame(player1, player2);
    }

    static void printBoard() {
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < column; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void setPositionInBoard(String nextMove, String character) throws Exception {
        try {
            boardObject.setPosition(nextMove, character);
        } catch (Exception e) {
            System.out.println("Please Select Correct Move !!!!");
        }
    }

    public static void startGame(Player player1, Player player2) throws Exception {
        System.out.println("Starting the Game");
        int turnFlag = 0;

        while(true) {
            String playerCharacter;
            printBoard();
            if(turnFlag == 0) {
                System.out.println(player1.getName() + "'s Turn");
                playerCharacter = player1.getCharacter();
            } else {
                System.out.println(player2.getName() + "'s Turn");
                playerCharacter = player2.getCharacter();
            }

            System.out.println("Please Provide Next Move");
            String nextMove = scanner.nextLine();
            setPositionInBoard(nextMove, playerCharacter);

            if(Boolean.TRUE == checkIfWinner(playerCharacter)) {
                String msg = turnFlag == 0 ? player1.getName() + " has won the Game" :
                        player2.getName() +  " has won the Game";
                printBoard();
                System.out.println(msg);
                return;
            } else {
                turnFlag = turnFlag == 0 ? 1 : 0;
            }
        }

    }

    static Boolean checkIfWinner(String character) {
        boolean checkIfWinner = true;

        for(int k = 0; k < row; k++) {
            for (int i = 0; i < column; i++) {
                if (!character.equals(board[k][i])) {
                    checkIfWinner = false;
                    break;
                }
            }
            if(checkIfWinner) {
                return true;
            } else {
                checkIfWinner = true;
            }
        }

        for(int k = 0; k < column; k++) {
            for (int i = 0; i < row; i++) {
                if (!character.equals(board[i][k])) {
                    checkIfWinner = false;
                    break;
                }
            }
            if(checkIfWinner) {
                return true;
            } else {
                checkIfWinner = true;
            }
        }

        for(int i = 0; i < row; i++) {
            if(!character.equals(board[i][i])) {
                checkIfWinner = false;
                break;
            }
        }

        if(checkIfWinner) {
            return true;
        } else {
            checkIfWinner = true;
        }

        for(int i = column - 1; i >= 0; i--) {
            if(!character.equals(board[row - (i + 1)][i])) {
                checkIfWinner = false;
                break;
            }
        }

        return checkIfWinner;
    }
}
