import java.util.Scanner;

class Solution {
  public static void main(String args[]) {

    Scanner in = new Scanner(System.in);

    int test;
    test = in.nextInt();

    for (int t = 0; t < test; t++) {

      int N = in.nextInt();
      int G = in.nextInt();
      int robber[] = new int[N];
        int total = 0;
      for (int i = 0; i < N; ++i) {
        robber[i] = in.nextInt();
          total += robber[i];
      }
        if(total > (G<<1)){
            System.out.println("NO");
            continue;
        }

      int knapsack[][] = new int[N + 1][G + 1];
      for (int i = 0; i <= N; ++i) {
        for (int j = 0; j <= G; ++j) {
          if (i == 0 || j == 0) {
            knapsack[i][j] = 0;
            continue;
          } else if (robber[i - 1] > j) {
            knapsack[i][j] = knapsack[i - 1][j];
          } else {
            knapsack[i][j] = Math.max(knapsack[i - 1][j], knapsack[i - 1][j - robber[i - 1]] + robber[i - 1]);
          }
        }
      }

      System.out.println((total-knapsack[N][G]) <= G ? "YES" : "NO");
    }
    in.close();
  }
}
