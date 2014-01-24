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
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int size = intervals.size();
        int s = -1, e = -1;
        for (int i = 0; i < size; ++i) {
            if (s == -1 && intervals.get(i).end >= newInterval.start) {
                s = i;
            }
            if (intervals.get(i).start <= newInterval.end) {
                e = i;
            }
        }
        if (s == -1) {
            intervals.add(newInterval);
            return intervals;
        }
        if (e == -1) {
            intervals.add(0, newInterval);
            return intervals;
        }
        //if(s == e)    return intervals;
        int f = Math.min(intervals.get(s).start, newInterval.start);
        int l = Math.max(intervals.get(e).end, newInterval.end);
        newInterval = new Interval(f, l);
        intervals.subList(s, e + 1).clear();
        intervals.add(s, newInterval);
        return intervals;
    }
}