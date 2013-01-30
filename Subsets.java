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
}