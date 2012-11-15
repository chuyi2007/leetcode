public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if(numRows == 0) 
            return results;
        else if(numRows == 1){
            ArrayList<Integer> result = new ArrayList<Integer>();
            result.add(1);
            results.add(result);
            return results;
        }
        else{
            results = generate(numRows - 1);
            ArrayList<Integer> pre = results.get(numRows - 2);
            ArrayList<Integer> cur = new ArrayList<Integer>();
            for(int i = 0; i < numRows; ++i){
                if(i == 0 || i == numRows - 1)
                    cur.add(1);
                else{
                    cur.add(pre.get(i - 1) + pre.get(i));
                }
            }
            results.add(cur);
            return results;
        }
    }
}