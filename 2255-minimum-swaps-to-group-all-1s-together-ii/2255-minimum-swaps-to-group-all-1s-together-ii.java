class Solution {
    public int minSwaps(int[] nums) {
        int total = 0;

        for(int n : nums){
            if(n == 1) total++;
        }

        int n = nums.length;
        int[] arr = new int[n*2];
        for(int i = 0;i<n*2;i++){
            arr[i] = nums[i%n];
        }
        
        int curr = 0;
        for(int i = 0;i<total;i++){
            if(nums[i] == 1) curr++;
        }

        int result = total-curr;
        for(int i = total;i<arr.length;i++){
            if(arr[i-total] == 1)
                curr--;
            if(arr[i] == 1)
                curr++;
            result = Math.min(result,total-curr);
        }
        return result;
    }
}