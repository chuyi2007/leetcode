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
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        Queue<Interval> q = new PriorityQueue<>(new Comparator<Interval>() {
            @Override
            public int compare(Interval a, Interval b) {
                return a.end - b.end;
            }
        });
        q.offer(intervals[0]);
        for (int i = 1; i < intervals.length; ++i) {
            Interval interval = intervals[i];
            Interval cur = q.poll();
            if (interval.start >= cur.end) {
                cur.end = Math.max(cur.end, interval.end);
            } else {
                q.offer(interval);
            }
            q.offer(cur);
        }
        return q.size();
    }
}
