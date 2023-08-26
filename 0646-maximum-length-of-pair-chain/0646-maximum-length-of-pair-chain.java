class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(a,b)->a[0]-b[0]);
        //System.out.println(Arrays.toString(pairs));
        int count = 1;
        int last = pairs[0][1];
        for(int i = 1;i<pairs.length;i++){
            if(last<pairs[i][0]){
                count++;
                last = pairs[i][1];
            }else{
                last = Math.min(last,pairs[i][1]);
            }
        }
        return count;
    }
}