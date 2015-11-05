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
        int res = 0;
        for (int i = 0; i < points.length; ++i) {
            Map<String, Integer> lineToCount = new HashMap<String, Integer>();
            int max = 0, dup = 0;
            for (int j = i + 1; j < points.length; ++j) {
                int x = points[i].x - points[j].x;
                int y = points[i].y - points[j].y;
                if (x == 0 && y == 0) {
                    ++dup;
                    continue;
                }
                // If the line is parallel to x or y
                // we want to keep the key always positive
                if (x == 0 || y == 0) {
                    x = Math.abs(x);
                    y = Math.abs(y);
                }
                int gcd = getGCD(Math.abs(x), Math.abs(y));
                gcd = x >= 0 ? gcd : -gcd;
                int xKey = x / gcd;
                int yKey = y / gcd;
                String key = String.valueOf(xKey) + " " + String.valueOf(yKey);
                if (!lineToCount.containsKey(key)) {
                    lineToCount.put(key, 0);
                }
                lineToCount.put(key, lineToCount.get(key) + 1);
                max = Math.max(max, lineToCount.get(key));
            }
            // adding 1 as x itself
            res = Math.max(res, max + dup + 1);
        }
        return res;
    }
    
    public int getGCD(int a, int b) {
        return b == 0 ? a : getGCD(b, a % b);
    }
}

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
