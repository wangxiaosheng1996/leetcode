package easy;

/**
 * @author wxs
 * @create 2020/9/18   16:18
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class moveZeros {
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int cur = 0;
        for(int i=0;i<len;i++){
            if(nums[i] != 0){
                nums[cur] = nums[i];
                cur++;
            }
        }

        for (int i = len-1;i>=cur;i--){
            nums[i] = 0;
        }

    }
}














