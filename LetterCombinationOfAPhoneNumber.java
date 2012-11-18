import java.util.HashMap;
public class Solution {
    public ArrayList<String> letterCombinations(String digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");
        
        ArrayList<String> results = new ArrayList<String>();
        naiveRecursion(results, map, digits, "");
        return results;
    }
    
    public void naiveRecursion(ArrayList<String> results, HashMap<Integer, String> map, String digits, String result){
        if(digits.length() == 0){
            results.add(result);
        }
        else{
            int d = Integer.parseInt(digits.substring(0,1));
            String letters = map.get(d);
            for(int i = 0; i < letters.length(); i++)
                naiveRecursion(results, map, digits.substring(1),result + letters.substring(i,i+1));
        }
    }
}