class Solution {
    public boolean isPalindrome(int x) {
        String s = Integer.toString(x);
        StringBuilder sb = new StringBuilder(s);
        return s.equals(sb.reverse().toString());
    }

    public boolean isPalindrome_number(int x){
      if(x < 0 || x!=0 && x%10 == 0)
        return false;
      int reversed_num = 0;
      while(x > reversed_num){
        reversed_num = reversed_num * 10 + x%10;
        x /= 10;
      }
      return x == reversed_num || (x == (reversed_num/10 ));
    }
}
