class Solution {
    public int strStr(String haystack, String needle){
    if (haystack == null || needle == null)
        return -1;
    //generate prefix table for the pattern (needle), need O(n) time
    int i = -1, j = 0, m = haystack.length(), n = needle.length();
    int[] next = new int[n];
    // The below code constructs the prefix table
    // Eg. Pattern:     a b a b d
    // Prefix Table:    -1 0 0 1 2
    if (next.length > 0)
        next[0] = -1;
    while (j < n - 1) {
        if (i == -1 || needle.charAt(i) == needle.charAt(j)) {
            next[++j] = ++i;
        } else {
            i = next[i];
        }
    }

    //check through the haystack using prefix table which allows us to skip the backtracking, need O(m) time
    i = 0; j = 0;
    while (i < m && j < n) {
        // j = -1 indicates that we have reached the starting point of needle hence we now have to move the haystack pointer forward
        if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
            i++;
            j++;
        }
        else
            j = next[j];
    }
    // if we j is the size of needle we found the patter match hence returning the index and returning.
    if (j == n)
        return i - j;
    // -1 indicates pattern not found
    return -1;
    }
}
