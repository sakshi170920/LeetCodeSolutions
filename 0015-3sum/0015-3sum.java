class Solution {
    public List<List<Integer>> twoSum(int[] nums,long target,int start){
        List<List<Integer>> res = new ArrayList();
        int low = start;
        int high = nums.length-1;
        while(low<high){
            long currSum = nums[low]+nums[high];
            if(currSum<target || (low>start && nums[low] == nums[low-1])){
                low++;
            }
             else if(currSum>target || (high+1<nums.length && nums[high] == nums[high+1])){
                high--;
            }
            else{
                res.add(Arrays.asList(nums[low++],nums[high--]));
            }
        }
        return res;
    }
    public List<List<Integer>> kSum(int[] nums, long target,int start,int k){
        List<List<Integer>> res = new ArrayList();
        if(start == nums.length)
            return res;
        
        long avg = target/k;
        if(nums[start]>avg || nums[nums.length-1]<avg)
            return res;

        if(k == 2)
            return twoSum(nums,target,start);
        
        for(int i = start;i<nums.length;i++){
            if(i == start || nums[i] != nums[i-1]){
                for(List<Integer> subset : kSum(nums,target-nums[i],i+1,k-1)){
                    res.add(new ArrayList<>(Arrays.asList(nums[i])));
                    res.get(res.size() - 1).addAll(subset);
                }
            }
        }
        return res;
    }
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        return kSum(nums,0,0,3);
    }
}