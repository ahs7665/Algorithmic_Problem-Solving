import java.util.*;
import java.io.*;

class graph
{
    private int v;
    public ArrayList<LinkedList<Integer>> alist = new ArrayList<LinkedList<Integer>>();

    public graph(int a)
    {
        v = a;

        int i;

        for(i=0;i<v;i++)
        {
            alist.add(new LinkedList<Integer>());
        }
    }

    public void addEdge(int a, int b)
    {
        alist.get(a).add(b);
    }

    public int bfs()
    {
        boolean visited[] = new boolean[v];

        int dist[] = new int[v];

        visited[1] = true;

        dist[1] = 0;

        LinkedList<Integer> q = new LinkedList<Integer>();
        q.add(1);

        while(q.size()>0)
        {
            int temp = q.removeFirst();


            for(int j:alist.get(temp))
            {
                if(!visited[j])
                {
                visited[j] = true;
                    dist[j] = dist[temp]+1;
                    q.addLast(j);
                }

                if(j==100)
                {
                    return dist[100]-1;
                }
            }
        }

        return -1;

    }
}

class Solution
{
    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine());

        for(int i = 0; i < t; i++) {
            graph g = new graph(101);

            int ladders = Integer.parseInt(sc.nextLine());

            for(int j = 0; j < ladders; j++) {
                String[] temp = sc.nextLine().split(" ");
                int src = Integer.parseInt(temp[0]);
                int dest = Integer.parseInt(temp[1]);
                g.addEdge(src, dest);
            }

            int snakes = Integer.parseInt(sc.nextLine());

            for(int j = 0; j < snakes; j++) {
              String[] temp = sc.nextLine().split(" ");
              int src = Integer.parseInt(temp[0]);
              int dest = Integer.parseInt(temp[1]);
              g.addEdge(src, dest);
            }

            for(int j = 1; j < 101; j++) {
                if(g.alist.get(j).size() == 0) {
                    for(int k = 1; k <= 6 && j+k <= 100; k++) {
                        g.addEdge(j, j+k);
                    }
                }
            }
            System.out.println(g.bfs());
        }

    }
}
