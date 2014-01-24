public class Solution {
    public int jump(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        //First solution, use O(n) space
        int[] min = new int[A.length];
        int marker = A.length - 1;
        for (int i = A.length - 2; i >= 0; --i) {
            if (marker - i <= A[i]) {        
                int maxJump = Math.min(A.length, A[i] + i + 1);
                int thisMin = A.length;
                for (int j = i + 1; j < maxJump; ++j) {
                    if (min[j] < thisMin) {
                        thisMin = min[j];
                    }
                    min[i] = thisMin + 1;
                    marker = i;
                }
            }
            else {
                min[i] = A.length;
            }
        }
        return min[0];
    }
}

public class Solution {
    public int jump(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int jump = 0;
        int step = 0;
        while (jump < A.length - 1) {
            int max = 0;
            int dist = jump + A[jump];
            for (int i = jump + 1; i <= dist; ++i) {
                if (i >= A.length - 1) {
                    jump = i;
                    break;
                }
                if (max < i + A[i]) {
                    max = i + A[i];
                    jump = i;
                }
            }
            ++step;
        }
        return step;
    }
}