class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        ArrayList<ArrayList<Integer>> rev = new ArrayList<>();
        for(int i = 0; i < V; i++){
            rev.add(new ArrayList<>());
        }
        int[] indegree = new int[V];
        
        for(int i = 0; i < V; i++){
            // for(int it : graph[i]){
            //     rev.get(it).add(i);  //reverse edge
            //     indegree[i]++;       //count outgoing edges
            // }
            for(int j = 0; j < graph[i].length; j++){
                int v = graph[i][j];
                rev.get(v).add(i);
                indegree[i]++; 
            }
        } 
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < V; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        boolean[] safe = new boolean[V];
        while(!q.isEmpty()){
            int node = q.poll();
            safe[node] = true;

            for(int it: rev.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.add(it);
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < V; i++){
            if(safe[i]){
                res.add(i);
            }
        }
        
        return res;
    }
}