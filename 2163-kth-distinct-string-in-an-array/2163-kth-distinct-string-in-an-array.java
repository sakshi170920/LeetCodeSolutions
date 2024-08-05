class Solution {
    public String kthDistinct(String[] arr, int k) {
        LinkedHashMap<String,Boolean> distinct = new LinkedHashMap<String,Boolean>();
        for(String s : arr){
            if(distinct.containsKey(s)){
                distinct.put(s,false);
            }else{
                distinct.put(s,true);
            }
        }

         for(Map.Entry<String,Boolean> mapElement :
             distinct.entrySet()) {
            if(mapElement.getValue()){
                k--;
                if(k == 0)
                    return mapElement.getKey();
            }
        }
        
        return "";
    }
}