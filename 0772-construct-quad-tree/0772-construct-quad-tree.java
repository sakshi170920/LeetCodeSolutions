/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
*/

class Solution {
    public int mid(Range r){
        return r.x + (r.y-r.x)/2;
    }
    public boolean isEqual(List<Boolean> arr){
        boolean result = arr.get(0);
        for(boolean x : arr){
            if(x != result)
                return false;
        }
        return true;
    }
    public Node f(Range row,Range col,int[][] grid){
        if(row.x == row.y && col.x == col.y)
            return new Node(grid[row.x][col.x] == 1,true);
        Node root = new Node(true,false);
        int rowMid = mid(row);
        int colMid = mid(col);
        root.topLeft = f(new Range(row.x,rowMid),
        new Range(col.x,colMid),grid);
        root.topRight=f(new Range(row.x,rowMid),
        new Range(colMid+1,col.y),grid);
        root.bottomLeft=f(new Range(rowMid+1,row.y),
        new Range(col.x,colMid),grid);
        root.bottomRight=f(new Range(rowMid+1,row.y),
        new Range(colMid+1,col.y),grid);

        List<Boolean> arr = Arrays.asList(root.topLeft.val,root.bottomLeft.val,root.topRight.val,root.bottomRight.val);
        if(root.topLeft.isLeaf && root.topRight.isLeaf 
        && root.bottomLeft.isLeaf && root.bottomRight.isLeaf && 
        isEqual(arr))
        {
            return new Node(grid[row.x][col.x] == 1,true);
        }
        return root;
    }
    public Node construct(int[][] grid) {
        int n = grid.length-1;
        return f(new Range(0,n),new Range(0,n),grid);
    }
    class Range{
        int x;
        int y;
        Range(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}