public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        Set<String> duplicates = new HashSet<>();
        int[] counts = new int[2 << 20];
        for (int i = 0; i < s.length() - 10; ++i) {
            String seq = s.substring(i, i + 10);
            int code = mapping(seq);
            ++counts[code];
            if (counts[code] > 1 && !duplicates.contains(seq)) {
                res.add(seq);
                duplicates.add(seq);
            }
        }
        return res;
    }
    
    public int mapping(String s) {
        int key = 0;
        for (int i = 0; i < s.length(); ++i) {
            key <<= 2;
            key |= getCode(s.charAt(i));
        }
        return key;
    }
    
    public int getCode(char c) {
        switch(c) {
            case 'A':
                return 0;
            case 'C':
                return 1;
            case 'G':
                return 2;
            case 'T':
                return 3;
            default:
                return -1;
        }
    }
}
