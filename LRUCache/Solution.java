/*
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

Follow up:
Could you do both operations in O(1) time complexity?
*/
class LRUCache {

	Map<Integer, Node> cache;
	Node dummyFirst, dummyLast;
	int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>(capacity);
        this.dummyFirst = new Node(0, 0);
        this.dummyLast = new Node(0, 0);
        dummyFirst.next = dummyLast;
        dummyLast.prev = dummyFirst;
    }
    
    public int get(int key) {
    	if(!cache.containsKey(key))
    		return -1;
    	Node curr = cache.get(key);
    	separateFromList(curr);
    	moveToFront(curr);
    	return curr.value;   
    }
    
    public void put(int key, int value) {
    	if(cache.containsKey(key)){
    		Node curr = cache.get(key);
    		curr.value = value;
    		separateFromList(curr);
    		moveToFront(curr);
    	}
    	else{
    		if(cache.size() == capacity)
    			removeFromEnd();
    		Node curr = new Node(key, value);
    		moveToFront(curr);
            cache.put(key, curr);
    	}
    }

    private void separateFromList(Node curr){
    	if(curr.prev != null && curr.next != null){
	    	curr.prev.next = curr.next;
	    	curr.next.prev = curr.prev;
	    	curr.prev = null;
	    	curr.next = null;
	    	}
    }

    private void moveToFront(Node curr){
    	curr.next = dummyFirst.next;
    	curr.prev = dummyFirst;
    	dummyFirst.next.prev = curr;
    	dummyFirst.next = curr;
    }

    private void moveToEnd(Node curr){
    	curr.next = dummyLast;
    	curr.prev = dummyLast.prev;
    	dummyLast.prev.next = curr;
    	dummyLast.prev = curr;
    }

    private void removeFromEnd(){
    	Node last = dummyLast.prev;
        cache.remove(last.key);
    	last.prev.next = dummyLast;
    	dummyLast.prev = last.prev;
    	last.prev = null;
    	last.next = null;
    }

    class Node{
    	int key, value;
    	Node next, prev;
    	Node(int key, int value){
    		this.key = key;
    		this.value = value;
    	}
    }


}