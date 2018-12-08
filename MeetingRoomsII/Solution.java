/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public int minMeetingRooms(Interval[] intervals) {
      if(intervals.length == 0)
        return 0;
      PriorityQueue<Integer> allocator = new PriorityQueue<>(intervals.length,
                                                (x,y)->{return x-y;});
      // sort according to meeting start time
      Arrays.sort(intervals, (x, y)->{return x.start - y.start;});
      allocator.add(intervals[0].end);
      for(int i = 1; i < intervals.length; i++){
         if(intervals[i].start > allocator.peek()){
           allocator.poll();
         }
         allocator.add(intervals[i].end);
      }
      return allocator.size();
    }


    class Interval {
         int start;
         int end;
         Interval() { start = 0; end = 0; }
         Interval(int s, int e) { start = s; end = e; }
     }
}
