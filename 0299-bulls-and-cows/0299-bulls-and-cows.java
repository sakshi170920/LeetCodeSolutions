class Solution {
    public String getHint(String secret, String guess) {
        HashMap<Character,Integer> map = new HashMap();
        int bulls = 0;
        int cows = 0;
        boolean[] visited = new boolean[secret.length()];
        for(int i = 0;i<secret.length();i++){
            if(secret.charAt(i) == guess.charAt(i)){
                bulls++;
                visited[i] = true;
            }
            else{
                map.put(secret.charAt(i),map.getOrDefault(secret.charAt(i),0)+1);
            }
        }
        for(int i = 0;i<secret.length();i++){
            if(!visited[i]){
                if(map.containsKey(guess.charAt(i))){
                    cows++;
                    int count = map.get(guess.charAt(i));
                    if(count == 1){
                        map.remove(guess.charAt(i));
                    }else{
                        map.put(guess.charAt(i),count-1);
                    }
                }
            }
        }
        return ""+bulls+"A"+cows+"B";
    }
}