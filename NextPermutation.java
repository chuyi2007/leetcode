public class Solution {
    public void nextPermutation(int[] num) {
        int index = -1;
        for (int i = num.length - 1; i > 0; --i) {
            if (num[i] > num[i - 1]) {
                index = i - 1;
                break;
            }
        }
        
        if (index != -1) {
            for (int i = num.length - 1; i > index; --i) {
                if (num[i] > num[index]) {
                    swap(num, i, index);
                    break;
                }
            }
        }
        
        for (int i = num.length - 1, j = index + 1; i > j;) {
            swap(num, i--, j++);
        }
    }
    
    public void swap(int[] num, int i, int j) {
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }
}