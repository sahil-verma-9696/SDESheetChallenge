
class Solution {

    void rotate(int[][] matrix) {

        reverse(matrix);
        transpose(matrix);

    }

    void transpose(int[][] mat) {
        int r = mat.length;
        int c = mat[0].length;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (i < j) {
                    int t = mat[i][j];
                    mat[i][j] = mat[j][i];
                    mat[j][i] = t;
                }
            }
        }
    }

    void reverse(int[][] mat) {
        int n = mat.length;

        int i = 0;
        int j = n - 1;

        while (i < j) {
            int[] t = mat[i];
            mat[i] = mat[j];
            mat[j] = t;

            i++;
            j--;
        }
    }
}
