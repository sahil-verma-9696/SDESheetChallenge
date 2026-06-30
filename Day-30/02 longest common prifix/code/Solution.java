import java.util.*;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        String ref = strs[0];
        int minLen = strs[0].length();
        int n = strs.length;

        if (n == 1)
            return strs[0];

        for (int i = 0; i < n; i++) {
            if (strs[i].length() < minLen) {
                ref = strs[i];
                minLen = strs[i].length();
            }
        }

        int p = 0;

        for (String s : strs) {

            int i = 0;
            while (i < minLen) {
                if (s.charAt(i) != ref.charAt(i)) {
                    if (p == 0) {
                        p = i;
                    } else {
                        p = Math.min(p, i);
                    }
                    break;
                }
                i++;
            }

            if (i == minLen && p == 0)
                p = i;
            if (i == 0)
                break;

        }

        // System.out.println(p);

        return p == 0 ? "" : ref.substring(0, p);
    }


    /**
        time : O(n * (number of match character))
        space : O(1);
     */

    private String bruteForce(String[] strs) {
        String ref = strs[0];
        int minLen = strs[0].length();
        int n = strs.length;

        if (n == 1)
            return strs[0];

        for (int i = 0; i < n; i++) {
            if (strs[i].length() < minLen) {
                ref = strs[i];
                minLen = strs[i].length();
            }
        }

        int p = 0;

        for (String s : strs) {

            int i = 0;
            while (i < minLen) {
                if (s.charAt(i) != ref.charAt(i)) {
                    if (p == 0) {
                        p = i;
                    } else {
                        p = Math.min(p, i);
                    }
                    break;
                }
                i++;
            }

            if (i == minLen && p == 0)
                p = i;
            if (i == 0)
                break;

        }

        // System.out.println(p);

        return p == 0 ? "" : ref.substring(0, p);
    }


    /**
     * Step 
     * 
     * 1. Sort lexicographically
     * 2. Compare first and last
     * 
     */

    /**
        time : O(n * lon n)
        space : O(1);
     */
    private String optimal(String[] v) {
        StringBuilder ans = new StringBuilder();
        Arrays.sort(v);
        String first = v[0];
        String last = v[v.length - 1];
        for (int i = 0; i < Math.min(first.length(), last.length()); i++) {
            if (first.charAt(i) != last.charAt(i)) {
                return ans.toString();
            }
            ans.append(first.charAt(i));
        }
        return ans.toString();
    }

}