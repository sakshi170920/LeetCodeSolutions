class Solution {
    public int characterReplacement(String s, int k) {
        int result = 0;
        int left = 0;
        FreqMap map = new FreqMap();
        for(int right = 0;right<s.length();right++){
            map.add(s.charAt(right));
            //valid
            if(map.getDiff()<=k){
                result = Math.max(result,map.getSum());
            }
            else{
                map.remove(s.charAt(left));
                left++;
            }
        }
        return result;
    }
    class FreqMap{
        char[] ans = new char[26];
        int sum = 0;
        int maxFreq = 0;
        FreqMap(){

        }
        void remove(char c){
            ans[c-'A'] -= 1;
            sum-=1;
        }
        void add(char c){
            ans[c-'A'] += 1;
            sum+=1;
            maxFreq = Math.max(maxFreq,ans[c-'A']);
        }
        int getSum(){
            return sum;
        }
        int getDiff(){
            return sum-maxFreq;
        }
    }
    class Pair{
        int idx;
        int c;
        Pair(int idx,int c){
            this.idx = idx;
            this.c = c;
        }
    }
}