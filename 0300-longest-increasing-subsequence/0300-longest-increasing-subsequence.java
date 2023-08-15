class Solution {
    public int lowerBound(List<Integer> arr,int target){
        int low = 0;
        int high = arr.size()-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr.get(mid)>=target)
            {
                high = mid-1;
            }
            else
            {
                low = mid+1;
            }
        }
        return low;
    }
    public int lengthOfLIS(int[] nums) {
        List<Integer> arr = new ArrayList();
        arr.add(nums[0]);
        for(int i = 1;i<nums.length;i++)
        {    
            int low = lowerBound(arr,nums[i]); 
            if(low<arr.size()){
                arr.set(low,nums[i]);
            }  
            else{
                arr.add(nums[i]);
            }
        }
        return arr.size();
    }
}