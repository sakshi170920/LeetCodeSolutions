class Solution {
    public boolean eq(String a,String b){
        if(a.length()!=b.length())
            return false;
        for(int i = 0;i<a.length();i++){
            if(a.charAt(i)!=b.charAt(i))
                return false;
        }
        return true;
    }
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> st = new Stack();
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) == '#'){
                if(!st.isEmpty())
                    st.pop();
            }
            else{
                st.push(s.charAt(i));
            }
        }
        StringBuilder temp1 = new StringBuilder();
        while(!st.isEmpty()){
            temp1.append(st.peek());
            st.pop();
        }
        for(int i = 0;i<t.length();i++){
            if(t.charAt(i) == '#'){
                if(!st.isEmpty())
                    st.pop();
            }
            else{
                st.push(t.charAt(i));
            }
        }
        StringBuilder temp2 = new StringBuilder();
        while(!st.isEmpty()){
            temp2.append(st.peek());
            st.pop();
        }
        System.out.println(temp1+" : "+temp2+temp1.equals(temp2));
        return eq(temp1.toString(),temp2.toString());
    }
}