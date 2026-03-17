class Solution {

    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][j] == 0){
                    q.add(new int[]{i, j});
                    visited[i][j] = true;
                } else {
                    mat[i][j] = -1; 
                }
            }
        }
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};   

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];

            for(int i = 0; i < 4; i++){
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];

                if(nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny]){
                    mat[nx][ny] = mat[x][y] + 1;
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }   
        }
        return mat;
    }
}