import java.util.Scanner;


public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
    Solution sol = new Solution();

		int T = sc.nextInt();

		for(int i = 0; i < T; i++){
			int N = sc.nextInt();
			long [] a = new long[N];

			for(int j = 0; j < N; j++){
				a[j] = sc.nextLong();
			}
			long [] tmp = new long[a.length];
			long inv = sol.mergeSort(a,tmp,0,a.length-1);
			System.out.println(inv);
		}
	}


	private long mergeSort(long [] a,long [] tmp,int left,int right){
		long inv = 0;

		if(left < right){
			int mid = left + (right - left)/2;

			inv = mergeSort(a, tmp, left, mid);
			inv += mergeSort(a, tmp, mid+1, right);

			inv += merge(a,tmp,left,mid+1,right);
		}

		return inv;
	}

	private long merge(long[] a, long [] tmp, int left, int mid, int right){

		long count = 0;

		int i = left;
		int j = mid;
		int k = left;

		while( i <= mid-1 && j <= right){
			if(a[i] <= a[j]){
				tmp[k++] = a[i++];
			} else {
				tmp[k++] = a[j++];
				count += (mid - i);
			}
		}

		while(i <= mid-1){
			tmp[k++] = a[i++];
		}

		while(j <= right) {
			tmp[k++] = a[j++];
		}

		for(int index = left; index <= right; index++) a[index] = tmp[index];
		return count;
	}

}
