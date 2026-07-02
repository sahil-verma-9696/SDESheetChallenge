class Solution {
    public String countAndSay(int n) {
        String ans = "";

        ans = iterative(n);

        return ans;
    }

    public String recursion(int n) {
        if (n == 1)
            return "1";

        String msg = recursion(n - 1);

        int cfreq = 0;
        char e = msg.charAt(0);

        String RLE = "";

        for (int i = 0; i < msg.length(); i++) {
            char ch = msg.charAt(i);

            if (e == ch) {
                cfreq++;
            } else {

                RLE += String.valueOf(cfreq) + String.valueOf(e);

                e = ch;
                cfreq = 1;
            }
        }

        RLE += String.valueOf(cfreq) + String.valueOf(e);

        return RLE;
    }

    public String iterative(int n) {

        String msg = "1";

        if(n == 1) return msg;


        for (int k = 2; k <= n; k++) {
            String RLE = "";
            
            int cfreq = 0;
            char e = msg.charAt(0);


            for (int i = 0; i < msg.length(); i++) {
                char ch = msg.charAt(i);

                if (e == ch) {
                    cfreq++;
                } else {

                    RLE += String.valueOf(cfreq) + String.valueOf(e);

                    e = ch;
                    cfreq = 1;
                }
            }

            RLE += String.valueOf(cfreq) + String.valueOf(e);

            msg = RLE;
        }

        return msg;
    }
}
