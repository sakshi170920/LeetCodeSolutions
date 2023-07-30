class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        HashMap<Integer,Integer> map = new HashMap();
        Stack<Integer> s = new Stack();
        for(int i = 0 ; i < nums1.length; i++)
        {
            result[i]=-1;
        }
        for(int i = nums2.length-1;i>=0; i--)
        {
            int res = -1;
            if(!s.isEmpty())
            {
                while(!s.isEmpty() && nums2[i]>s.peek())
                {
                    s.pop();
                }
                if(!s.isEmpty())
                {
                    res = s.peek();
                }
            }
            map.put(nums2[i],res);
            s.push(nums2[i]);
        }
        for(int i = 0 ; i < nums1.length; i++)
        {
            result[i] = map.get(nums1[i]);
        }
        return result;
    }
}