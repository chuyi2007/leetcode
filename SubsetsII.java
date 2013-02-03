public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
 
        //almost the same backtrack algorithm of combination sum II
        if (num.length == 0) {
            return null;
        }
        Arrays.sort(num);
        ArrayList<Integer> bt = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        bt.add(-1);
        backtrack(num, results, bt, 0);
        return results;
    }
 
    //backtrack array contains the indexes
    public void backtrack(int[] num, ArrayList<ArrayList<Integer>> results, 
    ArrayList<Integer> bt, int index) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i = 1; i <= index; ++i)
            result.add(num[bt.get(i)]);
        results.add(result);
        if(index < num.length){
            for(int i = bt.get(index) + 1; i < num.length; ++i){
                bt.add(i);
                backtrack(num, results, bt, index + 1);
                bt.remove(bt.size() - 1);
                while(i < num.length - 1 && num[i] == num[i + 1])
                    ++i;
            }
        }
 
    }
}

public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Arrays.sort(num);
        return subsetsWithDup(num, num.length - 1, new HashSet<ArrayList<Integer>>());
    }
    
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num, int index, HashSet<ArrayList<Integer>> set){
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if(index < 0){
            results.add(new ArrayList<Integer>());
        }
        else{
            results = subsetsWithDup(num, index - 1, set);
            int size = results.size();
            for(int i = 0; i < size; ++i){
                ArrayList<Integer> tmp = new ArrayList<Integer>(results.get(i));
                tmp.add(num[index]);
                if(!set.contains(tmp)){
                    results.add(tmp);
                    set.add(tmp);
                }
            }
        }
        return results;
    }
}