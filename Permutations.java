public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        boolean[] set = new boolean[num.length];
        for(int i = 0; i < set.length; ++i)
            set[i] = false;
        backTracking(results, result, num, set, 0);
        return results;
    }
    public void backTracking(ArrayList<ArrayList<Integer>> results, 
    ArrayList<Integer> result, int[] num, boolean[] set, int count){
        if(count == num.length){
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            tmp.addAll(result);
            results.add(tmp);
        }
        else{
            for(int i = 0; i < num.length; ++i){
                if(set[i] == false){
                    set[i] = true;
                    result.add(num[i]);
                    backTracking(results, result, num, set, count + 1);
                    result.remove(result.size() - 1);
                    set[i] = false;
                }
            }
        }
    }
}