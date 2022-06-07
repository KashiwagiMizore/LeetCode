class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = 0, index2 = 0;
        int indexTemp = 0;
        int[] temp = new int[m + n];
        while (index1 < m || index2 < n) {
            //nums1已经取完 而nums2还未取完的时候
            if (index1 >= m) {
                temp[indexTemp++] = nums2[index2++];
            }
            //nums2已经取完 而nums1还未取完
            else if (index2 >= n) {
                temp[indexTemp++] = nums1[index1++];
            } else {
                if (nums1[index1] <= nums2[index2]) {
                    temp[indexTemp++] = nums1[index1++];
                } else {
                    temp[indexTemp++] = nums2[index2++];
                }
            }
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = temp[i];
        }
    }
}

class test {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        Solution solution = new Solution();
        solution.merge(nums1, 3, nums2, nums2.length);
    }
}
