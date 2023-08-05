class Solution {
    public String gcdOfStrings(String str1, String str2) {
        StringBuilder result = new StringBuilder(str1.length()<str2.length() ? str1 : str2);
        String temp = result.toString();
        temp =  temp.equals(str1) ? str2 : str1;
        System.out.println(" result : "+result+" TEMP : "+temp);
        for(int i = 0;i<temp.length();i++)
        {
            if(result.isEmpty())
            {
                return result.toString();
            }
            //System.out.println(" i : "+i+" result : "+result);
            int j = 0;
            int k = i;
            for(;j<result.length() && k<temp.length();j++)
            {
                if(result.charAt(j) != temp.charAt(k))
                    break;
                k++;
            }
            if(j<result.length())
            {
                //System.out.println(" not found going back to : "+j);
                result.setLength(j);
                i=j-1;
            }
            else
            {
                i+=j-1;
            }            
        }
        temp =  temp.equals(str1) ? str2 : str1;
        System.out.println(" result : "+result+" TEMP : "+temp);
        for(int i = 0;i<temp.length();i++)
        {
            if(result.isEmpty())
            {
                return result.toString();
            }
            //System.out.println(" i : "+i+" result : "+result);
            int j = 0;
            int k = i;
            for(;j<result.length() && k<temp.length();j++)
            {
                if(result.charAt(j) != temp.charAt(k))
                    break;
                k++;
            }
            if(j<result.length())
            {
                //System.out.println(" not found going back to : "+j);
                result.setLength(j);
                i=j-1;
            }
            else
            {
                i+=j-1;
            }            
        }
        return result.toString();
    }
}