public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < input.length(); ++i) {
            char c = input.charAt(i);
            if (c == '*' || c == '+' || c == '-') {
                String left = input.substring(0, i);
                String right = input.substring(i + 1, input.length());
                List<Integer> leftResults = diffWaysToCompute(left);
                List<Integer> rightResults = diffWaysToCompute(right);
                for (int leftResult : leftResults) {
                    for (int rightResult : rightResults) {
                        switch(c) {
                            case '+':
                                results.add(leftResult + rightResult);
                                break;
                            case '-':
                                results.add(leftResult - rightResult);
                                break;
                            case '*':
                                results.add(leftResult * rightResult);
                                break;
                        }
                    }
                }
            }
        }
        if (results.size() == 0) {
            results.add(Integer.parseInt(input));
        }
        return results;
    }
}
