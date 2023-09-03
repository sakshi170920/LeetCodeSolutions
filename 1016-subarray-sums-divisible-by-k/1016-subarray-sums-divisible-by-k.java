class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int sum = 0;
        int count = 0;
        HashMap<Integer,Integer> prefixMap = new HashMap();
        prefixMap.put(0,1);
        for(int i = 0;i<nums.length;i++){
            sum+=nums[i];
            int rem = sum%k;
            if(rem < 0)
                rem+=k;
            if(prefixMap.containsKey(rem)){
                count += prefixMap.get(rem);
            }
            prefixMap.put(rem,prefixMap.getOrDefault(rem,0)+1);
        }
        return count;
    }
}