class Solution {
    public String removeKdigits(String num, int k) {
        //monotonically increasing stack
        Stack<Character> s = new Stack();
        int pop = 0;
        for(int i = 0;i<num.length();i++){
            char curr = num.charAt(i);
            while( pop<k && !s.isEmpty() && s.peek()>curr){
                pop++;
                s.pop();
            }
            s.push(curr);
        }
        while( pop<k && !s.isEmpty()){
                pop++;
                s.pop();
        }
        StringBuilder res = new StringBuilder();
        for(char n : s){
            res.append(n);
        }
        while(!res.isEmpty() && res.charAt(0) == '0')
        {
            res.deleteCharAt(0);
        }
        if(res.isEmpty())
            return "0";
        return res.toString();
    }
}