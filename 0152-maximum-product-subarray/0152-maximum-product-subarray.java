class Solution {
    public int maxProduct(int[] nums) {
        int curr_max = nums[0];
        int curr_min = nums[0];
        int res = nums[0];
        for(int i=1;i<nums.length;i++)
        {
            int temp1 = curr_max*nums[i];
            int temp2 = curr_min*nums[i];
            curr_max = Math.max(nums[i],Math.max(temp1,temp2));
            curr_min = Math.min(nums[i],Math.min(temp1,temp2));
            res = Math.max(res,curr_max);
        }
        return res;
    }
}