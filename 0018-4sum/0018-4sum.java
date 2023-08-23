class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        Set<List<Integer>> res = new HashSet();
        for(int i = 0;i<nums.length;i++){
           for(int j = i+1;j<nums.length;j++){
            long currSum = (long)target-(long)nums[i]-(long)nums[j];
            int k = j+1;
            int l = nums.length-1;
            while(k<l){
                if((long)nums[k] + (long)nums[l] == currSum){
                    List<Integer> temp = new ArrayList();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    temp.add(nums[l]); 
                    res.add(temp);
                    k++;
                    l--;
                }else if(nums[k] + nums[l] < currSum){
                    k++;
                }
                else{
                    l--;
                }
            }
          } 
        }
        return res.stream().collect(Collectors.toList());
    }
}