class StockSpanner {

    List<Integer> arr;

    public StockSpanner() {
        arr = new ArrayList();
    }
    
    public int next(int price) {
        int count = 1;
        int i = arr.size()-1;
        while(i>=0)
        {
            if(arr.get(i) > price)
                break;
            count++;
            i--;
        }
        arr.add(price);
        return count;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */