public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder res = new StringBuilder();
        boolean isPositive = numerator > 0 && denominator > 0 || numerator < 0 && denominator < 0;
        if (!isPositive)
            res.append('-');
        long n = Math.abs((long) numerator);
        long d = Math.abs((long) denominator);
        res.append(n / d);
        long remain = n % d;
        if (remain == 0) {
            return res.toString();
        }
        res.append('.');
        Map<Long, Integer> numToPosition = new HashMap<>();
        numToPosition.put(remain, res.length());
        while (remain > 0) {
            remain *= 10;
            res.append(remain / d);
            remain %= d;
            if (numToPosition.containsKey(remain)) {
                res.insert(numToPosition.get(remain), "(");
                res.append(")");
                break;
            } else {
                numToPosition.put(remain, res.length());
            }
        }
        return res.toString();
    }
}
