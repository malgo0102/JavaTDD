package tamas;

import java.util.Scanner;

public class App {
    static Scanner sc = new Scanner(System.in);
    private static int N = 8;
    private static String[][] board = fillTable(N, "*");

    public static void main(String[] args) {
        setup();
        printTable();
        place(0);
        printTable();

    }

    public static void setup() {
        System.out.println("Set up the position for the first queen:\nRow number:");
        int row = sc.nextInt() - 1;
        System.out.println("Column number:");
        int column = sc.nextInt() - 1;
        board[row][column] = "Q";
    }

    public static int add(int x, int y) {
        return x + y;

    }

    public static String[][] fillTable(int n, String s) {
        String[][] board = new String[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = s;
            }
        }
        return board;
    }

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

    public static boolean leftsiderow(String[][] board, int row, int col) {
        for (int i = 0; i < col; i++) {
            if (board[row][i] == "Q") {
                return false;
            }
        }
        return true;
    }

    public static boolean rightsiderow(String[][] board, int row, int col) {
        for (int i = col; i < board.length; i++) {
            if (board[row][i] == "Q") {
                return false;
            }
        }
        return true;
    }

    public static boolean upRightDiagonal(String[][] board, int row, int col) {
        for (int i = row, j = col; j < board.length && i >= 0; i--, j++)
            if (board[i][j] == "Q")
                return false;
        return true;
    }

    public static boolean upLeftDiagonal(String[][] board, int row, int col) {
        for (int i = row, j = col; j >= 0 && i >= 0; i--, j--)
            if (board[i][j] == "Q")
                return false;
        return true;
    }

    public static boolean downLeftDiagonal(String[][] board, int row, int col) {
        for (int i = row, j = col; j >= 0 && i < board.length; i++, j--)
            if (board[i][j] == "Q")
                return false;
        return true;
    }

    public static boolean downRightDiagonal(String[][] board, int row, int col) {
        for (int i = row, j = col; j < board.length && i < board.length; i++, j++)
            if (board[i][j] == "Q")
                return false;
        return true;
    }

    public static boolean isSafe(int row, int col){
        if (!leftsiderow(board,row,col) ||
                !rightsiderow(board,row,col) ||
                !upRightDiagonal(board,row,col) ||
                !upLeftDiagonal(board,row,col) ||
                !downLeftDiagonal(board,row,col) ||
                !downRightDiagonal(board,row,col))
            return false;
        else
            return true;
    }

    public static boolean place(int col) {
        if (col >= N)
            return true;
        for(int row = col; row < N; row++) {
            if (board[row][col] == "Q")
                if (place(col+1))
                    return true;
                else
                    return false;
        }
        for(int row=0; row < N; row++){
            if(isSafe(row,col)){
                board[row][col] = "Q";
                if(place(col+1))
                    return true;
                else

                    //board[row][col] = "*";
                    return false;
            }
            else
                return false;
        }
        return true;
    }

}
