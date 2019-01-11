class Solution {

  /*
  dp[i] denotes that the number of decoding ways for s[0...i]
  */

    public int numDecodings(String s) {
        if(s.length() == 0)
          return 0;
        char[] arr = s.toCharArray();
        if(arr[0] == '0')
          return 0;
        int last = 1, secondLast = 1, curr = 0;
        for(int i = 1; i < arr.length; i++){
          if(arr[i] == '0'){
            if(arr[i-1] != '1' && arr[i-1] != '2')
              return 0;
            curr = secondLast;
          }
          else{
            if(arr[i-1] == '0' || arr[i-1] > '2' || arr[i-1] == '2' && arr[i] > '6'){
              curr = last;
            }
            else{
              curr = last + secondLast;
            }
          }
          secondLast = last;
          last = curr;
        }
        return last;
    }
}
