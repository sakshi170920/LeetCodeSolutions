class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> s = new Stack();
        int[] result = new int[nums.length];
        int len = result.length;
        for(int i =0;i<nums.length;i++)
        {
            result[i] = -1;
        }
        for(int i = len*2-1;i>=0;i--)
        {
            while(!s.isEmpty() && nums[i%len]>=s.peek())
            {
                s.pop();
            }
            if(!s.isEmpty())
                result[i%len] = s.peek();                      
            s.push(nums[i%len]);
        }
        return result;
    }
}