class Solution {

    private final int BASE = 1_000_000;

    public int repeatedStringMatch(String A, String B) {
        if (A.equals(B)) return 1;

        int count = 1;
        StringBuilder source = new StringBuilder(A);

        while (source.length() < B.length()) {
            source.append(A);
            count++;
        }

        String src = source.toString();

        if (src.equals(B))
            return count;

        if (rabinKarp(src, B) != -1)
            return count;

        if (rabinKarp(src + A, B) != -1)
            return count + 1;

        return -1;
    }

    private int rabinKarp(String source, String target) {
        if (source.isEmpty() || target.isEmpty())
            return -1;

        int m = target.length();

        int power = 1;
        for (int i = 0; i < m; i++) {
            power = (power * 31) % BASE;
        }

        int targetHash = 0;
        for (int i = 0; i < m; i++) {
            targetHash = (targetHash * 31 + target.charAt(i)) % BASE;
        }

        int hash = 0;

        for (int i = 0; i < source.length(); i++) {

            hash = (hash * 31 + source.charAt(i)) % BASE;

            if (i < m - 1)
                continue;

            if (i >= m) {
                hash = (hash - source.charAt(i - m) * power) % BASE;
            }

            if (hash < 0)
                hash += BASE;

            if (hash == targetHash) {
                if (source.substring(i - m + 1, i + 1).equals(target)) {
                    return i - m + 1;
                }
            }
        }

        return -1;
    }
}