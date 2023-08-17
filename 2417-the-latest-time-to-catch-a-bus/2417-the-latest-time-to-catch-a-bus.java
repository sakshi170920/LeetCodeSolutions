class Solution {
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        //you only care about the last passenger in last bus
        // if last bus is full/not full
        //if full you will replace someone available
        // if not full take the last minute available

        Arrays.sort(buses);
        Arrays.sort(passengers);

        int j = 0;
        int k = 0;

        for(int i = 0;i<buses.length;i++){
            k = capacity;
            while(j<passengers.length && passengers[j]<= buses[i] && k>0){
                j++;
                k--;
            }
        }
        int last_bus = buses[buses.length-1];
        j--;
        //System.out.println("last pas"+j+" capa "+k);
        // j denotes the last passenger in last bus
        if(k>0 && k<=capacity) // bus not full
        {
            // j == -1 - no one took the bus
            //last minute time is available
            if(j == -1 || passengers[j] != last_bus)
                return last_bus;
            //non consecutive element
            while(j>0 && passengers[j-1] + 1 == passengers[j] )
            {
                j--;
            }
            return passengers[j]-1;
        }
        // k == 0 no place, bus is full just replace someone
        else{
            while(j>0 && passengers[j-1] + 1 == passengers[j] )
            {
                j--;
            }
            return passengers[j]-1;
        }
    }
}