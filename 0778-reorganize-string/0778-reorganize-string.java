class Solution {
    public String reorganizeString(String s) {
        char[] res = new char[s.length()];
        Arrays.fill(res,' ');
        //System.out.println(arr[0]);
        HashMap<Character,Integer> map = new HashMap();
        for(int i = 0;i<s.length(); i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        PriorityQueue<Freq> q = new PriorityQueue<Freq>((a,b)->b.c-a.c);
        for(Map.Entry<Character,Integer> a : map.entrySet()){
            q.add(new Freq(a.getKey(),a.getValue()));
        }
        StringBuilder result = new StringBuilder();
        if(Math.ceil(s.length()/2.0)<q.peek().c)
            return "";
        while(!q.isEmpty()){
            Freq curr1 = q.poll();
            Freq curr2 = null;
            if(!q.isEmpty())
                curr2 = q.poll();
            if(result.isEmpty() || result.charAt(result.length()-1) 
            != curr1.a){
                result.append(curr1.a);
                if(curr1.c > 1)
                    q.add(new Freq(curr1.a,curr1.c-1));
                curr1 = null;
            }
            if(curr2 != null){
                result.append(curr2.a);
                if(curr2.c > 1)
                    q.add(new Freq(curr2.a,curr2.c-1));
            }
            if(curr1!= null){
                result.append(curr1.a);
                if(curr1.c > 1)
                    q.add(new Freq(curr1.a,curr1.c-1));
            } 
        }
        return result.toString();
    }
    class Freq{
        char a;
        int c;
        Freq(char a,int c){
            this.a = a;
            this.c = c;
        }
    }
}