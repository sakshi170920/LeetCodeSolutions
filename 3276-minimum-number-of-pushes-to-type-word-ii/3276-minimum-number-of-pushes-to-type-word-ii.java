class Solution {
    int C = 26;
    public int minimumPushes(String word) {
        Integer[] freq = new Integer[C];
        for(int i = 0;i<C;i++){
            freq[i] = 0;
        }
        for(int i = 0;i<word.length();i++){
            char c = word.charAt(i);
            freq[c-'a']++;
        }

        Arrays.sort(freq, Collections.reverseOrder());

        int N = 8;
        int result = 0;
        int count = 1;
        for(int i = 0;i<C;i++){
            if(freq[i] == 0)
                break;
            result += freq[i]*count;
            N--;
            if(N == 0){
                N = 8;
                count++;
            }
        }
        return result;       
    }
}