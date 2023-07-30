class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Pair> s= new Stack();
        s.push(new Pair(temperatures[0],0));
        int[] result = new int[temperatures.length];
        for(int i = 0;i<result.length;i++)
        {
            result[i] = 0;
        }
        for(int i = 1;i<temperatures.length;i++)
        {
            while(!s.isEmpty() && temperatures[i]>s.peek().val)
            {
                int index = s.peek().index;
                s.pop();
                result[index] = i-index;
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