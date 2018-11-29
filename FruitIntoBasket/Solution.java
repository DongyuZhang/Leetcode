class Solution {
    public int totalFruit(int[] tree) {
        int res = 0, last = -1, secondLast = -1, lastlen = 0, currlen = 0;
        for(int fruit : tree){
          currlen = (fruit == secondLast || fruit == last) ? currlen + 1 : lastlen + 1;
          lastlen = fruit == last ? lastlen + 1 : 1;
          if(fruit != last){
            secondLast = last;
            last = fruit;
          }
          res = Math.max(res, currlen);
        }
        return res;
    }

    public int totalFruit_slidingwindow(int[] tree){
      int res = 0, i = 0;
      Counter count = new Counter();
      for(int j = 0; j < tree.length; j++){
        count.add(tree[j], 1);
        while(count.size() > 2){
          //remove the left element and find the location of current start point i
          count.add(tree[i], -1);
          if(count.get(tree[i]) == 0){
            //i has been moved to the right place, remove tree[i] to exit the loop
            count.remove(tree[i]);
          }
          i++;
        }
        res = Math.max(res, j-i+1);
      }
      return res;
    }

    class Counter extends HashMap<Integer, Integer>{
      @override
      public int get(int k){
        return containsKey(k)? super.get(k) : 0;
      }

      public void add(int k, int v){
        put(k, get(k)+v);
      }
    }
}
