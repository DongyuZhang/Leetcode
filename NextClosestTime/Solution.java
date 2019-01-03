class Solution {
    public String nextClosestTime(String time) {
      Set<Integer> validNumbers = new HashSet<>(4);
      char[] arr = time.toCharArray();
      for(char c : arr)
        if(c != ':') validNumbers.add(c-'0');
      int mins = ((arr[0]-'0')*10+(arr[1]-'0'))*60+(arr[3]-'0')*10+(arr[4]-'0');
      for(int i = 0; i < 24*60; i++){
        mins = (mins+1)%(24*60);
        int[] digits = new int[]{mins/60/10, mins/60%10, mins%60/10, mins%60%10};
        search:{
          for(int d : digits){
            if(!validNumbers.contains(d))
              break search;
          }
          return String.format("%02d:%02d", mins/60, mins%60);
        }
      }
      return time;
    }


    /*
    Construct all possible hours
    Construct all possible mins
    if there is one mins > current mins then just return that mins + current hour
    if there is one hours > current hours then just return that hours + min{mins}
    else return min{hours}, min{mins}
    */
    public String nextClosestTime_Mysolution(String time){
      Set<Integer> validNumbers = new HashSet<>(4);
      char[] arr = time.toCharArray();
      List<Integer> hours = new ArrayList<>();
      List<Integer> mins = new ArrayList<>();
      int curr_hour = (arr[0]-'0')*10+arr[1]-'0';
      int curr_min = (arr[3]-'0')*10+arr[4]-'0';
      for(char c : arr)
        if(c!=':') validNumbers.add(c-'0');
      for(int i = 0; i < arr.length; i++){
        for(int j = i; j < arr.length; j++){
          if(i!=2 && j!=2){
            int temp = (arr[i]-'0')*10+(arr[j]-'0');
            if(temp<60)
              mins.add(temp);
            if(temp<24)
              hours.add(hour);
          }
        }
      }
      Collection.sort(hours);
      Collection.sort(mins);
      for(int x : mins){
        if(x>curr_min)
          return String.format("%02d:%02d", curr_hour, x);
      }
      for(int x : hours){
        if(x>curr_hour)
          return String.format("%02d:%02d", x, mins.get(0));
      }
      return String.format("%02d:%02d", hours.get(0), mins.get(0));
    }

}
