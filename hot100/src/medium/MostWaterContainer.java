package medium;

/**
 * @author wxs
 * @create 2020/8/8   19:38
 *
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * 示例：
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 解题思路：
 * 双指针法
 * 刚开始左指针pl指向第一个，右指针pr指向最后一个。
 * 接下来考虑指针要往哪个方向移动。
 * 左右指针指向的数较小的，移动指针。
 *
 * 容积计算公式：min(nums[pl],nums[pr])*(pr-pl)
 *
 */
public class MostWaterContainer {
    public int max = 0;
    public int maxArea(int[] height) {
        curArea(height,0,height.length-1);
        return max;


    }

    /**
     *
     * @param height
     * @param pl    左指针
     * @param pr    右指针
     * @return
     */
    public void curArea(int[] height,int pl,int pr){
        if(pl>=pr){
            return;
        }
        max = Math.max(max,Math.min(height[pl],height[pr])*(pr-pl));
        if(height[pl]<height[pr]){
            curArea(height,pl+1,pr);
        }else{
            curArea(height,pl,pr-1);
        }


    }

}
