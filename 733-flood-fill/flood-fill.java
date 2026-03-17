class Solution {
    int prevColor;
    public void helper(int[][] image, int row, int col, int color){
        if(row < 0 || row >= image.length || col < 0 || col >= image[0].length) return;
        if(image[row][col] != prevColor) return;
        image[row][col] = color;
        helper(image, row + 1, col, color);
        helper(image, row - 1, col, color);
        helper(image, row, col + 1, color);
        helper(image, row, col - 1, color);

        return ;
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        prevColor = image[sr][sc];
        if(prevColor == color) return image;
        for(int i = 0; i < image.length; i++){
            for(int j = 0; j < image[0].length; j++){
                if(i == sr && j == sc ){
                    helper(image, i, j, color );
                }
            }
        }
        return image;
    }
}