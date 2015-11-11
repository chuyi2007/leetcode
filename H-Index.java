//O(N)
public class Solution {
    public int hIndex(int[] citations) {
        int[] count = new int[citations.length + 1];
        for (int i = 0; i < citations.length; ++i) {
            count[Math.min(citations[i], citations.length)]++;
        }
        int maxIndex = 0;
        for (int i = count.length - 1; i >= 0; --i) {
            maxIndex += count[i];
            if (maxIndex >= i) {
                return i;
            }
        }
        return maxIndex;
    }
}

//O(NlogN)
public class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        for (int i = citations.length - 1; i >= 0; --i) {
            if (citations[i] < (citations.length - i)) {
                return citations.length - i - 1;
            }
        }
        return citations.length;
    }
}
