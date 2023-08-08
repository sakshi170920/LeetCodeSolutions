class Solution {
    public void helper(int a,int n,int k,HashSet<Integer> result){
        //System.out.println("a: "+a+" n "+n);
        if(n == 0)
        {
            result.add(a);
            return;
        }
        int last = a%10;
        if(last+k<10)
        {
            //System.out.println("a+k: "+(a+k)+" adding "+(a*10+(a+k)));
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
            helper(i,n-1,k,result);
        }
        return result.stream().mapToInt(i->i).toArray();
    }
}