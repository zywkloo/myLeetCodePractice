public class LRUCache {
    Map<Integer,Integer> map;
    int cap;
    public LRUCache(int capacity) {
        map=new LinkedHashMap();
        cap=capacity;
    }
    
    public int get(int key) {
       int result=-1;
       if(map.containsKey(key)){
           result=map.get(key);
           map.remove(key);
           map.put(key,result);
       }
        return result;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key))
            map.remove(key);
        else if(map.size()==cap){
            Map.Entry<Integer,Integer> entry=map.entrySet().iterator().next();
            int first=entry.getKey();
            map.remove(first);
        }
        map.put(key,value);
    }
}

// public class LRUCache {

//   class DLinkedNode {
//     int key;
//     int value;
//     DLinkedNode prev;
//     DLinkedNode next;
//   }

//   private void addNode(DLinkedNode node) {
//     /**
//      * Always add the new node right after head.
//      */
//     node.prev = head;
//     node.next = head.next;

//     head.next.prev = node;
//     head.next = node;
//   }

//   private void removeNode(DLinkedNode node){
//     /**
//      * Remove an existing node from the linked list.
//      */
//     DLinkedNode prev = node.prev;
//     DLinkedNode next = node.next;

//     prev.next = next;
//     next.prev = prev;
//   }

//   private void moveToHead(DLinkedNode node){
//     /**
//      * Move certain node in between to the head.
//      */
//     removeNode(node);
//     addNode(node);
//   }

//   private DLinkedNode popTail() {
//     /**
//      * Pop the current tail.
//      */
//     DLinkedNode res = tail.prev;
//     removeNode(res);
//     return res;
//   }

//   private Map<Integer, DLinkedNode> cache = new HashMap<>();
//   private int size;
//   private int capacity;
//   private DLinkedNode head, tail;

//   public LRUCache(int capacity) {
//     this.size = 0;
//     this.capacity = capacity;

//     head = new DLinkedNode();
//     // head.prev = null;

//     tail = new DLinkedNode();
//     // tail.next = null;

//     head.next = tail;
//     tail.prev = head;
//   }

//   public int get(int key) {
//     DLinkedNode node = cache.get(key);
//     if (node == null) return -1;

//     // move the accessed node to the head;
//     moveToHead(node);

//     return node.value;
//   }

//   public void put(int key, int value) {
//     DLinkedNode node = cache.get(key);

//     if(node == null) {
//       DLinkedNode newNode = new DLinkedNode();
//       newNode.key = key;
//       newNode.value = value;

//       cache.put(key, newNode);
//       addNode(newNode);

//       ++size;

//       if(size > capacity) {
//         // pop the tail
//         DLinkedNode tail = popTail();
//         cache.remove(tail.key);
//         --size;
//       }
//     } else {
//       // update the value.
//       node.value = value;
//       moveToHead(node);
//     }
//   }
// }

// class LRUCache {
    
    
//     HashMap<Integer,List<Integer>> m = new HashMap<>();
//     Queue<Integer> s = new LinkedList<>(); 
//     int capacity;

//     public LRUCache(int capacity) {
//         this.capacity = capacity;
//     }
    
//     public int get(int key) {

//         if (this.m.containsKey(key)){
//             int freq = m.get(key).get(1);
//             int v =  m.get(key).get(0);
//             m.put(key,Arrays.asList(new Integer[] { v,freq+1 }));
//             this.s.offer(key);
//             // System.out.println("haha "+m);
//             return v;
//         } else return -1;
//     }
    
//     public void put(int key, int value) {
//         if (m.size()>=this.capacity && !this.m.containsKey(key)) {
//             int hKeyTrack =s.peek();
//             int freq = m.get(hKeyTrack).get(1);
//             while (freq>1){
//                 s.poll();
//                 m.put(hKeyTrack, Arrays.asList(new Integer[] { m.get(hKeyTrack).get(0),freq-1}));
//                 hKeyTrack = s.peek();
//                 freq = m.get(hKeyTrack).get(1);
//             }
//             if(freq<=1){
//                 s.poll();
//                 m.remove(hKeyTrack);
//             }
//         }
//         // System.out.println(""+key+ ","+value);
//         if (!this.m.containsKey(key)){
//             m.put(key, Arrays.asList(new Integer[] {value,1}));
//         } else {
//             int freq = this.m.get(key).get(1);
//             m.put(key, Arrays.asList(new Integer[] {value,freq+1}));
//         }
//         s.offer(key);
//         // System.out.println(s+"haha "+m);

//     }
// }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
