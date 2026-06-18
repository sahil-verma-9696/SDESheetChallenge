class Solution {

    public void solveSudoku(char[][] board) {
        recur(board);
    }

    private boolean recur(char[][] board) {

        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {

                if(board[i][j] == '.') {

                    for(char ch = '1'; ch <= '9'; ch++) {

                        if(isPossible(i, j, ch, board)) {

                            board[i][j] = ch;

                            if(recur(board))
                                return true;

                            board[i][j] = '.';
                        }
                    }

                    return false;
                }
            }
        }

        return true;
    }

    private boolean isPossible(int x, int y, char ch, char[][] board) {

        for(int i = 0; i < 9; i++) {

            if(board[x][i] == ch)
                return false;

            if(board[i][y] == ch)
                return false;
        }

        int subX = (x / 3) * 3;
        int subY = (y / 3) * 3;

        for(int i = subX; i < subX + 3; i++) {
            for(int j = subY; j < subY + 3; j++) {
                if(board[i][j] == ch)
                    return false;
            }
        }

        return true;
    }
}