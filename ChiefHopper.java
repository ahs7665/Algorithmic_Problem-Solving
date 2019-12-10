import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] height = new int[N+1];
        height[0]=0;

        for (int i=1; i<N+1; i++){
            height[i] = in.nextInt();
        }

        int energy = 0;
        for (int i=N; i>=1; i--){
            energy = (energy + height[i] + 1)/2;
        }
        System.out.println(energy);

    }
}
