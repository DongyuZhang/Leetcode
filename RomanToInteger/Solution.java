class Solution {
    public int romanToInt(String s) {
        char[] arr = s.toCharArray();
        if(arr.length == 0)
          return 0;
        int prev = getRomanInteger(arr[0]);
        int res = 0;
        for(int i = 1; i < arr.length; i++){
          int curr = getRomanInteger(arr[i]);
          if(curr <= prev){
            res += prev;
          }
          else{
            res -= prev;
          }
          prev = curr;
        }
        res+= getRomanInteger(arr[arr.length-1]);
        return res;
    }
    private int getRomanInteger(char c){
      switch(c){
        case 'I': return 1;
        case 'V': return 5;
        case 'X': return 10;
        case 'L': return 50;
        case 'C': return 100;
        case 'D': return 500;
        case 'M': return 1000;
        default: return 0;
      }
    }
}
