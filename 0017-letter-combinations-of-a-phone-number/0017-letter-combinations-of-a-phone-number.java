class Solution {
    // i : curr word in arr
    // j : curr char in word
    public void helper(String temp,List<String> arr,List<String> result,int i,int j)
    {
        if(i == arr.size())
        {
            result.add(temp);
            return;
        }   
        String curr = arr.get(i); 
        if(j == curr.length())
        {
            return;  
        }   
        //take
        helper(temp+curr.charAt(j),arr,result,i+1,0);
        // not take
        helper(temp,arr,result,i,j+1);    
    }
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList();
        if(digits.length() == 0)
            return result;
        List<String> arr = new ArrayList();
        int len = 3;
        for(int i = 0 ;i<digits.length();i++)
        {
            int curr = (int)(digits.charAt(i)-'2');
            //System.out.println(curr);
            if(curr+2 == 7)
            {
                curr *= len;
                len = 4;
            }
            else if(curr+2 == 8)
            {
                curr = (int)('t'-'a');
            }
            else if(curr+2 == 9)
            {
                curr = (int)('w'-'a');
                len = 4;
            }
            else
            {
                curr *= len;
            }
            StringBuilder res= new StringBuilder();
            for(int j = 0;j<len;j++)
            {
                res.append((char)(curr+'a'+j));
            }
            arr.add(res.toString());
            len = 3;
        }
        String temp = new String();
        helper(temp,arr,result,0,0);
        return result;
    }
}