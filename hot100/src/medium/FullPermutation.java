package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author wxs
 * @create 2020/8/6   16:22
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 */
public class FullPermutation {
    //使用回溯算法
    //可以使用标记数组，但是标记数组会增加空间复杂度
    //将数组分成左右两部分，左边是已经填过的数，右边是未填过的数
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> output = new ArrayList<>();
        //复制数组到列表中，之后对这个列表进行操作
/*        for(int num:nums){
            output.add(num);
        }*/
        int cur = 0;    //要填入数字的位置

        int n = nums.length;
        int[] flags = new int[n];   //标记数组,0表示没有访问过，1表示访问过

        //backtrack(0,output,result);
        backtrack2(nums,output,result,flags);
        return result;


    }

    //回溯函数

    /**
     *
     * @param cur       当前要填入数的位置
     * @param output    当前操作的列表
     * @param result    存放结果到列表
     */
    public void backtrack(int cur,ArrayList<Integer> output,List<List<Integer>> result){
        int n = output.size();
        if(cur==n){
            result.add(new ArrayList<Integer>(output));
            return;
        }

        for(int i=cur;i<n;i++){
            //交换两个数字
            Collections.swap(output,cur,i);
            //往下一个位置回溯
            backtrack(cur+1,output,result);
            //撤销操作
            Collections.swap(output,cur,i);
        }

    }

    //使用标记数组来回溯

    /**
     *
     * @param nums      原始数组
     * @param output    动态变化的全排列
     * @param result    保留所有结果
     * @param flags     标记数组
     */
    public void backtrack2(int[] nums,ArrayList<Integer> output,List<List<Integer>> result,int[] flags){

        int n = nums.length; //原始数组的长度（数字的总个数）
        int size = output.size();//当前已经获得数字
        if(size==n){
            result.add(new ArrayList<Integer>(output));
            return;
        }
        for(int i=0;i<n;i++){
            if(flags[i]==0){    //0表示没有被访问过
                output.add(nums[i]);
                flags[i]=1;
                backtrack2(nums,output,result,flags);
                output.remove(size);
                flags[i]=0;
            }

        }


    }


}
