//O(N^2)
public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i = 0; i <= rowIndex; ++i){
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            for(int j = 0; j <= i; ++j){
                if(j == 0 || j == i)
                    tmp.add(1);
                else
                    tmp.add(result.get(j - 1) + result.get(j));
            }
            result = tmp;
        }
        return result;
    }
}