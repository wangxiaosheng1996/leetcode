package medium;

import java.util.Arrays;

/**
 * @author wxs
 * @create 2020/8/5   16:18
 */

/*
给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。

此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。

注意:
不能使用代码库中的排序函数来解决这道题。

示例:

输入: [2,0,2,1,1,0]
输出: [0,0,1,1,2,2]

 */


public class ColorClassify {
    /*
    一个直观的解决方案是使用计数排序的两趟扫描算法。
    首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
     */
    public void sortColors(int[] nums) {
        //定义一个三维数组存储每个颜色出现的次数，存储顺序：红色、白色、蓝色  0，1，2
        int[]  numOfColors=new int[3];
        //第一次遍历，计算出0、1 和 2 元素的个数
        int n = nums.length;
        for(int i=0;i<n;i++){
            numOfColors[nums[i]]++;
        }
        System.out.println(Arrays.toString(numOfColors));
        //第一次遍历，重写数组
        //nums数组的索引
        int k = 0;
        for(int i=0;i<numOfColors.length;i++){
            for(int j=0;j<numOfColors[i];j++){
                nums[k++]=i;
            }
        }
        System.out.println(Arrays.toString(nums));

    }

    /*
    一次遍历方法
    我们用三个指针（p0, p2 和cur）来分别追踪0的最右边界，2的最左边界和当前考虑的元素。
     */
    public void sortColors2(int[] nums) {
        int n = nums.length;   //数组长度
        int p0 = 0;
        int p2 = n-1;
        for(int cur=0;cur<n;cur++){
            if(cur>p2){
                return;
            }
            if(nums[cur]==0){
                int temp = nums[p0];
                nums[p0] = nums[cur];
                nums[cur] = temp;
                p0++;
            }else if(nums[cur]==2){
                int temp = nums[p2];
                nums[p2] = nums[cur];
                nums[cur] = temp;
                p2--;
                cur--;
            }


        }



    }





}















