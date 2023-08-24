class Solution {
    public String justify(List<String> words,int width,boolean isLeft){
        System.out.println(words);
        char[] res = new char[width];
        Arrays.fill(res,' ');
        //left justify
        if(isLeft || words.size() == 1){
            int i = 0;
            for(String word : words){
                for(int j = 0;j<word.length();j++){
                    res[i++] = word.charAt(j);
                }
                i++;
            }
        }
        else{
            int sum = 0;
            for(String word : words){
                sum+=word.length();
            }
            int spaces = (width-sum)/(words.size()-1);
            int needsExtraSpace = (width-sum)%(words.size()-1);
            System.out.println(spaces+" "+needsExtraSpace);
            int k = 0;
            int m = 0;
            // add extra space
            for(int i = 0;i<needsExtraSpace;i++){
                words.set(i,words.get(i)+" ");
            }
            k = 0;
            for(String word : words){
                for(int j = 0;j<word.length();j++){
                    res[k++] = word.charAt(j);
                }
                k+=spaces;
            }
        }
        StringBuilder temp = new StringBuilder();
        for(char c : res){
            temp.append(c);
        }
        return temp.toString();
    }
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<List<String>> result = new ArrayList();
        int count = 0;
        List<String> temp = new ArrayList();
        for(int i = 0;i<words.length;i++){
            String word = words[i];
            int flag = temp.isEmpty() ? 0 : 1;
            if(count+word.length()+flag<=maxWidth){
                temp.add(word);
                count+=word.length()+flag;
            }else{
                result.add(new ArrayList(temp));
                temp.clear();
                count = 0;
                i--;               
            }
        }
        if(!temp.isEmpty())
            result.add(new ArrayList(temp));
        
        List<String> ans = new ArrayList();
        boolean flag = false;
        for(int i = 0;i<result.size();i++){
            if(i == result.size()-1)
                flag = true;
            ans.add(justify(result.get(i),maxWidth,flag));
        }
        return ans;
    }
}