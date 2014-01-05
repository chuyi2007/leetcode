//Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {  
    public int maxPoints(Point[] points) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int result = 0;
        for (int i = 0; i < points.length; ++i) {
            int dup = 1, max = 0;
            HashMap<String, Integer> count = new HashMap<String, Integer>();
            for (int j = i + 1; j < points.length; ++j) {
                int x = points[i].x - points[j].x;
                int y = points[i].y - points[j].y;
                int g = gcd(x, y);
                if (g == 0) {
                    ++dup;
                    continue;
                }
                String line = x / g + " " + y / g;
                int val = 0;
                if (count.containsKey(line)) {
                    val = count.get(line) + 1;
                }
                else {
                    val = 1;
                }
                count.put(line, val);
                max = Math.max(max, val);
            }
            result = Math.max(result, dup + max);
        }
        return result;
    }
    
    public int gcd(int a, int b) {
        return a != 0 ? a / Math.abs(a) * Math.abs(gcd (b % a, a)) : b;
    }
}