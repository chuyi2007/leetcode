public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int m = A.length, n = B.length;
        double medianLocation = (double)(m + n)/2;
        double median = 0;
        
        int[] AB = new int[m+n];
        
        
        return median;
        
    }
    
    public int naiveSearch(int[] A, int[] B){
        int m = A.length, n = B.length;
        double medianLocation = (double)(m + n)/2;
        double median = 0;
        
        int[] AB = new int[m+n];
        for(int i = 0, j = 0; i + j < m + n;){
            if(i == m){
                AB[i + j] = B[j];
                j++;
            }
            else if(j == n){
                AB[i + j] = A[i];
                i++;
            }
            else{
                if(A[i] < B[j]){
                    AB[i + j] = A[i];
                    i++;
                }
                else{
                    AB[i + j] = B[j];
                    j++;
                }
            }
        }
        
        if(medianLocation%1 == 0){
            int index = (int)medianLocation;
            median = (double)(AB[index] + AB[index - 1])/2;
        }
        else{
            int index = (int)Math.floor(medianLocation);
            median = AB[index];
        }
        
        return median;
    }
}