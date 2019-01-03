class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        formParenthesis("", 0, 0, n, res);
        return res;
    }

    private void formParenthesis(String curr, int open, int close, int max, List<String> res){
      if(curr.length() == max * 2){
        res.add(curr);
        return;
      }
      if(open < max){
        formParenthesis(curr+"(", open+1, close, max, res);
      }
      if(open > close){
        formParenthesis(curr+")", open, close+1, max, res);
      }
    }
}
