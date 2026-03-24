class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];

        for(int[] it : prerequisites){
            int u = it[0];
            int v = it[1];
            adj.get(v).add(u); 
            indegree[u]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }

        int[] ans = new int[numCourses];
        int index = 0;

        while(!q.isEmpty()) {
            int node = q.poll();
            ans[index++] = node;

            for(int neighbor : adj.get(node)) {
                indegree[neighbor]--;
                if(indegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }

       
        if(index != numCourses) return new int[0];

        return ans;
    }
}