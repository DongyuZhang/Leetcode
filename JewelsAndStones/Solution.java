class Solution {
    public int numJewelsInStones(String J, String S) {
        int res = 0;
        Set<Character> jewels = new HashSet<>(J.length());
        char[] arr_J = J.toCharArray();
        char[] arr_S = S.toCharArray();
        for(char c : arr_J)
          jewels.add(c);
        for(char c : arr_S){
          if(jewels.contains(c))
            res++;
        }
        return res;
    }
}
