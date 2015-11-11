public class Solution {
    Map<Character, List<Character>> dependents = new HashMap<>();
    Map<Character, Integer> depth = new HashMap<>();
    public String alienOrder(String[] words) {
        // Preprocessing, make all chars depth = 0
        for (String w : words) {
            for (char c : w.toCharArray()) {
                depth.put(c, 0);
            }
        }
        for (int i = 0; i < words.length - 1; ++i) {
            getPartialOrder(words[i], words[i + 1]);
        }
        Queue<Character> q = new LinkedList<>();
        String totalOrder = "";
        for (Map.Entry<Character, Integer> e : depth.entrySet()) {
            if (e.getValue() == 0) {
                q.offer(e.getKey());
                totalOrder += e.getKey();
            }
        }
        while (!q.isEmpty()) {
            char cur = q.poll();
            if (dependents.containsKey(cur)) {
                for (char dep : dependents.get(cur)) {
                    depth.put(dep, depth.get(dep) - 1);
                    if (depth.get(dep) == 0) {
                        q.offer(dep);
                        totalOrder += dep;
                    }
                }
            }
        }
        return totalOrder.length() == depth.size() ? totalOrder : "";
    }
    
    public void getPartialOrder(String a, String b) {
        for (int i = 0; i < Math.min(a.length(), b.length()); ++i) {
            char c = a.charAt(i), d = b.charAt(i);
            if (c != d) {
                if (!dependents.containsKey(c)) {
                    dependents.put(c, new ArrayList<>());
                }
                dependents.get(c).add(d);
                depth.put(d, depth.get(d) + 1);
                break;
            }
        }
    }
}
