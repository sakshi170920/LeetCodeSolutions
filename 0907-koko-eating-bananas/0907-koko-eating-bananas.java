class Solution {
    public boolean isPossible(int[] piles,int h,int k){
        int hours = 0;     
        for(int p : piles){
            hours += p/k;
            if(p%k != 0)
                hours++;
            if(hours>h){
                return false;}             
        }
        return true;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int high = Integer.MIN_VALUE;
        for(int p : piles){
            high = Math.max(high,p);
        }
        int low = 1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(isPossible(piles,h,mid)){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
}