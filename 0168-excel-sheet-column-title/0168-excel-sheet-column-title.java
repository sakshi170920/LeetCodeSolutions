class Solution {
    int N = 26;
    public int range(int x){
        int count = 0;
        while(x!=0){
            x = x/26;
            count++;
        }
        return count;
    }
    public String convertToTitle(int columnNumber) {
        int count = range(columnNumber);
        String res = "";
        while(columnNumber>0){
            columnNumber--;
            res = (char)((columnNumber%26)+'A')+res;    
            columnNumber/=26;
        }
        return res;
    }
}