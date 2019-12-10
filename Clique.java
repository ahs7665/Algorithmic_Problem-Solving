import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int test=0;test<t;test++){
            int vertices=sc.nextInt();
            int edges=sc.nextInt();
            int low=1, high=vertices;
            low = sol.binarySearch(low, high, edges, vertices);
            System.out.println(low);
        }
    }

    public int binarySearch(int low, int high, int edges, int v) {
        while(low < high) {
            int mid = low +(high-low)/2;
            if(edges <= ((v*v)-(v%mid)*Math.pow(Math.ceil((1.0*v)/mid),2)-(mid-(v%mid))*(v/mid)*(v/mid))/2) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
