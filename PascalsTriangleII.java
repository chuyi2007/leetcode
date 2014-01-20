//O(N^2)
public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(1);
        
        for (int i = 1; i <= rowIndex; ++i) {
            ArrayList<Integer> current = new ArrayList<Integer>();
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || j == i) {
                    current.add(1);
                }
                else {
                    current.add(result.get(j)
                        + result.get(j - 1));
                }
            }
            result = current;
        }
        
        return result;
    }
}