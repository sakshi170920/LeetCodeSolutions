class Solution {
    public int f(int idx,List<String> arr,int[] mark){
        if(idx == arr.size())
            return 0;
        String curr = arr.get(idx);
        boolean flag = true;
        //verify
        for(int i = 0; i<curr.length(); i++){
            if(mark[curr.charAt(i)-'a'] == 1){
                flag = false;
                break;
            }
        }
        int take = 0;
        if(flag){
            //mark
            for(int i = 0; i<curr.length(); i++){
                mark[curr.charAt(i)-'a'] = 1;             
            }
            take = curr.length() + f(idx+1,arr,mark);
            //unmark
            for(int i = 0; i<curr.length(); i++){
                mark[curr.charAt(i)-'a'] = 0;             
            }
        }
        int notTake = f(idx+1,arr,mark);
        return Math.max(take,notTake);
    }
    public int maxLength(List<String> arr) {
        int[] mark = new int[26];
        for(int i = 0;i<arr.size();i++){
            HashSet<Character> s = new HashSet();
            String curr = arr.get(i);
            for(int j = 0; j<curr.length(); j++){
                if(s.contains(curr.charAt(j)))
                {
                    arr.remove(i);
                    i--;
                    break;
                } 
                s.add(curr.charAt(j));       
            }
        }       
        return f(0,arr,mark);
    }
}