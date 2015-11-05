public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        addOperators(num, target, "", 0, 0, 0, res);
        return res;
    }
    
    public void addOperators(
        String num,
        int target,
        String eval,
        long sum,
        int index,
        long multi,
        List<String> res
    ) {
        if (index == num.length()) {
            if (target == sum) {
                res.add(eval);
            }
        } else {
            for (int i = index; i < num.length(); ++i) {
                String sub = num.substring(index, i + 1);
                // for case like 105, avoid 05, but keep 0
                if (sub.length() > 1 && sub.charAt(0) == '0') {
                    break;
                }
                long curNumber = Long.parseLong(sub);
                if (index == 0) {
                    addOperators(num, target, sub, sum + curNumber, i + 1, curNumber, res);
                } else {
                    addOperators(num, target, eval + "+" + sub, sum + curNumber, i + 1, curNumber, res);
                    addOperators(num, target, eval + "-" + sub, sum - curNumber, i + 1, -curNumber, res);
                    addOperators(num, target, eval + "*" + sub, sum - multi + curNumber * multi, i + 1, curNumber * multi, res); 
                }
            }
        }
    }
}
