public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Arrays.sort(S);
        return subsets(S, S.length - 1);
    }
    
    public ArrayList<ArrayList<Integer>> subsets(int[] S, int index){
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if(index < 0){
            results.add(new ArrayList<Integer>());
            return results;
        }
        else{
            results = subsets(S, index - 1);
            int size = results.size();
            for(int i = 0; i < size; ++i){
                ArrayList<Integer> result = new ArrayList<Integer>();
                result.addAll(results.get(i));
                result.add(S[index]);
                results.add(result);
            }
            return results;
        }
    }
public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> bt = new ArrayList<Integer>();
        Arrays.sort(S);
        bt.add(-1);
        backTrack(S, 0, bt, results);
        return results;
    }
    
    public void backTrack(int[] S, int index, ArrayList<Integer> bt, ArrayList<ArrayList<Integer>> results){
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            for(int i = 1; i <= index; ++i)
                tmp.add(S[bt.get(i)]);
            results.add(tmp);
        if(index < S.length) {
            for(int i = bt.get(index) + 1; i < S.length; ++i){
                bt.add(i);
                backTrack(S, index + 1, bt, results);
                bt.remove(bt.size() - 1);
            }    
        }
    }
}

public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Arrays.sort(S);
        return subsets(S, 0);
    }
    
    public ArrayList<ArrayList<Integer>> subsets(int[] S, int index){
        ArrayList<ArrayList<Integer>> results 
        = new ArrayList<ArrayList<Integer>>();
        if(index == S.length){
            results.add(new ArrayList<Integer>());
        }
        else if (index < S.length){
            results = subsets(S, index + 1);
            int size = results.size();
            for(int i = 0; i < results.size(); ++i){
                ArrayList<Integer> result = new ArrayList<Integer>(results.get(i));
                result.add(S[index]);
                results.add(result);
            }
        }
        return results;
    }
}