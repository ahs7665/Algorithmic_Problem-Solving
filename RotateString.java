class Solution {
    public boolean rotateString(String A, String B) {
        int N = A.length();
        int M = B.length();
        if (N != M) return false;
        if (N == 0) return true;

        //Compute prefix table
        int[] prefix = new int[N+1];
        for(int i = 0; i < prefix.length; i++) {
            prefix[i] = 1;
        }
        int left = -1;
        for (int right = 0; right < N; ++right) {
            while (left >= 0 && (B.charAt(left) != B.charAt(right)))
                left -= prefix[left];
            prefix[right + 1] = right - left++;
        }

        //Search pattern B in string A+A 
        int matchLen = 0;
        for (char c: (A+A).toCharArray()) {
            while (matchLen >= 0 && B.charAt(matchLen) != c)
                matchLen -= prefix[matchLen];
            if (++matchLen == N) return true;
        }

        return false;
    }
}
