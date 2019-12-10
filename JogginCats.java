import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class JogginCats {
    int V, E;
    ArrayList<Integer>[] adjcencyList;

    public long getUniqueRoutes(int u){
        long res = 0;

        HashMap<Integer, Long> map = new HashMap<>();

        for(int v : adjcencyList[u]){
            if(v < u) {
                for(int v2 : adjcencyList[v]){
                    if(v2 < u) {
                        if(!map.containsKey(v2)){
                            map.put(v2, 0L);
                        }
                        long n = map.get(v2);
                        res -= n*(n-1)/2; // Remove already calculated value
                        n++;
                        map.put(v2, n);
                        res += n*(n-1)/2; // Add the unique paths for the newly calculated value
                    }
                }
            }
        }
        return res;
    }

    public void findPaths(){
        readInput();
        long result = 0;

        for(int u = 1; u<=V; u++){
            result += getUniqueRoutes(u);
        }

        System.out.println(result);

    }

    public void readInput() {
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt(); E = sc.nextInt();
        adjcencyList = new ArrayList[V+1];
        for(int i=1; i<=V; i++){
            adjcencyList[i] = new ArrayList<>();
        }

        //Create the adjacency list
        for(int i=0; i<E; i++){
            int from, to;
            from = sc.nextInt(); to = sc.nextInt();
            //Since bidirectional, add both ways
            adjcencyList[from].add(to);
            adjcencyList[to].add(from);
        }
    }

    public static void main(String[] args){
        JogginCats jc = new JogginCats();
        jc.findPaths();
    }
}
