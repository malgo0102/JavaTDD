package tamas;

import java.util.Scanner;

public class App {
    static Scanner sc = new Scanner(System.in);
    private static int N = 8; // table size
    private static String[][] board = fillTable(N, "*"); // chessboard initialization
    static int column;

    public static void main(String[] args) {
        setup();
        // printTable();
        // start enumerating on the placement
        if (place(0))
            printTable();

    }

    // first queen placement by user
    public static void setup() {
        System.out.println("Set up the position for the first queen:\nRow number:");
        int row = sc.nextInt() - 1;
        System.out.println("Column number:");
        column = sc.nextInt() - 1; // saving column to global variable
        board[row][column] = "Q";
    }

    // table initializing script
    // making nxn array filled with s string(char)
    public static String[][] fillTable(int n, String s) {
        String[][] board = new String[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = s;
            }
        }
        return board;
    }

    // displaying the chessboard
    public static void printTable() {
        System.out.println();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

    }

    // check left side same row
    // return true for clean, false for collision
    public static boolean leftsiderow(String[][] board, int row, int col) {
        for (int i = 0; i < col; i++) {
            if (board[row][i] == "Q") {
                return false;
            }
        }
        return true;
    }

    // check right side same row
    // return true for clean, false for collision
    public static boolean rightsiderow(String[][] board, int row, int col) {
        for (int i = col; i < board.length; i++) {
            if (board[row][i] == "Q") {
                return false;
            }
        }
        return true;
    }

    // check upper right diagonal
    // return true for clean, false for collision
    public static boolean upRightDiagonal(String[][] board, int row, int col) {
        for (int i = row, j = col; j < board.length && i >= 0; i--, j++)
            if (board[i][j] == "Q")
                return false;
        return true;
    }

    // check upper Left diagonal
    // return true for clean, false for collision
    public static boolean upLeftDiagonal(String[][] board, int row, int col) {
        for (int i = row, j = col; j >= 0 && i >= 0; i--, j--)
            if (board[i][j] == "Q")
                return false;
        return true;
    }

    // check lower Left diagonal
    // return true for clean, false for collision
    public static boolean downLeftDiagonal(String[][] board, int row, int col) {
        for (int i = row, j = col; j >= 0 && i < board.length; i++, j--)
            if (board[i][j] == "Q")
                return false;
        return true;
    }

    // check lower right diagonal
    // return true for clean, false for collision
    public static boolean downRightDiagonal(String[][] board, int row, int col) {
        for (int i = row, j = col; j < board.length && i < board.length; i++, j++)
            if (board[i][j] == "Q")
                return false;
        return true;
    }

    // wrapper function for all the individual checks
    // returning true for safe placement else false
    public static boolean isSafe(int row, int col) {
        if (!leftsiderow(board, row, col) || !rightsiderow(board, row, col) || !upRightDiagonal(board, row, col)
                || !upLeftDiagonal(board, row, col) || !downLeftDiagonal(board, row, col)
                || !downRightDiagonal(board, row, col))
            return false;
        else
            return true;
    }

    // placement method using backtracking
    public static boolean place(int col) {
        if (col >= N)// return true if reached last col
            return true;
        if (col == column) {// skip col if it contains the first queen
            if (place(col + 1))// call next col
                return true;
            else
                return false;
        }

        for (int row = 0; row < N; row++) {// iterate through rows in the column
            if (isSafe(row, col)) {
                // if placement is safe place the queen
                board[row][col] = "Q";
                if (place(col + 1))// call next column
                    return true;
                else {
                    // take off queen
                    board[row][col] = "*";
                    // backtracking -->
                }

            }

        }
        return false;
    }

}
