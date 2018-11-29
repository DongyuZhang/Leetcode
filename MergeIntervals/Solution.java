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
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals == null)
          return null;
        intervals.sort((x, y)->(x.start - y.start));
        for(int i = 0; i < intervals.size()-1; i++){
          Interval curr  = intervals.get(i), next = intervals.get(i+1);
          if(next.start <= curr.end){
            curr.end = Math.max(curr.end, next.end);
            intervals.remove(i+1);
            i--;
          }
        }
        return intervals;
    }
}
