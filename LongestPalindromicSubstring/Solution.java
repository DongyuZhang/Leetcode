class Solution {

    /*
    Dynamic Programming
    Denote dp[i][j] => s[i...j] is palindrome
    dp[i][i] = true, 0 <= i < s.len
    dp[i][i+1] = s[i] == s[i+1] 0 <= i < s.len-1
    dp[i][j] = dp[i+1][j-1] && s[i]==s[j], 0 <= i < s.len - 2, j >= i + 2
    */
    public String longestPalindrome(String s) {
        if(s.length() == 0 || s.length() == 1)
            return s;
        char[] arr = s.toCharArray();
        boolean[][] is_palindrome = new boolean[arr.length][arr.length];
        int start = 0, end = 0;
        // initialize stage
        for(int i = 0; i < arr.length - 1; i++){
            is_palindrome[i][i] = true;
            is_palindrome[i][i+1] = arr[i] == arr[i+1];
            if(is_palindrome[i][i+1]){
              start = i;
              end = i+1;
            }
        }
        is_palindrome[arr.length-1][arr.length-1] = true;
        // recursive stage
        for(int i = arr.length - 2; i >= 0; i--){
          for(int j = i+2; j < arr.length; j++){
            is_palindrome[i][j] = is_palindrome[i+1][j-1] && arr[i] == arr[j];
            if(is_palindrome[i][j] && j-i>end-start){
              start = i;
              end = j;
            }
          }
        }
        return s.substring(start, end+1);
    }

    public String longestPalindrome_aroundcorner(String s) {
        if(s == null || s.length() == 0 || s.length() == 1)
          return s;
        char[] arr = s.toCharArray();
        int start = 0, end = 0, len = 1;
        for(int i = 1; i < arr.length; i++){
          int[] t1 = search_around(i, i, arr);
          int[] t2 = search_around(i-1, i, arr);
          if(len < t1[0] || len < t2[0]){
            if(t1[0] > t2[0]){
              start = t1[1];
              end = t1[2];
            }
            else{
              start = t2[1];
              end = t2[2];
            }
            len = end-start+1;
          }
        }
        return s.substring(start, end+1);
    }
    private int[] search_around(int start, int end, char[] arr){
      int[] res = new int[3];
      while(start <= end && start >= 0 && end < arr.length && arr[start] == arr[end]){
        start--;
        end++;
      }
      res[0] = end - start - 1;
      res[1] = start + 1;
      res[2] = end - 1;
      return res;
    }

    public String longestPalindrome_aroundcorner_common(String s){
      if(s == null || s.length() == 0 || s.length() == 1)
        return s;
      int start = 0, end = 0;
      for(int i = 1; i < s.length(); i++){
        int len1 = getPalindromeLenth(i, i, s);
        int len2 = getPalindromeLenth(i-1, i, s);
        int len = Math.max(len1, len2);
        if(len > (end - start + 1)){
          start = i - len/2;
          end = start+len-1;
        }
      }
      return s.substring(start, end+1);
    }
    private int getPalindromeLenth(int start, int end, String s){
      while(start <= end && start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
        start--;
        end++;
      }
      return end-start-1;
    }


}
