import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

	final static int INFINITY = 9999;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int E = in.nextInt();

		int[][] graph = new int[N][N];
		int[][] dist = new int[N][N];
		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				graph[i][j] = -1;
				dist[i][j] = INFINITY;
			}
		}

		for(int m=0; m<E; m++){
			int x = in.nextInt();
			int y = in.nextInt();
			int r = in.nextInt();

			graph[x-1][y-1] = r;
		}

		dist = floydWarshall(graph, dist, N);

		int QN = in.nextInt();
		for(int q=0; q<QN; q++){
			int a = in.nextInt();
			int b = in.nextInt();
			System.out.println(dist[a-1][b-1]==INFINITY?-1:dist[a-1][b-1]);

		}

	}

	static int[][] floydWarshall(int[][] graph, int[][] dist, int N){
		for(int i=0; i<N; i++)
			dist[i][i] = 0;

		for(int i=0; i<N; i++)
			for(int j=0; j<N; j++)
				if(graph[i][j]>0) dist[i][j] = graph[i][j];

		for(int k=0; k<N; k++){
			for(int i=0; i<N; i++){
				for(int j=0; j<N; j++){
					if(dist[i][j]>(dist[i][k]+dist[k][j]))
						dist[i][j] = dist[i][k] + dist[k][j];
				}
			}
		}

		return dist;
	}

	static void printArray(int[][] array, int N){
		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				System.out.print(array[i][j]+" ");
			}
			System.out.println();
		}
    }
}
