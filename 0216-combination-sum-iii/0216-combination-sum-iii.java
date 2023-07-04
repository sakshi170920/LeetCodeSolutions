class Solution {
    public void helper(int k,int n,int index,List<Integer> temp,List<List<Integer>> res)
    {
        
        if(temp.size() == k)
        {
            if(n == 0)
            {
                //System.out.println("found : "+temp.size());
                res.add(new ArrayList(temp));
            }
            return;
        }

        if(index == 10 )
            return;

        if(index<=n){ 
            temp.add(index);
            helper(k,n-index,index+1,temp,res);
            temp.remove(temp.size()-1);
            helper(k,n,index+1,temp,res);
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList();
        List<Integer> temp = new ArrayList();
        helper(k,n,1,temp,res);
        return res;
    }
}