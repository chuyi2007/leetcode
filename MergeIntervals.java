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
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() == 0) {
            return new ArrayList<>();
        }
        Collections.sort(intervals, new IntervalComparator());
        int preStart = intervals.get(0).start;
        int preEnd = intervals.get(0).end;
        List<Interval> merged = new ArrayList<>();
        for (int i = 1; i < intervals.size(); ++i) {
            if (intervals.get(i).start <= preEnd) {
                // This Math.max is for case [1, 4] [2, 3]
                preEnd = Math.max(preEnd, intervals.get(i).end);
            } else {
                merged.add(new Interval(preStart, preEnd));
                preStart = intervals.get(i).start;
                preEnd = intervals.get(i).end;
            }
        }
        merged.add(new Interval(preStart, preEnd));
        return merged;
    }
    
    class IntervalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval i1, Interval i2) {
            if (i1.start < i2.start) {
                return -1;
            } else if (i1.start > i2.start) {
                return 1;
            } else if (i1.end < i2.end) {
                return -1;
            } else if (i1.end > i2.end) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}
