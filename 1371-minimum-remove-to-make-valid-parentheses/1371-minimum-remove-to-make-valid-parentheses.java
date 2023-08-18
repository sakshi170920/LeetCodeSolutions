class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Pair<Integer,Integer>> st = new Stack();
        List<Integer> del = new ArrayList();
        for(int i = 0;i<s.length();i++){
            int curr = s.charAt(i);
            if(curr == '('){
                st.push(new Pair(1,i));
            }
            else if(curr == ')'){
                if(st.isEmpty()){
                    del.add(i);
                }else{
                    st.pop();
                }
            }
        }
        int size = del.size();
        while(!st.isEmpty()){
            del.add(size,st.peek().getValue());
            st.pop();
        }
        //System.out.println(del);
        StringBuilder result = new StringBuilder(s);
        for(int i = del.size()-1;i>=0;i--){
            result.deleteCharAt(del.get(i));
        }
        return result.toString();
    }
}