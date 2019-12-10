import java.util.*;
import java.io.*;

class Main {	
	public static int minSubArraySouth(int arr[][], int start, int col,  int n) {
		int sum = arr[col][start], ans = arr[col][start];
		for (int i = start+1; i < n; i++) {
			sum = sum + arr[col][i];
			if (ans > sum) {
				ans = sum;
			}
		}
		return ans;
	}
	public static int minSubArrayNorth(int arr[][], int start, int col,  int n) {
		int sum = arr[col][start], ans = arr[col][start];
		for (int i = start-1; i >=0; i--) {
			sum = sum + arr[col][i];
			if (ans > sum) {
				ans = sum;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- !=0) {
		int n = sc.nextInt();
		int m = sc.nextInt();
		int arr[][] = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		int southArr[][] = new int[n][m];
		for (int j = 0; j < m; j++) {
			southArr[n-1][j] = arr[n-1][j];
			for (int i = n-2; i>=0; i--) {
				if (southArr[i+1][j] + arr[i][j] < arr[i][j] ) {
					southArr[i][j] = southArr[i+1][j] + arr[i][j];
				} else {
					southArr[i][j] = arr[i][j];
				}
			}
		}

		int northArr[][] = new int[n][m];
		for (int j = 0; j < m; j++) {
			northArr[0][j] = arr[0][j];
			for (int i = 1; i<n; i++) {
				if (northArr[i-1][j] + arr[i][j] < arr[i][j] ) {
					northArr[i][j] = northArr[i-1][j] + arr[i][j];
				} else {
					northArr[i][j] = arr[i][j];
				}
			}
		}


		int westArr[][] = new int[n][m];
		for (int i = 0; i < n; i++) {
			westArr[i][0] = arr[i][0];
			for (int j = 1; j < m; j++) {
				if (westArr[i][j-1] + arr[i][j] < arr[i][j]) {
					westArr[i][j] = westArr[i][j-1] + arr[i][j];
				} else {
					westArr[i][j] = arr[i][j];
				}
			}
		}

		int eastArr[][] = new int[n][m];
		for (int i = 0; i < n; i++) {
			eastArr[i][m-1] = arr[i][m-1];
			for (int j = m-2; j >=0; j--) {
				if (eastArr[i][j+1] + arr[i][j] < arr[i][j]) {
					eastArr[i][j] = eastArr[i][j+1] + arr[i][j];
				} else {
					eastArr[i][j] = arr[i][j];
				}
			}
		}

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int sum = northArr[i][j] + southArr[i][j] + eastArr[i][j] + westArr[i][j] - 3*arr[i][j];
				if (sum < min) {
					min = sum;
				}
			}
		}
		System.out.println(min);

		}
		sc.close();
	}
}
