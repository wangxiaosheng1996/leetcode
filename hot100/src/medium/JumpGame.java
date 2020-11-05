package medium;

/**
 * @author wxs
 * @create 2020/8/5   15:37
 */
/*
给定一个非负整数数组，你最初位于数组的第一个位置。

数组中的每个元素代表你在该位置可以跳跃的最大长度。

判断你是否能够到达最后一个位置。

示例 1:
输入: [2,3,1,1,4]
输出: true
解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。

示例 2:
输入: [3,2,1,0,4]
输出: false
解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。


*/
public class JumpGame {
    /**
     * 思路：维护一个叫做 最远可以到达的位置rightmost 的变量
     *遍历数组，如果当前位置在 最远可以到达的位置 内，再判断i+num[x]和rightmost的大小，大的赋值给rightmost
     * 如果当前位置不在 最远可以到达的位置 内，即当前位置不可达，循环结束，返回false
     *
     *
     * @param nums    给定的数组
     * @return
     */
    public boolean canJump1(int[] nums){
        //数组的长度
        int n = nums.length;
        //最远可以到达的位置
        int rightmost=0;
        //遍历数组
        for(int i=0;i<n;i++){
            //如果当前位置在 最远可以到达的位置 内
            if(i<=rightmost){
                //判断i+num[x]和rightmost的大小，大的赋值给rightmost
                rightmost=Math.max(i+nums[i],rightmost);
                if(rightmost>=n-1){
                    return true;
                }
            }else{
                return false;
            }

        }
        return false;

    }


    public boolean canJump2(int[] nums){
        //数组的长度
        int n = nums.length;
        //最远可以到达的位置
        int rightmost=0;
        //遍历数组
        for(int i=0;i<n;i++){
            if(i>rightmost){
                return false;
            }else{
                //判断i+num[x]和rightmost的大小，大的赋值给rightmost
                rightmost=Math.max(i+nums[i],rightmost);
            }
        }
        return true;

    }


}






















