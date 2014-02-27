public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> results = new ArrayList<String>();
        generateParenthesis(n, n, "", results);
        return results;
    }
    
    public void generateParenthesis(int leftCount, int rightCount, 
                                    String s, ArrayList<String> results) {
        if (rightCount == 0 && leftCount == 0) {
            results.add(s);
        }
        else {
            if (rightCount > 0 && rightCount > leftCount) {
                generateParenthesis(leftCount, rightCount-1, s + ")", results);
            }
            if (leftCount > 0) {
                generateParenthesis(leftCount - 1, rightCount, s + "(", results);
            }
        }
    } 
}

public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        return generateParenthesis(n, n, "");
    }
    
    public ArrayList<String> generateParenthesis(int left, int right, String s) {
        ArrayList<String> result = new ArrayList<String>();
        if (left == 0 && right == 0)
            result.add(s);
        if (left < right) {
            result.addAll(generateParenthesis(left, right - 1, s + ")"));
        }
        if (left > 0) {
            result.addAll(generateParenthesis(left - 1, right, s + "("));
        }
        return result;
    }
}