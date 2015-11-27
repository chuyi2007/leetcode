public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        if (n1 < n2) {
            return findMedianSortedArrays(nums2, nums1);
        }
        if (n2 == 0) {
            return (nums1[n1 / 2] + nums1[(n1 - 1) / 2]) / 2.0;
        }
        // from 1 to n2 * 2 + 1
        int left = 0, right = n2 * 2;
        while (left <= right) {
            int mid2 = (left + right) / 2;
            int mid1 = n1 + n2 - mid2;
            int l1 = mid1 == 0 ? Integer.MIN_VALUE : nums1[(mid1 - 1) / 2];
            int l2 = mid2 == 0 ? Integer.MIN_VALUE : nums2[(mid2 - 1) / 2];
            int r1 = mid1 == n1 * 2 ? Integer.MAX_VALUE : nums1[mid1 / 2];
            int r2 = mid2 == n2 * 2 ? Integer.MAX_VALUE : nums2[mid2 / 2];
            if (l1 > r2) {
                left = mid2 + 1;
            } else if (l2 > r1) {
                right = mid2 - 1;
            } else {
                return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
            }
        }
        return -1;
    }
}
