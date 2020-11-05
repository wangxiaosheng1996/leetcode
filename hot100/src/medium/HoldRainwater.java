package medium;

/**
 * @author wxs
 * @create 2020/8/8   21:29
 *
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 *
 * 思路:
 * 一个能装水的水坑的特点：从左边开始先下降，到最低点后上升，上升到下降为止，组成了一个水坑。
 * 比较水坑的左右边缘，比较低的那个就是水坑里水的高度。
 *
 */
public class HoldRainwater {
    public int trap(int[] height) {
        int left = 0;   //水坑的左边
        int right = 0;  //水坑的右边
        int total = 0;  //  总水量
        int flag = 0;   //0:下降   1:上升
        for(int i=0;i<height.length;i++){
            if(flag == 0){
                //水坑的边缘不能为0
                if(i==0){
                    continue;
                }
                if(height[i]<height[i-1]){
                    left=i-1;
                    flag=1;
                }
            }else if(flag==1){
                if(height[i]>height[i-1]){
                    flag=2;
                }
            }else if(flag==2){
                if(height[i]<=height[i-1]){
                    right = i-1;
                    int length = Math.min(height[left],height[right]);
                     for(int j=left+1;j<right;j++){
                         total += length-height[j];

                     }
                }
            }

        }
        return total;


    }
}
