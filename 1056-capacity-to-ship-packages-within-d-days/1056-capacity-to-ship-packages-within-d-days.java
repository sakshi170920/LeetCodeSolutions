class Solution {
    public boolean possible(int capacity,int[] weights, int days){
        int total = 0;
        int d = 0;
        for(int i = 0;i<weights.length;i++){   
            if(total+weights[i]<=capacity){
                total+=weights[i];
            }
            else{
                d++;
                i--;
                total = 0;
                if(d == days)
                {
                    //System.out.println(false);
                    return false;
                }
            }
        }
        return true;
    }
    public int shipWithinDays(int[] weights, int days) {
        int high = 0;
        int low = Integer.MAX_VALUE;
        for(int i = 0;i<weights.length;i++){  
            low = Math.min(low,weights[i]);
            high+= weights[i];           
        }
        while(low<=high){
            int mid = low+(high-low)/2;
            //System.out.println("low "+low+" high "+high);
            if(possible(mid,weights,days)){
                high=mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return low;
    }
}