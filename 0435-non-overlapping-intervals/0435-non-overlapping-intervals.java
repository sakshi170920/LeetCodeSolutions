class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int prev = -1;
        int count = 0;
        boolean flag = true;
        for(int[] interval : intervals)
        {
            if(flag)
            {
                prev = interval[1];
                flag = false;
            }
            else if(interval[0]<prev)
            {
                count++;
                prev = Math.min(prev,interval[1]);
            }
            else
            {
                prev = interval[1];
            }
        }
        return count;
    }
}