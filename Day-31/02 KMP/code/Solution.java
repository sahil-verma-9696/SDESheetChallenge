import java.util.ArrayList;
import java.util.List;

public class Solution {

    // Computes LPS (Longest Prefix Suffix) array
    public static int[] computeLPS(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m];

        int len = 0;
        int i = 1;

        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }

    // Returns all occurrences of pattern in text
    public static List<Integer> search(String text, String pattern) {
        List<Integer> ans = new ArrayList<>();

        int n = text.length();
        int m = pattern.length();

        if (m == 0) return ans;

        int[] lps = computeLPS(pattern);

        int i = 0; // text pointer
        int j = 0; // pattern pointer

        while (i < n) {

            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            }

            if (j == m) {
                ans.add(i - j);     // Match found
                j = lps[j - 1];     // Continue searching
            } else if (i < n && text.charAt(i) != pattern.charAt(j)) {

                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        String text = "ababcababc";
        String pattern = "abc";

        System.out.println(search(text, pattern)); // [2, 7]
    }
}