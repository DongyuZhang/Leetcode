class Solution {
    public String licenseKeyFormatting(String S, int K) {
        if(K<=0)
          return S;
        S = S.replaceAll("-","").toUpperCase();
        StringBuilder res = new StringBuilder(S);
        for(int i = arr.length%K; i < arr.length; i+=K){
          sb.insert(i, '-');
        }
        return sb.toString();
    }

    public String licenseKeyFormatting2(String S, int K){
      StringBuilder res = new StringBuilder();
      char[] arr = S.toCharArray();
      int counter = 0;
      for(int i = arr.length-1; i >= 0; i--){
        if(arr[i] != '-'){
          res.append(arr[i]);
          if(counter-- == 0 && i != 0){
            counter = K;
            res.append('-');
          }
        }
      }
      return sb.reverse().toUpperCase().toString();
    }
}
