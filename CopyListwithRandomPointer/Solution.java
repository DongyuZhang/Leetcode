public class Solution {

    Map<RandomListNode, RandomListNode> visitedNodes = new HashMap<>();

    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null)
          return null;
        RandomListNode res = new RandomListNode(head.label);
        RandomListNode newNode = res, oldNode = head;
        this.visitedNodes.put(oldNode, newNode);
        while(oldNode != null){
          newNode.next = getCloneNodeOrNew(oldNode.next);
          newNode.random = getCloneNodeOrNew(oldNode.random);
          oldNode = oldNode.next;
          newNode = newNode.next;
        }
        return res;
    }

    public RandomListNode copyRandomList_recursive(RandomListNode head){
      if(head == null)
        return null;
      if(visitedNodes.containsKey(head))
        return visitedNodes.get(head);
      RandomListNode node = new RandomListNode(head.label);
      visitedNodes.put(head, node);
      node.next = copyRandomList_recursive(head.next);
      node.random = copyRandomList_recursive(head.random);
      return node;
    }

    private RandomListNode getCloneNodeOrNew(RandomListNode node){
      if(node == null)
        return null;
      if(visitedNodes.containsKey(node))
        return visitedNodes.get(node);
      else{
        RandomListNode res = new RandomListNode(node.label);
        this.visitedNodes.put(node, res)
        return res;
      }
    }

    public RandomListNode copyRandomList_weave(RandomListNode head){
        if(head == null)
            return null;
        RandomListNode head1 = head;
        //create a weave list
        while(head1 != null){
          RandomListNode node = new RandomListNode(head1.label);
          node.next = head1.next;
          head1.next = node;
          head1 = node.next;
        }
        RandomListNode res = head.next;
        head1 = head;
        //set up the random value
        while(head1 != null){
          head1.next.random = head1.random == null? null: head1.random.next;
          head1 = head1.next.next;
        }
        head1 = head;
        //set up the next value
        while(head1 != null){
          RandomListNode node = head1.next;
          head1.next = node.next;
          head1 = node.next;
          node.next = head1 == null? null : head1.next;
        }
        return res;
    }


    class RandomListNode{
      int label;
      RandomListNode next, random;
      RandomListNode(int x){ this.label = x; }
    }
}
