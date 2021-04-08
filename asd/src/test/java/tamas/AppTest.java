package tamas;

import org.junit.Assert;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void test_fillTable() {
        int n = 8;
        String[][] board = App.fillTable(n, "*");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Assert.assertEquals("*", board[i][j]);
            }
        }
    }

    @Test
    public void test_leftsiderow_collision() {
        // Assign
        String[][] board = App.fillTable(8, "*");
        board[1][3] = "Q";
        // Act
        boolean actual = App.leftsiderow(board, 1, 4);
        // Assert
        Assert.assertFalse(actual);
    }

    @Test
    public void test_leftsiderow_safe() {
        // Assign
        String[][] board = App.fillTable(8, "*");
        // board[1][3] = "Q";
        // Act
        boolean actual = App.leftsiderow(board, 1, 4);
        // Assert
        Assert.assertTrue(actual);
    }

    @Test
    public void test_rightsiderow_collision() {
        // Assign
        String[][] board = App.fillTable(8, "*");
        board[1][3] = "Q";
        // Act
        boolean actual = App.rightsiderow(board, 1, 0);
        // Assert
        Assert.assertFalse(actual);
    }

    @Test
    public void test_rightsiderow_safe() {
        // Assign
        String[][] board = App.fillTable(8, "*");
        board[0][1] = "Q";
        // Act
        boolean actual = App.rightsiderow(board, 0, 4);
        // Assert
        Assert.assertTrue(actual);
    }

    @Test
    public void test_uprightdiagonal_safe() {
        // Assign
        String[][] board = App.fillTable(8, "Q");
        board[4][4] = "*";
        board[3][5] = "*";
        board[2][6] = "*";
        board[1][7] = "*";
        // Act
        boolean actual = App.upRightDiagonal(board, 4, 4);
        // Assert
        Assert.assertTrue(actual);
    }

    @Test
    public void test_uprightdiagonal_collision() {
        // Assign
        String[][] board = App.fillTable(8, "*");
        board[3][6] = "Q";
        // Act
        boolean actual = App.upRightDiagonal(board, 4, 5);
        // Assert
        Assert.assertFalse(actual);
    }

    @Test
    public void test_upleftdiagonal_safe() {
        // Assign
        String[][] board = App.fillTable(8, "Q");
        board[4][4] = "*";
        board[3][3] = "*";
        board[2][2] = "*";
        board[1][1] = "*";
        board[0][0] = "*";
        // Act
        boolean actual = App.upLeftDiagonal(board, 4, 4);
        // Assert
        Assert.assertTrue(actual);
    }

    @Test
    public void test_upleftdiagonal_collision() {
        // Assign
        String[][] board = App.fillTable(8, "*");
        board[3][3] = "Q";
        // Act
        boolean actual = App.upLeftDiagonal(board, 4, 4);
        // Assert
        Assert.assertFalse(actual);
    }

    @Test
    public void test_downleftdiagonal_collision() {
        // Assign
        String[][] board = App.fillTable(8, "*");
        board[5][3] = "Q";
        // Act
        boolean actual = App.downLeftDiagonal(board, 4, 4);
        // Assert
        Assert.assertFalse(actual);
    }

    @Test
    public void test_downleftdiagonal_safe() {
        // Assign
        String[][] board = App.fillTable(8, "Q");
        board[7][1] = "*";
        board[6][2] = "*";
        board[5][3] = "*";
        board[4][4] = "*";
        // Act
        boolean actual = App.downLeftDiagonal(board, 4, 4);

        // Assert
        Assert.assertTrue(actual);
    }

    @Test
    public void test_downrightdiagonal_safe() {
        // Assign
        String[][] board = App.fillTable(8, "Q");
        board[7][7] = "*";
        board[6][6] = "*";
        board[5][5] = "*";
        board[4][4] = "*";
        // Act
        boolean actual = App.downRightDiagonal(board, 4, 4);

        // Assert
        Assert.assertTrue(actual);
    }

    @Test
    public void test_downrightdiagonal_collision() {
        // Assign
        String[][] board = App.fillTable(8, "*");
        board[7][7] = "Q";

        // Act
        boolean actual = App.downRightDiagonal(board, 0, 0);

        // Assert
        Assert.assertFalse(actual);
    }
}
