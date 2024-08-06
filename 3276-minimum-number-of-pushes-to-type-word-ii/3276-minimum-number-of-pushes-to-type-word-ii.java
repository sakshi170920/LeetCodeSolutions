class Solution {
    public int minimumPushes(String word) {
        HashMap<Character,Integer> freq = new HashMap();
        for(int i = 0;i<word.length();i++){
            char c = word.charAt(i);
            freq.put(c,freq.getOrDefault(c,0)+1);
        }

        List<Integer> list
            = freq.entrySet()
                  .stream()
                  .sorted((i1, i2)
                              -> i2.getValue().compareTo(
                                  i1.getValue())).map(e -> e.getValue())
                  .collect(Collectors.toList());

        int N = 8;
        int result = 0;
        int count = 1;
        for(int i = 0;i<list.size();i++){
            result += list.get(i)*count;
            N--;
            if(N == 0){
                N = 8;
                count++;
            }
        }
        return result;       
    }
}