import java.util.HashMap;
import java.util.Map;

//递归超时 换动态规划解
class Solution {
    //注意map的定义别填到递归里面了 会导致时间爆炸（惨痛的教训）
    private Map<Integer, Integer> tempMap = new HashMap<>();
    public int climbStairs(int n) {
        //递归退出条件
        if (n == 1) return 1;
        if (n == 2) return 2;
        int result;

        //如果存在该键值对 则直接返回之前已经计算过的结果 如果不存在 则进行递归结果计算 并且加入hashmap中再返回结果
        if (tempMap.get(n) != null) {
            return tempMap.get(n);
        } else {
            result = climbStairs(n - 1) + climbStairs(n - 2);
            tempMap.put(n, result);
            return result;
        }
    }
}