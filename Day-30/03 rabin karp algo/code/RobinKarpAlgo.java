public class RobinKarpAlgo {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        if (m == 0) return 0;
        if (n < m) return -1;

        MyHash needleHashObj = new MyHash(needle);
        MyHash haystackHashObj = new MyHash(haystack);

        MyHash.WindowHash wh = haystackHashObj.initializeWindowHash(m);

        long needleHash = needleHashObj.getHash();

        while (true) {

            if (wh.getHash() == needleHash) {
                int start = wh.getStart();

                // Verify to avoid hash collision
                if (haystack.regionMatches(start, needle, 0, m)) {
                    return start;
                }
            }

            if (!wh.hasNext()) {
                break;
            }

            wh.getNextHash();
        }

        return -1;
    }
}


class MyHash {

    private static final long MOD = 1_000_000_007L;
    private static final long BASE = 26L;

    private final String text;

    public MyHash(String text) {
        this.text = text;
    }

    public long getHash() {
        long hash = 0;

        for (int i = 0; i < text.length(); i++) {
            int value = text.charAt(i) - 'a' + 1;
            hash = (hash * BASE + value) % MOD;
        }

        return hash;
    }

    public WindowHash initializeWindowHash(int windowSize) {
        return new WindowHash(windowSize);
    }

    public class WindowHash {

        private final int windowSize;
        private final long highestPower;

        private Long hash;
        private int start;

        private WindowHash(int windowSize) {
            this.windowSize = windowSize;
            this.start = 0;

            long power = 1;

            for (int i = 1; i < windowSize; i++) {
                power = (power * BASE) % MOD;
            }

            highestPower = power;
        }

        public long getHash() {

            if (hash == null) {

                hash = 0L;

                for (int i = 0; i < windowSize; i++) {
                    int value = text.charAt(i) - 'a' + 1;
                    hash = (hash * BASE + value) % MOD;
                }
            }

            return hash;
        }

        public boolean hasNext() {
            return start + windowSize < text.length();
        }

        public long getNextHash() {

            if (!hasNext()) {
                throw new IllegalStateException("No more windows");
            }

            int oldValue = text.charAt(start) - 'a' + 1;
            int newValue = text.charAt(start + windowSize) - 'a' + 1;

            hash = (hash - (oldValue * highestPower) % MOD + MOD) % MOD;
            hash = (hash * BASE + newValue) % MOD;

            start++;

            return hash;
        }

        public int getStart() {
            return start;
        }

        public String getWindow() {
            return text.substring(start, start + windowSize);
        }
    }
}