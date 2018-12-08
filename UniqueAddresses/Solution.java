class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> hs = new HashSet<>(emails.length);
        for(String email : emails){
          hs.add(getRealEmailAddress(email));
        }
        return hs.size();
    }

    private String getRealEmailAddress(String email){
      StringBuilder res = new StringBuilder();
      char[] arr = email.toCharArray();
      int partition_loc = -1;
      boolean isContinueSearch = true;
      for(int i = 0; i < arr.length; i++){
        if(arr[i] == '@'){
          partition_loc = i;
          break;
        }
        if(arr[i] == '+')
          isContinueSearch = false;
        if(isContinueSearch && arr[i] != '.')
          res.append(arr[i]);
      }
      if(partition_loc == -1)
        return email;
      for(int i = partition_loc; i < arr.length; i++){
        res.append(arr[i]);
      }
      return res.toString();
    }

    public int numUniqueEmails_stringops(String[] emails) {
        Set<String> seen = new HashSet<>(emails.length);
        for(String email : emails){
          int i = email.indexOf('@');
          String local = emails.substring(0, i);
          String rest = emails.substring(i+1);
          if(local.contains('+')){
            int j = local.indexOf('+');
            local = local.substring(0, j);
          }
          local = local.replaceAll('.', '');
          seen.add(local+rest);
        }
        return seen.size();
    }
}
