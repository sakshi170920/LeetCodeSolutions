class Solution {
    
    Boolean[] dp;
    
    public boolean Helper(int[] arr, int idx, int n){
        
        if(idx == n)  return true;
        
        if(dp[idx] != null)     return dp[idx];
        
        boolean f1 = false;             
        boolean f2 = false;
        boolean f3 = false;
        
		// if two consective elements are same
        if(idx + 1 < n){
            if(arr[idx] == arr[idx + 1]){
                f1 = Helper(arr, idx + 2, n);
            }
        }
        
        if(idx + 2 < n){
			// if three consecutive elements are same
            if(arr[idx] == arr[idx + 1] && arr[idx + 1] == arr[idx + 2]){
                f2 = Helper(arr, idx + 3, n);
            }
            
			// if three elements are consecutive (their difference is 1)
            if(arr[idx + 2] - arr[idx + 1] == 1 && arr[idx + 1] - arr[idx] == 1){
                f3 = Helper(arr, idx + 3, n);
            }
        }
        
        return dp[idx] = f1 || f2 || f3;
    }
    
    public boolean validPartition(int[] nums) {
        int n = nums.length;
        dp = new Boolean[n];
        
        return Helper(nums, 0, n);
    }
}