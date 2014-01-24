//BackTrack Solution, O(2^N), o(N)
public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> bt = new ArrayList<Integer>();
        bt.add(-1);
        Arrays.sort(num);
        subsetsWithDup(num, 0, bt, results);
        return results;
    }
    
    public void subsetsWithDup(int[] num, int index, ArrayList<Integer> bt,
                               ArrayList<ArrayList<Integer>> results) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 1; i < bt.size(); ++i) {
            result.add(num[bt.get(i)]);
        }
        results.add(result);
        for (int i = bt.get(index) + 1; i < num.length; ++i) {
            bt.add(i);
            subsetsWithDup(num, index + 1, bt, results);
            bt.remove(bt.size() - 1);
            while(i < num.length - 1 && num[i] == num[i + 1]) {
                ++i;
            }
        }
    }
}

//Recursion with extra space (HashSet), O(2^N)
public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Arrays.sort(num);
        return subsetsWithDup(num, num.length - 1, new HashSet<ArrayList<Integer>>());
    }
    
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num, 
                                                        int index, 
                                                        HashSet<ArrayList<Integer>> set) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if (index < 0) {
            results.add(new ArrayList<Integer>());
        }
        else {
            results = subsetsWithDup(num, index - 1, set);
            int size = results.size();
            for (int i = 0; i < size; ++i) {
                ArrayList<Integer> tmp = new ArrayList<Integer>(results.get(i));
                tmp.add(num[index]);
                if (!set.contains(tmp)) {
                    results.add(tmp);
                    set.add(tmp);
                }
            }
        }
        return results;
    }
}