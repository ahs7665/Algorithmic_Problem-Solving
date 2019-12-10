import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }

        char[] operators = new char[n - 1];

        boolean[][] memo = new boolean[101][operators.length];
        solve(nums, operators, memo, nums[0],  0);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < operators.length; i++) {
            sb.append(nums[i]);
            sb.append(operators[i]);
        }

        sb.append(nums[nums.length - 1]);
        System.out.println(sb.toString());
    }


    public static boolean solve(int[] nums, char[] operators, boolean[][] memo, int currResult, int pos) {
        currResult = currResult % 101;
        while (currResult < 0) currResult += 101;

        if (currResult == 0) {
            while (pos < operators.length) {
                operators[pos++] = '*';
            }
            return true;
        }

        if (pos == operators.length) return false;

        if (memo[currResult][pos]) {
            return false;
        }

        int next = nums[pos + 1];

        int addRes = currResult + next;
        operators[pos] = '+';
        if (solve(nums, operators, memo, addRes, pos + 1)) return true;

        int subRes = currResult - next;
        operators[pos] = '-';
        if (solve(nums, operators, memo, subRes, pos + 1)) return true;

        int mulRes = currResult * next;
        operators[pos] = '*';
        if (solve(nums, operators, memo, mulRes, pos+1)) return true;

        memo[currResult][pos] = true;
        return false;
    }
}
