public class Solution {
    public ArrayList<TreeNode> generateTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<TreeNode> result = new ArrayList<TreeNode>();
        generateTrees(result, 1, n);
        return result;
    }
    
    public void generateTrees(ArrayList<TreeNode> result, int start, int end){
        if(start > end)
            result.add(null);
        else{
            for(int i = start; i <= end; ++i){
                ArrayList<TreeNode> left = new ArrayList<TreeNode>();
                generateTrees(left, start, i - 1);
                ArrayList<TreeNode> right = new ArrayList<TreeNode>();
                generateTrees(right, i + 1, end);
                for(int j = 0; j < left.size(); ++j){
                    for(int k = 0; k < right.size(); ++k){
                        TreeNode mid = new TreeNode(i);
                        mid.left = left.get(j);
                        mid.right = right.get(k);
                        result.add(mid);
                    }
                }
            }
        }
    }
}