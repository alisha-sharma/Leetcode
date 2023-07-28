package backtracking;

import java.util.*;

public class SolveNQueenProblems {
    static List<List<String>> result;

    public static void main(String[] args) {
        int n = 4;
        System.out.println("Result is : " + solveNQueens(8));
    }

    public static List<List<String>> solveNQueens(int n) {

        result = new ArrayList<>();
        char[][] board = new char[n][n];

        //initialize an empty board;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        //create a list of integer array to keep track of positions where queen have been placed
        List<int[]> queens = new ArrayList<>();
        //call dfs starting with first row
        dfs(board, 0, queens);
        return result;

    }

    private static void dfs(char[][] board, int r, List<int[]> queens) {
        //let us first check if all queens have been placed
        if (queens.size() == board.length) {
            List<String> rows = new ArrayList<>();
            //all are placed then we need to format the output i.e,
            // get each character in a row in a string form
            for (char[] row : board) {
                rows.add(new String(row)); //create string from a char array in a row
            }
            //add rows to global result
            result.add(rows);
        }

        // if not then try to add queen for that row starting with initial column

        for (int c = 0; c < board.length; c++) {
            //check if we can add queen to column c of a given row r
            if (canAddQueen(board, r, c, queens)) {
                //update the board
                board[r][c] = 'Q';
                //update queens
                queens.add(new int[]{r, c});
                //when done with current row, move toward placing queen in another row
                dfs(board, r + 1, queens);

                //if we come at this stage, then it means we cannot completely add remaining queens
                //so need to change the position of recently added queen in the board so this is called backtracking
                board[r][c] = '.'; //update previous queen position with empty and try placing queen at other cols
                //need to remove previous queen position from queens array as well
                queens.remove(queens.size() - 1); //remove recently added value

            }
        }
    }

    /* Constraints
     cannot place two queens in same row, same column or diagonally */
    private static boolean canAddQueen(char[][] board, int r, int c, List<int[]> queens) {
        //with information from list of queens, adding queen to r, c satisfies the constraints with existing queens
        //need to check for each queen placed in queens
        for (int[] q : queens) {
            int xDiff = Math.abs(r - q[0]);  //difference in x
            int yDiff = Math.abs(c - q[1]);  //difference in y
            // if constraints fails return false;
            if (xDiff == 0 || yDiff == 0 || xDiff == yDiff) return false;
        }

        return true;
    }
}
