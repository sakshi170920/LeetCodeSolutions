class Solution {
    int C = 26;
    public int minimumPushes(String word) {
        int[] freq = new int[C];
        for(int i = 0;i<word.length();i++){
            freq[word.charAt(i)-'a']++;
        }

        Arrays.sort(freq);

        int N = 8;
        int result = 0;
        int count = 1;
        for(int i = 0;i<C;i++){ 
            result += freq[C-i-1]*(i/8+1);
        }
        return result;       
    }
}