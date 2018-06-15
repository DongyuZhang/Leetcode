public class FindUnion {
    static  int[] parent;

    public static void main(String[] args){
        int[][] group = {
                {1,2},
                {10,13,11,12,14},
                {0,1},
                {99,2}
        };
        System.out.print(getSickCount(group, 100));
    }


    private static int find(int x){
        //find the ancestor of x
        int res = x;
        while(parent[res] != res)
            res = parent[res];
        //res is the ancestor now. Compress the Path
        while(x != res){
            int p = parent[x];
            parent[x] = res;
            x = p;
        }
        return res;
    }
    private static void union(int u, int v){
        //union u's group and v's group
        //just let u's ancestor to be the child of v'sancestor
        int ancestor_u = find(u);
        int ancestor_v = find(v);
        //if they are currently not in the same group
        if(ancestor_u != ancestor_v)
            parent[u] = v;
    }
    private static void init(){
        for(int i = 0; i < parent.length; i++){
            parent[i] = i;
        }
    }
    /*Example OJ Problem
        x People with number 0 to (x-1)
        Given a lot of groups with member numbers within the group
        Number 0 has some disease and people in the same group will get that disease
        How many people will get that disease?
     */
    public static int getSickCount(int[][] group, int x){
        parent = new int[x];
        init();
        // union every group
        for(int i = 0; i < group.length; i++){
            if(group[i].length == 0)
                continue;
            int last = group[i][0];
            for(int j = 1; j < group[i].length; j++){
                union(last, group[i][j]);
            }
        }
        // get the count
        int res = 1;
        int boss = find(0);
        for(int i = 1; i < x; i++){
            if(find(i)==boss)
                res++;
        }
        return res;
    }
}
