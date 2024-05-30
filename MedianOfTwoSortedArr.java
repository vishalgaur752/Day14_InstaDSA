public class MedianOfTwoSortedArr {
    public static double findMedian(int nums[], int nums2[]) {
        if (nums.length < nums2.length) {
            return findMedian(nums, nums2);
        }
        int m = nums.length;
        int n = nums2.length;
        int start = 0;
        int end = m;
        while (start <= end) {
            int partiton1 = (start + end) / 2;
            int parttion2 = (m + n + 1) / 2 - partiton1;
            int maxLeftNums1 = partiton1 == 0 ? Integer.MIN_VALUE : nums[partiton1 - 1];
            int maxLeftNums2 = parttion2 == 0 ? Integer.MIN_VALUE : nums2[parttion2 - 1];
            int minRightnums1 = partiton1 == m ? Integer.MAX_VALUE : nums[partiton1];
            int minRightnums2 = parttion2 == n ? Integer.MAX_VALUE : nums2[parttion2];
            if (maxLeftNums1 <= minRightnums2 && maxLeftNums2 <= minRightnums1) {
                if ((m + n) % 2 == 0) {
                    return (Math.max(maxLeftNums1, maxLeftNums2) + Math.min(minRightnums1, minRightnums2)) / 2.0;
                } else {
                    return Math.max(maxLeftNums1, maxLeftNums2);
                }
            } else if (maxLeftNums1 > minRightnums2) {
                end = partiton1 - 1;
            } else {
                start = partiton1 + 1;
            }
        }
        throw new IllegalArgumentException();
    }

    public static void main(String[] args) {
        int nums[] = { 1,2, 3 };
        int nums2[] = { 4, 5, 9 };
        System.out.println(findMedian(nums, nums2));
    }
}
