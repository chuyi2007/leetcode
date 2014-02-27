/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
//O(N)
public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Interval> results = new ArrayList<Interval>();
        if (intervals.size() < 1) {
            return intervals;
        }   
        Collections.sort(intervals, new IntervalComparator());
        int start = intervals.get(0).start, end = intervals.get(0).end;
        for (int i = 0; i < intervals.size(); ++i) {
            Interval a = intervals.get(i);
            if (end < a.start) {
                results.add(new Interval(start, end));
                start = a.start;
                end = a.end;
            }
            //special case: [0, 6] [1, 2] [3, 5]
            else {
                end = Math.max(end, a.end);
            }
        }
        results.add(new Interval(start, end));
        return results;
    }
}

class IntervalComparator implements Comparator<Interval> {
    public final int compare(Interval a, Interval b) {
        if (a.start < b.start) {
            return -1;
        }
        else if (a.start > b.start) {
            return 1;
        }
        else if (a.end <= b.end) {
            return -1;
        }
        else {
            return 1;
        }
    }
}