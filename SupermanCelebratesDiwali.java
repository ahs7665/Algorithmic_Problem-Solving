import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        Pattern p = Pattern.compile("\\s+");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] split = p.split(reader.readLine());
            int N = Integer.parseInt(split[0]);
            int H = Integer.parseInt(split[1]);
            int I = Integer.parseInt(split[2]) - 1;

            int[][] houses = new int[N][H];
            for (int i = 0; i < N; i++) {
                split = p.split(reader.readLine());
                for (int j = 1; j < split.length; j++) {
                    houses[i][Integer.parseInt(split[j]) - 1]++;
                }
            }
            long[][] dp = new long[H + 1][N];
            for (int h = 0; h < H; h++) {
                long maxResult = 0;
                if (h >= I) {
                       for (int another = 0; another < N; another++) {
                           maxResult = Math.max(maxResult, dp[h - I][another]);
                       }
                   }
                for (int n = 0; n < N; n++) {
                   long result = dp[h][n];
                    dp[h + 1][n] = Math.max(result, maxResult) + houses[n][h];
                }
            }
            long result = 0;
            for (long m : dp[H]) {
                result = Math.max(result, m);
            }
            System.out.println(result);
        }
    }
}
