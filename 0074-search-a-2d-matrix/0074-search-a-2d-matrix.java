class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int s = 0,e = matrix.length-1;
        while(s<e)
        {
            int mid = s+(e-s)/2;
            if(matrix[mid][0] > target)
            {
                e = mid-1;
            }
            else if(matrix[mid][0] < target)
            {
                s = mid+1;
                if(mid+1 < matrix.length && matrix[mid+1][0] > target)
                {
                    s = mid;
                    break;
                }
            }
            else
            {
                s = mid;
                break;
            }
        }
        System.out.println("found : "+s);
        int index = s;
        s = 0;
        e = matrix[0].length-1;
        while(s<=e)
        {
            int mid = s+(e-s)/2;
            if(matrix[index][mid] > target)
            {
                e = mid-1;
            }
            else if(matrix[index][mid] < target)
            {
                s = mid+1;
            }
            else
            {
                return true;
            }
        }
        return false;
    }
}