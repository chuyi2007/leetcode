//easy iterative solution
public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> triangle = 
            new ArrayList<ArrayList<Integer>>();
        if (numRows == 0) {
            return triangle;
        }
        ArrayList<Integer> oneRow = new ArrayList<Integer>();
        oneRow.add(1);
        triangle.add(oneRow);
        
        for (int i = 1; i < numRows; ++i) {
            oneRow = new ArrayList<Integer>();
            oneRow.add(1);
            for (int j = 1; j < i; ++j) {
                oneRow.add(triangle.get(i - 1).get(j - 1)
                    + triangle.get(i - 1).get(j));
            }
            oneRow.add(1);
            triangle.add(oneRow);
        }
        
        return triangle;
    }
}

//recursion solution
public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if (numRows == 0) { 
            return results;
        }
        else if (numRows == 1) {
            ArrayList<Integer> result = new ArrayList<Integer>();
            result.add(1);
            results.add(result);
            return results;
        }
        else {
            results = generate(numRows - 1);
            ArrayList<Integer> pre = results.get(numRows - 2);
            ArrayList<Integer> cur = new ArrayList<Integer>();
            for (int i = 0; i < numRows; ++i) {
                if(i == 0 || i == numRows - 1) {
                    cur.add(1);
                }
                else {
                    cur.add(pre.get(i - 1) + pre.get(i));
                }
            }
            results.add(cur);
            return results;
        }
    }
}