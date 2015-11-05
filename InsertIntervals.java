/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int startIndex = -1, endIndex = -1;
        for (int i = 0; i < intervals.size(); ++i) {
            if (startIndex == -1 && newInterval.start <= intervals.get(i).end) {
                startIndex = i;
            }
            if (newInterval.end >= intervals.get(i).start) {
                endIndex = i;
            }
        }
        
        if (startIndex == -1) {
            intervals.add(newInterval);
        } else if (endIndex == -1) {
            intervals.add(0, newInterval);
        } else {
            Interval tmp = new Interval(Math.min(intervals.get(startIndex).start, newInterval.start), 
                                        Math.max(intervals.get(endIndex).end, newInterval.end));
            intervals.subList(startIndex, endIndex + 1).clear();
            intervals.add(startIndex, tmp);
        }
        return intervals;
    }
}
