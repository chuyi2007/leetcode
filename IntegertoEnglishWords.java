public class Solution {
    String[] belowTwenty = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] thousands = {"", "Thousand", "Million", "Billion"};
    
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        String res = "";
        int level = 0;
        while (num > 0) {
            int remain = num % 1000;
            String str = convertToStr(remain);
            if (str.length() > 0) {
                str += " " + thousands[level] + " ";
            }
            // A lot of trim around the corner cases
            res = str.trim() + " " + res.trim();
            level++;
            num /= 1000;
        }
        return res.trim();
    }
    
    public String convertToStr(int remain) {
        String str = "";
        if (remain >= 100) {
            str += belowTwenty[remain / 100] + " Hundred ";
        }
        remain %= 100;
        if (remain < 20) {
            str += belowTwenty[remain];
        } else {
            str += tens[remain / 10] + " " + belowTwenty[remain % 10];
        }
        return str.trim();
    }
}
