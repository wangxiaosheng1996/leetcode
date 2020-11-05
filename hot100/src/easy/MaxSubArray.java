package easy;

/**
 * @author wxs
 * @create 2020/9/15   9:13
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxSubArray {
    /**
     * 动态规划
     * 设f(i)表示以下标为i的的数组元素ai为结尾的最大子序和，则有动态规划转移方程f(i) = max{f(i-1)+ai,ai}
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int pre = 0,max = nums[0];
        for(int x:nums){
            pre = Math.max(pre+x,x);
            max = Math.max(max,pre);
        }
        return max;

    }
}























