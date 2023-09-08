class Solution {
    public void solve(List<List<Integer>> result,int n) {
        //System.out.println("hey for n is : "+n);
        List<Integer> temp = new ArrayList();
        temp.add(1);
        if(n == 1)
        {
            result.add(temp);
            return;
        }
        solve(result,n-1);
        if(n == 2)
        {
            temp.add(1);
            result.add(temp);
            return;
        }
        int gen = n-2;
        gen /= 2;
        if(n%2 != 0)
            gen++;
        List<Integer> prev = result.get(result.size()-1);
        for(int i= 0;i<gen;i++)
        {
            temp.add(prev.get(i)+prev.get(i+1));
        }
        for(int i= gen-n%2;i>=0;i--)
        {
            temp.add(temp.get(i));
        }
        result.add(temp);
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList();
        solve(result,numRows);
        return result;
    }
}