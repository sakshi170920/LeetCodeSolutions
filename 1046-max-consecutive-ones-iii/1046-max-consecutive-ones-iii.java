class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int count = 0;
        int result = 0;
        while(left<=right && right<nums.length){
            //System.out.println(right+" : "+left);
            result = Math.max(result,right-left);
            if(nums[right] == 0){
                count++;
            }
            right++;
            //invalid
            if(count > k && nums[left++] == 0){              
                count--;            
            }
        }
        return Math.max(result,right-left);
    }
}