public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        if (numRows == 0) {
            return triangle;
        }
        List<Integer> preLevel = new ArrayList<>();
        preLevel.add(1);
        triangle.add(preLevel);
        for (int i = 1; i < numRows; ++i) {
            List<Integer> curLevel = new ArrayList<>();
            curLevel.add(1);
            for (int j = 1; j < preLevel.size(); ++j) {
                curLevel.add(preLevel.get(j - 1) + preLevel.get(j));
            }
            curLevel.add(1);
            triangle.add(curLevel);
            preLevel = curLevel;
        }
        return triangle;
    }
}
