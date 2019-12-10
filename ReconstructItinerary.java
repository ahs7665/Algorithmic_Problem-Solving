class Solution {

    HashMap<String, PriorityQueue<String>> adj = new HashMap<>();
    LinkedList<String> res = new LinkedList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        for(List<String> t: tickets){
            PriorityQueue<String> temp = adj.getOrDefault(t.get(0), new PriorityQueue<>());
            temp.add(t.get(1));
            adj.put(t.get(0), temp);
        }

        dfs("JFK");

        return res;

    }

    public void dfs(String key){
        PriorityQueue<String> q = adj.get(key);
        while(q != null && !q.isEmpty()){
            dfs(q.poll());
        }
        res.add(0, key);
    }
}
