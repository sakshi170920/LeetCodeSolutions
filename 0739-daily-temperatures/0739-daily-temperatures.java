class Solution {
//     Monotonic Stack
// Whenever a problem requires enumerating values for indices on the basis of other values in an array, one should think of including a stack in the solution! And that too, a monotonic stack. It is simply a stack which contains values in a monotonic order; i.e either increasing or decreasing.
// Imagine there is a data structure which contains the indices whose temperatures are in an increasing order. Then, enumerating the next index which has a greater temperature will be easy: we simply pop the elements till the top element has a greater temperature than the current index!
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Pair> s= new Stack();
        int[] result = new int[temperatures.length];
        for(int i = temperatures.length-1;i>=0;i--)
        {
            //pop until current ele is greater than s.top()
            //maintaining a decreasing monotonic stack
            // i.e botton has largest and top has smallest
            while(!s.isEmpty() && temperatures[i] >= s.peek().val)
            {
                s.pop();
            }
            // if stack contains anything i.e the next greater element
            if(!s.isEmpty())
            {            
                int index = s.peek().index;
                result[i] = index-i;                   
            }
            s.push(new Pair(temperatures[i],i));
        }
        return result;
    }
    class Pair{
        int val;
        int index;
        Pair(int val,int index)
        {
            this.val = val;
            this.index = index;
        }
    }
}