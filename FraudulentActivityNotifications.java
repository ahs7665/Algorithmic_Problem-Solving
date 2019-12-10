import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int d = in.nextInt();

		int[] expenditures = new int[n];
		for (int i = 0; i < n; i++) {
			expenditures[i] = in.nextInt();
		}

		System.out.print(fraudulentNotifications(expenditures, d));
		in.close();
	}

	private static long fraudulentNotifications(int[] expenditures, int d) {
		int[] counter = new int[201];
		int i = 0, j = d;

		for (; i < j; i++) {
			counter[expenditures[i]] += 1;
		}
		i = 0;

		long notifications = 0;
    int medianPosition = (d % 2 != 0) ? (d / 2) + 1 : d / 2;

		while (j < expenditures.length) {
			double median = getMedian(counter, d, medianPosition);
			if (expenditures[j] >= (median * 2)) {
				notifications += 1;
			}
			counter[expenditures[i]] -= 1;
			counter[expenditures[j]] += 1;
			i++; j++;
		}

		return notifications;
	}

  private static double getMedian(int[] countSort, int d, int medianPosition) {
    int count = 0, i = 0, j = 0;

		for (; count < medianPosition; i++) {
			count += countSort[i];
		}

    j = i;
    i -= 1;

		if (count > medianPosition || d % 2 != 0)
      return i;

		for (; countSort[j] == 0; j++);

		return (i + j) / 2d;
	}
}
