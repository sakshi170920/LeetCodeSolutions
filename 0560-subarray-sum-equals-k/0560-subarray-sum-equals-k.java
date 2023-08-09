class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        if(nums.length == 1)
        {
            if(nums[0] == k)
                return 1;
            else
                return 0;
        }
        for(int i = 0;i<nums.length;i++)
        {
            nums[i] += sum;
            sum = nums[i];
        }
        int count = 0;
        for(int i = 0;i<nums.length;i++)
        {
            if(nums[i] == k)
                count++;
            for(int j = i+1;j<nums.length;j++)
            {
                if(nums[j]-nums[i] == k)
                {
                    count++;
                }
            }
        }
        return count;
        
    }
}