class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] t : times) {
            adj.get(t[0]).add(new int[]{t[1], t[2]});
        }
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{k, 0});
        dist[k] = 0;

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int node = curr[0];
            int time = curr[1];

            for(int[] nei : adj.get(node)){
                int next = nei[0];
                int wt = nei[1];
                
                if(time + wt < dist[next]){
                    dist[next] = time + wt;
                    q.offer(new int[]{next, dist[next]});
                }
            }
        }
        int maxTime = 0;
        for(int i = 1; i <= n; i++){
            if(dist[i] == Integer.MAX_VALUE) return -1;
            maxTime = Math.max(maxTime, dist[i]);
        }
        return maxTime;



    }
}