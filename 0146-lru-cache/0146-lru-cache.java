class LRUCache {
    Node head = new Node(0,0);
    Node tail = new Node(0,0);
    int capacity;
    HashMap<Integer,Node> map = new HashMap();
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;     
    }
    
    public int get(int key) {
        if(map.containsKey(key))
        {
            Node n = map.get(key);                       
            n.delete();
            head.insert(n); 
            // System.out.println(map+"head.n.key : "+head.next.key
            // +" : tail.p.key "+tail.prev.key);   
            return n.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(map.containsKey(key))
        {
            Node n = map.get(key);
            n.delete();
            head.insert(n);
            n.setVal(value);            
        }
        else
        {
            if(map.size() >= capacity)
            {
                //remove tail's prev element (LRU)
                map.remove(tail.prev.key);
                tail.prev.delete();
            }
            //insert new element
            Node n = new Node(key,value);            
            head.insert(n);         
            map.put(key,n);   
            // System.out.println(map+"head.n.key : "+head.next.key
            // +" : tail.p.key "+tail.prev.key);        
        }
    }

    public class Node{
        Node next;
        Node prev;
        int val;
        int key;
        Node(int key,int val)
        {
            this.val = val;
            this.key = key; 
        }
        void insert(Node n)
        {         
            n.prev = this;
            n.next = next;
            next.prev = n; 
            next = n;           
        }
        void delete()
        {         
            prev.next = next;       
            next.prev = prev;           
        }
        void setVal(int val)
        {
            this.val = val;
        }
        @Override
        public String toString()
        {
            return ""+key+":"+val;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */