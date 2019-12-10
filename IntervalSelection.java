import java.util.*;

class Solution{

   public static void main( String args[] ){

      Scanner in = new Scanner(System.in);

      int test;
      test = in.nextInt();

      for(int t=0; t<test; t++){

         int N;
         N = in.nextInt();

         int start = 0, end = 0;
         int[][] myIntervals = new int[N][2];
         for(int i=0; i<N; i++){
            start = in.nextInt();
            end = in.nextInt();
            myIntervals[i] = new int[]{start, end};
         }

         //Sort by end
         Arrays.sort(myIntervals, (a, b) -> a[1] - b[1]);
         int result = findMaxIntervals(myIntervals);
         System.out.println( result );

      }
   }

    static int findMaxIntervals(int[][] intervals) {

        int last = 0;
        int result = 1;
        int limit = 0;

        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] > intervals[last][1]) {
                last = i;
                result++;
            } else if(intervals[i][0] > limit) {
                limit = intervals[last][1];
                last = i;
                result++;
            }
        }

        return result;
    }
}
