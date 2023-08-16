class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length < 2)
            return nums;
        Deque<Integer> q = new ArrayDeque();
        int[] result = new int[nums.length-k+1];
        // queue first will always contains the top most element
        for(int i = 0 ; i<nums.length; i++)
        {
            //Out of bounds
            if(!q.isEmpty() && q.peekFirst() == (i-k))
                q.removeFirst(); 
            
            // remove elements at back lesser than curr
            while(!q.isEmpty() && nums[q.peekLast()]<=nums[i]){
                q.removeLast();  
            }
            q.addLast(i); 
            if(i>=k-1)
                result[i-k+1] = nums[q.peekFirst()];
        }
        return result;
    }
}