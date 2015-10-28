public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> parenthesis = new ArrayList<>();
        generateParenthesis(parenthesis, n, n, "");
        return parenthesis;
    }
    
    public void generateParenthesis(
        List<String> parenthesis, int left, int right, String current) {
        if (left == 0 && right == 0) {
            parenthesis.add(current);
        } else if (left >= right && right >= 0) {
            generateParenthesis(parenthesis, left - 1, right, "(" + current);
            generateParenthesis(parenthesis, left, right - 1, ")" + current);
        }
    }
}
