class LRUCache:

    def __init__(self, capacity):
        """
        :type capacity: int
        """
        self.capacity = capacity
        self.cache = dict()
        self.dummyHead = Node(0, 0)
        self.dummyTail = Node(0, 0)
        self.dummyHead.next = self.dummyTail
        self.dummyTail.prev = self.dummyHead
        

    def get(self, key):
        """
        :type key: int
        :rtype: int
        """
        if key in self.cache:
            curr = self.cache[key]
            self._separateCur(curr)
            self._moveToFront(curr)
            return curr.value
        return -1
        

    def put(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: void
        """
        if key in self.cache:
            curr = self.cache[key]
            self._separateCur(curr)
            self._moveToFront(curr)
            curr.value = value
        else:
            if len(self.cache) == self.capacity:
                self._removeLast()
            curr = Node(key, value)
            self.cache[key] = curr
            self._moveToFront(curr)


    def _removeLast(self):
        last = self.dummyTail.prev
        del self.cache[last.key]
        self._separateCur(last)


    def _separateCur(self, curr):
        if(curr.next is not None and curr.prev is not None):
            curr.prev.next = curr.next
            curr.next.prev = curr.prev
            curr.next = None
            curr.prev = None

    def _moveToFront(self, curr):
        curr.next = self.dummyHead.next
        curr.prev = self.dummyHead
        self.dummyHead.next.prev = curr
        self.dummyHead.next = curr

        
class Node:
    def __init__(self, key, value):
        self.key = key
        self.value = value
        self.prev = None
        self.next = None    


# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)