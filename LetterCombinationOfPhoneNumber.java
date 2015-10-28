public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits.length() == 0) {
            return combinations;
        }
        List<String> subCombinations = letterCombinations(digits.substring(1));
        if (subCombinations.size() == 0) {
            subCombinations.add("");
        }
        for (String combination: subCombinations) {
            for (char c: getLetters(digits.charAt(0)).toCharArray()) {
                combinations.add(String.valueOf(c) + combination);
            }
        }
        return combinations;
    }
    
    public String getLetters(char digit) {
        switch(digit) {
            case '2':
                return "abc";
            case '3':
                return "def";
            case '4':
                return "ghi";
            case '5':
                return "jkl";
            case '6':
                return "mno";
            case '7':
                return "pqrs";
            case '8':
                return "tuv";
            case '9':
                return "wxyz";
            default:
                return "";
        }
    }
}
