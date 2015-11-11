public class Solution {
    public List<String> findStrobogrammatic(int n) {
        return findStrobogrammatic(n, n);
    }
    
    public List<String> findStrobogrammatic(int n, int m) {
        if (n == 0) {
            return new ArrayList<>(Arrays.asList(""));
        }
        if (n == 1) {
            return new ArrayList<>(Arrays.asList("0", "1", "8"));
        }
        List<String> res = findStrobogrammatic(n - 2, m);
        List<String> all = new ArrayList<>();
        for (String s : res) {
            if (n < m) {
                all.add("0" + s + "0");
            }
            all.add("1" + s + "1");
            all.add("8" + s + "8");
            all.add("6" + s + "9");
            all.add("9" + s + "6");
        }
        return all;
    }
}
