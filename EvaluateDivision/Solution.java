class Solution {
  /*
  equations = [ ["a", "b"], ["b", "c"] ],
  values = [2.0, 3.0],
  queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].

  Notation: dist[s] = s/parent[s]
  */
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        UnionFind unionfind = new UnionFind(values.length);
        double[] res = new double[queries.length];
        // Union every equation
        for(int i = 0; i < values.length; i++){
          unionfind.union(equations[i][0], equations[i][1], values[i]);
        }
        for(int i = 0; i < queries.length; i++){
          res[i] = unionfind.calcDist(queries[i][0], queries[i][1]);
        }
        return res;
    }

    class UnionFind{
      Map<String, String> parent;
      Map<String, Double> dist;

      public UnionFind(){
        parent = new HashMap<>();
        dist = new HashMap<>();
      }
      public UnionFind(int capacity){
        parent = new HashMap<>(capacity);
        dist = new HashMap<>(capacity);
      }

      public void union(String s1, String s2, double value){
        String p1 = find(s1);
        String p2 = find(s2);
        parent.put(p1, p2);
        //dist[p1] = p1/parent[p1] = p1/p2 = (s1/dist[s1])/(s2/dist[s2])
        //         =s1/s2 * dist[s2]/dist[s1] = value * dist[s2] / dist[s1]
        dist.put(p1, value * dist.get(s2) / dist.get(s1));
      }

      // get the root parent of s1 and make the parent of s1 to root parent
      public String find(String s1){
        // not exist
        if(!parent.containsKey(s1)){
          parent.put(s1, s1);
          dist.put(s1, 1.0);
          return s1;
        }
        // s itself is root parent
        if(parent.get(s1)==s1){
          return s1;
        }
        String lastP = parent.get(s1);
        String rootP = find(lastP);
        parent.put(s1, rootP);
        // s1/parent[s1] = dist[s1], parent[s1]/parent[parent[s1]]=dist[parent[s1]]
        //s1/parent[parent[s1]] = dist[s1] * parent[s1] / parent[s1] * dist[parent[s1]]
        //                      = dist[s1] * dist[parent[s1]]
        dist.put(s1, dist.get(s1) * dist.get(lastP));
        return rootP;
      }

      public double calcDist(String s1, String s2){
        if(!parent.containsKey(s1) || !parent.containsKey(s2))
          return -1.0;
        String p1 = find(s1);
        String p2 = find(s2);
        if(p1!=p2)
          return -1.0;
        return dist.get(s1)/dist.get(s2);
      }
    }
}
