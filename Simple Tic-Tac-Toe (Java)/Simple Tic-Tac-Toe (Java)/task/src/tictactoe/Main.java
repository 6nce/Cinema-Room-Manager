package tictactoe;
import java.util.Arrays;
import java.util.Scanner;
import java.io.*;
import java.util.*;


public class Main {

    public static void beginningBoard(char[] ch){
        System.out.println("---------");
        System.out.println("| " + ch[0] + " " + ch[1] + " " + ch[2] + " |");
        System.out.println("| " + ch[3] + " " + ch[4] + " " + ch[5] + " |");
        System.out.println("| " + ch[6] + " " + ch[7] + " " + ch[8] + " |");
        System.out.println("---------");
    }
    public static void printBoard(char[][] ch) {
        System.out.println("---------");
        System.out.println("| " + ch[0][0] + " " + ch[0][1] + " " + ch[0][2] + " |");
        System.out.println("| " + ch[1][0] + " " + ch[1][1] + " " + ch[1][2] + " |");
        System.out.println("| " + ch[2][0] + " " + ch[2][1] + " " + ch[2][2] + " |");
        System.out.println("---------");
    }

    public static boolean checkWinner(char[][] gameBoard){
        boolean gameOver = false;
        if (gameBoard[0][1] != ' ' && gameBoard[0][0] == gameBoard[0][1] && gameBoard[0][1] == gameBoard[0][2]){
            gameOver = true;
            return gameOver;
        }

        if (gameBoard[1][1] != ' ' && gameBoard[1][0] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[1][2]){
            gameOver = true;
            return gameOver;
        }

        if (gameBoard[2][1] != ' ' && gameBoard[2][0] == gameBoard[2][1] && gameBoard[2][1] == gameBoard[2][2]){
            gameOver = true;
            return gameOver;
        }

        if (gameBoard[1][0] != ' ' && gameBoard[0][0] == gameBoard[1][0] && gameBoard[1][0] == gameBoard[2][0]){
            gameOver = true;
            return gameOver;
        }

        if (gameBoard[1][1] != ' ' && gameBoard[0][1] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[2][1]){
            gameOver = true;
            return gameOver;
        }

        if (gameBoard[1][2] != ' ' && gameBoard[0][2] == gameBoard[1][2] && gameBoard[1][2] == gameBoard[2][2]){
            gameOver = true;
            return gameOver;
        }

        if (gameBoard[1][1] != ' ' && gameBoard[0][0] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[2][2]){
            gameOver = true;
            return gameOver;
        }
        if (gameBoard[1][1] != ' ' && gameBoard[2][2] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[2][0]){
            gameOver = true;
            return gameOver;
        }

        return gameOver;
    }

    public static void xTurn(char[][] gameBoard) {
        boolean validInput = true;
        while(validInput) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("X | Please enter coordinates for your next move. Format = 1 1");
            String turn = scanner.nextLine();

            //Digit Check
            if(!Character.isDigit(turn.charAt(0))) {
                System.out.println("You should enter numbers!");
                continue;
            } else if(!Character.isDigit(turn.charAt(2))){
                System.out.println("You should enter numbers!");
                continue;
            }

            char[] temp = turn.toCharArray();

            int row = Character.getNumericValue(temp[0]) - 1;
            int col = Character.getNumericValue(temp[2]) - 1;

            //Within Range Check
            if (row > 2 || row <= -1){
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            } else if (col > 2 || col <= -1){
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            }


            if (gameBoard[row][col] != 'X' && gameBoard[row][col] != 'O') {
                gameBoard[row][col] = 'X';
                break;
            } else {
                System.out.println("This cell is occupied! Choose another one!");
            }


        }
    }

    public static void oTurn(char[][] gameBoard) {
        boolean validInput = true;
        while(validInput) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("O | Please enter coordinates for your next move. Format = 1 1");
            String turn = scanner.nextLine();

            //Digit Check
            if(!Character.isDigit(turn.charAt(0))) {
                System.out.println("You should enter numbers!");
                continue;
            } else if(!Character.isDigit(turn.charAt(2))){
                System.out.println("You should enter numbers!");
                continue;
            }

            char[] temp = turn.toCharArray();

            int row = Character.getNumericValue(temp[0]) - 1;
            int col = Character.getNumericValue(temp[2]) - 1;

            //Within Range Check
            if (row > 2 || row <= -1){
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            } else if (col > 2 || col <= -1){
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            }

            if (gameBoard[row][col] != 'X' && gameBoard[row][col] != 'O') {
                gameBoard[row][col] = 'O';
                break;
            } else {
                System.out.println("This cell is occupied! Choose another one!");
            }


        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "         ";
        char[] ch = input.toCharArray();

        beginningBoard(ch);

        //Create 3x3 Array from Input
        char[][] gameBoard = new char[3][3];
        int indexNumber = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++){
                gameBoard[i][j] = ch[indexNumber];
                indexNumber ++;
            }
        }
        boolean gameOn = true;

        while (gameOn) {
            xTurn(gameBoard);
            printBoard(gameBoard);
            if (checkWinner(gameBoard)) {
                System.out.println("X wins");
                break;
            }
            oTurn(gameBoard);
            printBoard(gameBoard);
            if (checkWinner(gameBoard)) {
                System.out.println("O wins");
                gameOn = false;
                break;
            }
        }

    }
}