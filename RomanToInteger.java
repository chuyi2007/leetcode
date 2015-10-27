//O(N)
public class Solution {
    public int romanToInt(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int len = s.length();
        int sum = 0;
        for (int i = 0; i < len; ++i) {
            int cur = map.get(s.charAt(i));
            if (i < len - 1 && map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                sum -= cur;
            } else {
                sum +=cur;
            }
        }
        return sum;
    }
}
