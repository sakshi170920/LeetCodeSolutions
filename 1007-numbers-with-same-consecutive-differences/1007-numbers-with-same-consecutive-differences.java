class Solution {
    public void helper(int a,int n,int k,HashSet<Integer> result){
        if(n == 0)
        {
            result.add(a);
            return;
        }
        int last = a%10;
        if(last+k<10)
        {
            helper(a*10+(last+k),n-1,k,result);
        }
        if(last-k>=0)
        {
            helper(a*10+(last-k),n-1,k,result);
        }
    }
    public int[] numsSameConsecDiff(int n, int k) {
        HashSet<Integer> result = new HashSet();
        
        for(int i = 1;i<10;i++)
        {
            if(k == 0)
            {
                int x = 0;
                int temp = n;
                while(temp>0)
                {
                    x = x*10 + i;
                    temp--;
                }
                result.add(x);
            }
            else
            {
                helper(i,n-1,k,result);
            }
        }
        return result.stream().mapToInt(i->i).toArray();
    }
}