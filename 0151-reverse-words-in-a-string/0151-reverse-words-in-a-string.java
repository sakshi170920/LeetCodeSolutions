class Solution { 
    public String reverse(String s)
    {
        StringBuilder str = new StringBuilder(s);
        int len = s.length();
        int j = len-1;
        for(int i=0;i<len/2;i++)
        {
            char temp = str.charAt(i);
            str.setCharAt(i,str.charAt(j));
            str.setCharAt(j--,temp);
        }
        return str.toString();
    }
    public String reverseWords(String s) {
       StringBuilder result =new StringBuilder();
       s = reverse(s);
       int i = 0;
       while(s.charAt(i) == ' ')
        i++;
       StringBuilder temp =new StringBuilder();
       for(;i<s.length();i++)
       {
           char curr = s.charAt(i);
           if(curr != ' ')
           {
               temp = new StringBuilder().append(curr).append(temp);
           }
           else
           {
               if(!temp.isEmpty())
               {
                   result.append(temp).append(" ");
               }
               temp = new StringBuilder();
           }
       }
       if(!temp.isEmpty())
        {
            result.append(temp).append(" ");
        }
        if(!result.isEmpty())
            result.setLength(result.length()-1);
        return result.toString();
    }
}