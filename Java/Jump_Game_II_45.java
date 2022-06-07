//从后往前查找 效率较慢
//class Solution {
//    public int jump(int[] nums) {
//        int position = nums.length - 1;//从最后一个开始反向查找
//        int steps = 0;
//        while (position > 0) {
//            //找到能走到当前位置的最远的i值（所以需要从前往后遍历）
//            for (int i = 0; i < position; i++) {
//                if (i + nums[i] >= position) {
//                    position = i;//更新位置
//                    steps++;
//                    break;
//                }
//            }
//        }
//        return steps;
//    }
//}

//从前往后查找 效率较快
class Solution {
    public int jump(int[] nums) {
        int now = 0;//当前位置
        int length = nums.length;//数组长度
        int end = 0;//上次跳跃可达范围的最远边界 即为下次最右（最远）的起点
        int maxPosition = 0;//能到的最远位置
        int steps = 0;
        //不用遍历到最后一步 因为假设总可以走到最后一个位置
        while (end < length - 1) {
            maxPosition = Math.max(maxPosition, now + nums[now]);
            if (now == end) {
                end = maxPosition;
                steps++;
            }
            now++;
        }
        return steps;
    }
}

class test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int nums[] = new int[]{2, 3, 1, 1, 4};
        int step = solution.jump(nums);
        System.out.println("step" + step);
    }
}