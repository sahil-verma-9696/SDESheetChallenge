
class Solution {

    void setZeroes(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;

        boolean fr = false; // first row flag
        boolean fc = false; // first column flag

        // Step 1: check first row
        for (int j = 0; j < c; j++) {
            if (matrix[0][j] == 0) {
                fr = true;
                break;
            }
        }

        // Step 2: check first column
        for (int i = 0; i < r; i++) {
            if (matrix[i][0] == 0) {
                fc = true;
                break;
            }
        }

        // Step 3: mark rest of matrix
        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Step 4: update matrix (excluding first row & col)
        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Step 5: handle first row
        if (fr == true) {
            for (int j = 0; j < c; j++) {
                matrix[0][j] = 0;
            }
        }

        // Step 6: handle first column
        if (fc == true) {
            for (int i = 0; i < r; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
