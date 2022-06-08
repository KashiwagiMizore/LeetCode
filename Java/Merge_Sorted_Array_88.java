//class Solution {
//    public void merge(int[] nums1, int m, int[] nums2, int n) {
//        int index1 = 0, index2 = 0;
//        int indexTemp = 0;
//        int[] temp = new int[m + n];
//        while (index1 < m || index2 < n) {
//            //nums1已经取完 而nums2还未取完的时候
//            if (index1 >= m) {
//                temp[indexTemp++] = nums2[index2++];
//            }
//            //nums2已经取完 而nums1还未取完
//            else if (index2 >= n) {
//                temp[indexTemp++] = nums1[index1++];
//            } else {
//                if (nums1[index1] <= nums2[index2]) {
//                    temp[indexTemp++] = nums1[index1++];
//                } else {
//                    temp[indexTemp++] = nums2[index2++];
//                }
//            }
//        }
//        for (int i = 0; i < nums1.length; i++) {
//            nums1[i] = temp[i];
//        }
//
//    }
//}

//不用temp的解法
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1, index2 = n - 1;
        for (int i = m + n - 1; i >= 0; i--) {
            //nums1的数据已经取完时
            if (index1 < 0) {
                nums1[i] = nums2[index2--];
            }
            //nums2的数据取完时
            else if (index2 < 0) {
                nums1[i] = nums1[index1--];
            } else {
                if (nums1[index1] >= nums2[index2]) {
                    nums1[i] = nums1[index1--];
                } else {
                    nums1[i] = nums2[index2--];
                }
            }
        }
    }
}

class test {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1};
        int[] nums2 = new int[]{0};
        Solution solution = new Solution();
        solution.merge(nums1, 1, nums2, 0);
    }
}
