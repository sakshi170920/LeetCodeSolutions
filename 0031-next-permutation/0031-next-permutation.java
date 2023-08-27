class Solution {
    public void reverse(int[] nums,int i){
        int j = nums.length-1;
        for(int idx = i;idx<(i+(nums.length-i)/2);idx++){
            swap(nums,idx,j--);
        }
    }
    public void swap(int[] nums,int i , int j){
        nums[i] += nums[j];
        nums[j] = nums[i]-nums[j];
        nums[i] -= nums[j];
    }
    public int nextGreater(int[] nums,int target){
        for(int i=nums.length-1;i>=0;i--){
            if(nums[i]>nums[target]){
                return i;
            }
        }
        return -1;
    }
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        for(int i = n-2;i>=0;i--){
            if(nums[i]<nums[i+1])
            {
                int  s = nextGreater(nums,i);
                swap(nums,i,s);
                reverse(nums,i+1);
                return;
            }
        }
        reverse(nums,0);
    }
}