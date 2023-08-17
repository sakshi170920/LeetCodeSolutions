class Solution {
    public void print(int[][] res){
        for(int k = 0;k<res.length;k++){
            System.out.println(Arrays.toString(res[k]));
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        Queue<State> q = new LinkedList();
        int[][] res = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(mat[i][j] == 0){
                    q.add(new State(i,j,0));
                    visited[i][j] = true;
                }
            }
        }

        while(!q.isEmpty()){
            State curr = q.poll();
            for(int[] direction : directions){
                int row = curr.row + direction[0];
                int col = curr.col + direction[1];
                if(isValid(row,col,m,n) && !visited[row][col]){
                    res[row][col] = curr.step+1;
                    visited[row][col] = true;
                    q.add(new State(row,col,curr.step+1));
                }
            }
        }
        return res;
    }
    public boolean isValid(int row,int col,int m,int n){
        if(row>=0 && col>=0 && row<m && col<n)
            return true;
        return false;
    }
    class State{
        int row;
        int col;
        int step;
        State(int row,int col,int step){
            this.row = row;
            this.col = col;
            this.step = step;
        }
    }
}