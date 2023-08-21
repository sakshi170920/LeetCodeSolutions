class Solution {
    public boolean repeatedSubstringPattern(String s) {
        StringBuilder concat = new StringBuilder(s+s);
        concat.deleteCharAt(0);
        concat.deleteCharAt(concat.length()-1);
        return concat.toString().contains(s);
    }
}