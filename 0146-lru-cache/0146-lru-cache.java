class LRUCache {
    Node head = null;
    Node tail = null;
    int capacity;
    HashMap<Integer,Node> map = new HashMap();
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        //System.out.println("get key : "+key);
        if(map.containsKey(key))
        {
            Node n = map.get(key);
            if(tail.key != key)
            {
                n.delete();
                tail.insert(n);

            }
            // System.out.println(map);
            // System.out.println("head - "+head.key+" tail - "+tail.key);
            return n.val;
        }
        //System.out.println("head - "+head.key+" tail - "+tail.key);
        //System.out.println(map);
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key))
        {
            Node n = map.get(key);
            n.setVal(value);
            if(tail.key != key)
            {
                n.delete();
                tail.insert(n);

            }
        }
        else
        {
            if(map.size() >= capacity)
            {
                //remove an element
                map.remove(head.key);
                head.delete();
            }
            //insert new element
            Node n = new Node(key,value,tail,null);
            if(head == null)
            {
                head = n;
            }
            if(tail == null)
            {
                tail = n;
            }
            if(tail.key != key)
            {
                n.delete();
                tail.insert(n);
            }
            map.put(key,n);           
        }
        // System.out.println("push key : "+key);
        // System.out.println("head - "+head.key+" tail - "+tail.key);
        // System.out.println(map);

    }

    class Node{
        Node next;
        Node prev;
        int val;
        int key;
        Node(int key,int val,Node prev,Node next)
        {
            this.val = val;
            this.next = next;
            this.prev = prev;
            this.key = key;
        }
        void insert(Node n)
        {
            next = n;
            n.prev = this;
            n.next = null;
            if(tail == this)
            {
                tail = n;
            }
        }
        void delete()
        {
            if(prev != null)
            {
                prev.next = next;
            }
            else
            {
                head = next;
            }
            if(next != null)
            {
                next.prev = prev;
            }
            else
            {
                tail = prev;
            }
        }
        void setVal(int val)
        {
            this.val = val;
        }
        @Override
        public String toString()
        {
            String res = "$";
            if(prev != null)
                res+= "prev: "+prev.key;
            res+= " - key:"+key+":val:"+val;
            if(next != null)
                res+= " - next: "+next.key;
            res+="$";
            return res;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */