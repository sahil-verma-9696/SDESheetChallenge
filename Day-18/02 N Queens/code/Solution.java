import  java.util.*;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();

        // Preparing board
        List<StringBuilder> board = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < n; j++) {
                row.append(".");
            }

            board.add(row);
        }

        recur(0, n, board, ans);

        return ans;
    }

    // q =  row, j = col
    public void recur(int q, int n, List<StringBuilder> board, List<List<String>> ans) {

        if (q == n) {
            ArrayList<String> boar = new ArrayList<>();

            for (StringBuilder row : board) {
                boar.add(row.toString());
            }

            ans.add(boar);
            return;
        }

        for (int i = 0; i < n; i++) {

            if (isSafe(q, i, n, board)) {

                board.get(q).setCharAt(i, 'Q');

                recur(q + 1, n, board, ans);

                // Backtrack
                board.get(q).setCharAt(i, '.');
            }

        }

    }

    public boolean isSafe(int row, int col, int n, List<StringBuilder> board) {

        // Check same column upwards
        for (int i = 0; i < row; i++) {
            if (board.get(i).charAt(col) == 'Q')
                return false;
        }

        // Upper-left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board.get(i).charAt(j) == 'Q')
                return false;
        }

        // Upper-right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board.get(i).charAt(j) == 'Q')
                return false;
        }

        return true;
    }
}