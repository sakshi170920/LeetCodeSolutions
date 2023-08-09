class Solution {
    public int search(int p,int[] nums)
    {
        int n = nums.length;
        int left = 0, right = nums[n - 1] - nums[0];

        while (left < right) {
            int mid = left + (right - left) / 2;

            // If there are enough pairs, look for a smaller threshold.
            // Otherwise, look for a larger threshold.
            if (validPairs(nums,mid,p)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    public boolean validPairs(int[] nums,int threshold,int p)
    {
        int count = 0;
        for(int i = 0;i<nums.length-1;i++)
        {
            if(nums[i+1]-nums[i]<=threshold)
            {
                count++;
                i++;
            }
            if(count == p)
            {
                return true;
            }
        }
        return false;
    }
    public int minimizeMax(int[] nums, int p) {
        if(p == 0)
            return p;
        Arrays.sort(nums);
        return search(p,nums);
    }
}