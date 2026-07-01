import java.util.Arrays;

public class Solution {

    // Returns the Z-array
    public static int[] zFunction(String s) {
        int n = s.length();
        int[] z = new int[n];

        int l = 0, r = 0;

        for (int i = 1; i < n; i++) {

            // If i is inside current Z-box
            if (i <= r) {
                z[i] = Math.min(r - i + 1, z[i - l]);
            }

            // Try to extend the match
            while (i + z[i] < n && s.charAt(z[i]) == s.charAt(i + z[i])) {
                z[i]++;
            }

            // Update the Z-box if extended further
            if (i + z[i] - 1 > r) {
                l = i;
                r = i + z[i] - 1;
            }
        }

        return z;
    }

    public static void main(String[] args) {
        String s = "aabcaabxaaaz";
        int[] z = zFunction(s);

        System.out.println(Arrays.toString(z));
    }
}