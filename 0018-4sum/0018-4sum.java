class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        Set<List<Integer>> res = new HashSet();
        for(int i = 0;i<nums.length;i++){
           for(int j = i+1;j<nums.length;j++){
            long currSum = (long)target-(long)nums[i]-(long)nums[j];
            HashMap<Long,Integer> map = new HashMap();   
            for(int k = j+1;k<nums.length;k++){
                if(map.containsKey(Long.valueOf(nums[k]))){ 
                    List<Integer> temp = new ArrayList();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    temp.add(nums[map.get(Long.valueOf(nums[k]))]); 
                    System.out.println(temp);
                    res.add(temp);
                }else{
                    map.put(Long.valueOf(currSum-nums[k]),k);
                }
            }
          } 
        }
        return res.stream().collect(Collectors.toList());
    }
}