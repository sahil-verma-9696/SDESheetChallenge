class Solution {
    public String reverseWords(String s) {
        int n = s.length();

        StringBuilder mutableS = new StringBuilder(s);

        reverse(0, n - 1, mutableS);

        int r = 0;
        int l = 0;

        while (l < n) {
            if (mutableS.charAt(l) == ' ') {
                reverse(r, l - 1, mutableS);
                r = l + 1;
            }

            l++;
        }
        reverse(r, l - 1, mutableS);

        normalizeSpaces(mutableS);

        return mutableS.toString();
    }

    private void reverse(int s, int e, StringBuilder str) {

        if (s == e)
            return;

        while (s <= e) {
            char temp = str.charAt(s);
            str.setCharAt(s, str.charAt(e));
            str.setCharAt(e, temp);

            s++;
            e--;
        }

        return;
    }

    private void normalizeSpaces(StringBuilder sb) {
        int n = sb.length();
        int read = 0;
        int write = 0;

        // Skip leading spaces
        while (read < n && sb.charAt(read) == ' ')
            read++;

        while (read < n) {

            // Copy current word
            while (read < n && sb.charAt(read) != ' ') {
                sb.setCharAt(write++, sb.charAt(read++));
            }

            // Skip extra spaces
            while (read < n && sb.charAt(read) == ' ')
                read++;

            // Add a single space if another word exists
            if (read < n)
                sb.setCharAt(write++, ' ');
        }

        // Resize StringBuilder
        sb.setLength(write);
    }
}
