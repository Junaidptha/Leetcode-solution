class Solution {

    int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        int[][] effort = new int[n][m];
        for (int[] row : effort) Arrays.fill(row, Integer.MAX_VALUE);

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, 0});   

        effort[0][0] = 0;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];
            int prevEff = curr[2];

            for (int i = 0; i < 4; i++) {
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                int currEff = Math.abs(heights[nx][ny] - heights[x][y]);
                int newEff = Math.max(prevEff, currEff);

                if (newEff < effort[nx][ny]) {
                    effort[nx][ny] = newEff;
                    q.offer(new int[]{nx, ny, newEff});
                }
                
            }
        }

        return effort[n-1][m-1];
    }
}