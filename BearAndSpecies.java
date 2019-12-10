/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef {

static boolean [][]seen;
static String []grid;
static char last;
static int count;
static boolean invalid;
static final int MODULO = 1000000007;


    public static void dfs(int r,int c){

        if(r < 0 || r > grid.length - 1 || c < 0 || c > grid.length - 1 || seen[r][c] || grid[r].charAt(c) == '.') return;

      	seen[r][c]=true;

      	if(last=='x' && grid[r].charAt(c) != '?') {
            last=grid[r].charAt(c);
        }

        count++;

      	if(last != grid[r].charAt(c) && grid[r].charAt(c) != '?') {
            invalid=true;
            return;
        }

      	dfs(r-1,c);
      	dfs(r,c-1);
      	dfs(r+1,c);
      	dfs(r,c+1);
    }


	public static void main(String []args){

          Scanner s = new Scanner(System.in);
          int T = s.nextInt();
          while(T > 0){
          T--;
          int N = s.nextInt();
          s.nextLine();
          grid = new String [N];
          seen = new boolean[N][N];
          for(int i=0;i<N;i++){
        	  grid[i]=s.nextLine();
          }

          long ways=1;
          invalid=false;

          outer:
          for(int i=0;i<N;i++){
        	  for(int j=0;j<N;j++){
        		  last='x';
        		  count=0;
        		  if(!seen[i][j] && grid[i].charAt(j)!='.'){
          			  dfs(i,j);

          			 if(last=='G' && count>1) invalid=true;

          			 if(invalid) break outer;

                 if(last == 'x') {
                      if(count == 1) ways *= 3; // If the count is just one, then we can replace the question mark with any type of bear including 'G'
                      if(count > 1) ways *= 2; // If the count is more than one, then there are adjacent bears which means we can replace either 'B' or 'P'
                 }

                 ways %= MODULO;
        		  }
        	  }
          }

          if(invalid)
        	  System.out.println(0);
          else
        	  System.out.println(ways%MODULO);

          }
          s.close();
    }
}
