public class Solution {
    public ArrayList<String> letterCombinations(String digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "");
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        map.put(0, "");
        //return naiveRecursion(digits, 0, map);
        ArrayList<String> results = new ArrayList<String>();
        naiveBackTracking(digits, "", map, results);
        return results;
    }
    //back tracking, clean code
    public void naiveBackTracking(String digits, String result, HashMap<Integer, String> map,
    ArrayList<String> results){
        if(digits.length() == 0)    results.add(result);
        else{
            String s = map.get(digits.charAt(0) - 48);
            for(int i = 0; i < s.length(); ++i)
                naiveBackTracking(digits.substring(1), result + s.substring(i, i+1), map, results);
        }
    }
    
    //recursion, more complicated
    public ArrayList<String> naiveRecursion(String digits, int index, HashMap<Integer, String> map){
        ArrayList<String> result = new ArrayList<String>();
        String s;
        if(index == digits.length() - 1){
            s = map.get(digits.charAt(index) - 48);
            for(int i = 0; i < s.length(); i++){
                result.add(s.substring(i, i+1));
            }
            return result;
        }
        else if(index < digits.length() - 1){
            result = naiveRecursion(digits, index + 1, map);
            s = map.get(digits.charAt(index) - 48);
            int size = result.size();
            for(int j = 0; j < size; ++j){
                String x = result.get(j);
                for(int i = 0; i < s.length(); ++i){
                    x += s.substring(i, i+1);
                    result.add(x);
                }
            }
            result.subList(0, size).clear();
        }
        return result;
    }
}