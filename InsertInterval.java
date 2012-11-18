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
        int intervalNum = intervals.size();
        ArrayList<Interval> pres = new ArrayList<Interval>();
        ArrayList<Interval> poss = new ArrayList<Interval>();
        ArrayList<Interval> results = new ArrayList<Interval>();
        if(intervalNum == 0)
            results.add(newInterval);
        else if(newInterval.end < intervals.get(0).start){
            results.add(newInterval);
            for(Interval inte: intervals)
                results.add(inte);
        }
        else if(newInterval.start > intervals.get(intervalNum-1).end){
            intervals.add(newInterval);
            results = intervals;
        }
        else{
            for(int i = 0, j = intervalNum - 1; i <= j + 1;){
                Interval pre = intervals.get(i);
                Interval pos = intervals.get(j);
                if(newInterval.start <= pre.end && newInterval.end >= pos.start){
                    Interval upd = new Interval(Math.min(pre.start,newInterval.start), 
                                                Math.max(pos.end, newInterval.end));
                    for(Interval intev: pres)
                        results.add(intev);
                    results.add(upd);
                    for(int k = poss.size() - 1; k >= 0; k--)
                        results.add(poss.get(k));
                    break;
                }
                
                if(newInterval.end < pre.start && newInterval.start > pos.end){
                    for(Interval intev: pres)
                        results.add(intev);
                    results.add(newInterval);
                    
                    for(int k = poss.size() - 1; k >= 0; k--)
                        results.add(poss.get(k));
                    break;
                }
                
                if(newInterval.start > pre.end){
                    pres.add(pre);
                    i++;
                }
                else if(newInterval.end < pos.start){
                    poss.add(pos);
                    j--;
                }


            }
        }
        return results;
    }
}