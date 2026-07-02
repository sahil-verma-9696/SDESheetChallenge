
class Solution {

    public int compareVersion(String version1, String version2) {
        return optimal(version1, version2);
    }

    public int splitMethod(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int maxLength = Math.max(v1.length, v2.length);

        for (int i = 0; i < maxLength; i++) {

            int rev1 = (i < v1.length) ? Integer.parseInt(v1[i]) : 0;
            int rev2 = (i < v2.length) ? Integer.parseInt(v2[i]) : 0;

            if (rev1 < rev2) {
                return -1;
            } else if (rev1 > rev2) {
                return 1;
            }
        }

        return 0;
    }

    public int optimal(String ver1, String ver2) {

        int n = ver1.length();
        int m = ver2.length();

        int rev1 = 0;
        int rev2 = 0;

        int i = 0;
        int j = 0;

        while (i < n || j < m) {

            rev1 = 0;
            while (i < n && ver1.charAt(i) != '.') {
                char ch = ver1.charAt(i);
                int intCh = ch - '0';
                rev1 = rev1 * 10 + intCh;
                i++;
            }
            i++;

            rev2 = 0;
            while (j < m && ver2.charAt(j) != '.') {
                char ch = ver2.charAt(j);
                int intCh = ch - '0';
                rev2 = rev2 * 10 + intCh;
                j++;
            }
            j++;

            System.out.println("rev1 = " + rev1 + " rev2 = " + rev2);

            if (rev1 < rev2) {
                return -1;
            }

            if (rev1 > rev2) {
                return 1;
            }
        }

        return 0;
    }
}
