import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {


	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int size = in.nextInt();
		int containers[] = new int[size];
		int nimSum = 0;
		for (int i = 0; i < size; i++) {
			containers[i] = in.nextInt();
			nimSum = nimSum ^ containers[i];
		}

		int count = 0;
    //If nim sum is 0, then there is no way for Player A to win
		if (nimSum == 0) {
        System.out.println(count);
    } else {
  			for (int chocolates : containers) {
  				nimSum = nimSum ^ chocolates;
  				if (chocolates >= nimSum) {
              count++;
          }
  				nimSum = nimSum ^ chocolates;
			}
			System.out.println(count);
		}
	}
}
