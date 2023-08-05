class Solution {
    int len1=0,len2 = 0;
    public boolean valid(String s1,String s2,int k)
    {
        if(len1%k > 0 || len2%k > 0)
            return false;
        String base = s1.substring(0,k);
        return s1.replace(base,"").isEmpty() && s2.replace(base,"").isEmpty();
    }
    public String gcdOfStrings(String str1, String str2) {
        len1=str1.length();
        len2=str1.length();
        for(int i = Math.min(len1,len2);i>=1;i--)
        {
            if(valid(str1,str2,i))
            {
                return str1.substring(0,i);
            }
        }
        return "";
    }
}