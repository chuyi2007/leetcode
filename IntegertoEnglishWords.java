public class Solution {
    private final String[] lessThan20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] thousands = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        int level = 0;
        String res = "";
        while (num > 0) {
            int remain = num % 1000;
            if (remain > 0) {
                res = constructSubThousand(remain).trim() + " " + thousands[level] + " " + res;
            }
            ++level;
            num /= 1000;
        }
        return res.trim();
    }

    public String constructSubThousand(int num) {
        String res = "";
        if (num >= 100) {
            res += lessThan20[num / 100] + " Hundred ";
        }
        num %= 100;
        if (num < 20) {
            res += lessThan20[num];
        } else {
            res += tens[num / 10] + " " + lessThan20[num % 10];
        }
        return res;
    }
}
