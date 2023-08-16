class Solution {
    public String getHint(String secret, String guess) {
        int[] map = new int[10];
        int bulls = 0;
        int cows = 0;
        for(int i = 0;i<secret.length();i++){
            int s = secret.charAt(i) - '0';
            int g = guess.charAt(i) - '0';
            if(s == g){
                bulls++;
            }
            else{
                if(map[g]>0){
                    cows++;
                }
                if(map[s]<0){
                    cows++;
                }
                map[s]++;
                map[g]--;
            }     
        }
        return new StringBuilder().append(bulls)
        .append('A').append(cows).append('B').toString();
    }
}