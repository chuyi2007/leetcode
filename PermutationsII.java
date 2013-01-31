public class Solution {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> results
        = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> result 
        = new ArrayList<Integer>();
        boolean[] set = new boolean[num.length];
        for(int i = 0; i < set.length; ++i)
            set[i] = false;
        Arrays.sort(num);
        naiveRecursion(results, result, set, num, 0);
        return results;
    }
    
    public void naiveRecursion(ArrayList<ArrayList<Integer>> results, 
    ArrayList<Integer> result, boolean[] set, int[] num, int count){
        if(count == num.length){
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            tmp.addAll(result);
            results.add(tmp);
        }
        else{
            for(int i = 0; i < num.length; ++i){
                if(!set[i]){
                    set[i] = true;
                    result.add(num[i]);
                    naiveRecursion(results, result, set, num, count + 1);
                    result.remove(result.size() - 1);
                    set[i] = false;
                    while(i < num.length - 1 && num[i] == num[i + 1])
                        ++i;
                }
            }
        }
    }
}