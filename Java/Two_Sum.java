import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int another = 0;
        HashMap<Integer, Integer> tempMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            another = target - nums[i];
            Integer anotherIndex = tempMap.get(another);//有可能为空 必须为Interger
            //不为空说明哈希表中有该KV对 若为空则说明哈希表中没有 put该键值对进入哈希表
            if (anotherIndex != null) {
                result[0] = anotherIndex;
                result[1] = i;
                return result;
            } else {
                tempMap.put(nums[i], i);
            }
        }
        return result;
    }
}