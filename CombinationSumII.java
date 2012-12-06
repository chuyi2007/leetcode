public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Arrays.sort(num); 
 
        ArrayList<Integer> backtrack = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        backtrack.add(-1);
        backTrack(num, target, 0, backtrack, results);
        return results;
    }
    
    public void backTrack(int[] num, int target, int sum,
    ArrayList<Integer> backtrack,ArrayList<ArrayList<Integer>> results){
        if(target == sum){
            ArrayList<Integer> result = new ArrayList<Integer>();
            for(int i = 1; i < backtrack.size(); ++i)
                result.add(num[backtrack.get(i)]);
            results.add(result);
        }
        else if(target > sum){
            for(int i = backtrack.get(backtrack.size() - 1) + 1; i < num.length; i++){
                backtrack.add(i);
                backTrack(num, target, sum + num[i], backtrack, results);
                backtrack.remove(backtrack.size() - 1);
                while(i < num.length -1 && num[i] == num[i + 1]) ++i;
            }
        }
    }
}