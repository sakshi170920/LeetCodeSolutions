class Solution {
    public void helper(int[][] image,int i ,int j,int srcColor,int color)
    {
        if(i<0||j<0||i==image.length||j==image[0].length)
            return;
        if(image[i][j] == color || image[i][j] != srcColor)
            return;
        image[i][j] = color;
        helper(image,i+1,j,srcColor,color);
        helper(image,i-1,j,srcColor,color);
        helper(image,i,j+1,srcColor,color);
        helper(image,i,j-1,srcColor,color);
    } 
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int srcColor = image[sr][sc];
        helper(image,sr,sc,srcColor,color);
        return image;
    }
}