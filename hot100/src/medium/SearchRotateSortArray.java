package medium;

/**
 * @author wxs
 * @create 2020/8/7   20:16
 *
 * 搜索旋转排序数组
 *
 *假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 * 你可以假设数组中不存在重复的元素。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 示例 1:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 *
 *
 */
public class SearchRotateSortArray {
    //题目要求时间复杂度为O(log n级别)，想到用二分法
    //将数组分成左右两部分，判断一下查找的数是否有序的那部分里面，如果是，找到；
    // 如果不是，则在另一部分继续用这个办法
    public int search(int[] nums, int target) {
        return search2(nums,0,nums.length-1,target);



    }


    public int search2(int[] nums,int start,int end,int target){
        if(start>end){
            return -1;
        }
        int half = (start+end)/2;
        if(nums[start]<=nums[half]){    //左边有序
            if(target>=nums[start] && target<=nums[half]){  //目标值在左边
                return halfSearch(nums,start,half,target);
            }else{
                return search2(nums,half+1,end,target);
            }
        }else{  //右边有序
            if(target>=nums[half+1] && target<=nums[end]){  //目标值在右边
                return halfSearch(nums,half+1,end,target);
            }else{
                return search2(nums,start,half,target);
            }

        }



    }

    //二分查找
    public static int halfSearch(int[] nums,int start,int end,int target){
        if(start<=end){
            int half = (start+end)/2;
            if(target>nums[half]){
                return halfSearch(nums,half+1,end,target);
            }else if(target<nums[half]){
                return halfSearch(nums,start,half-1,target);
            }else{
                return half;
            }
        }
        return -1;
    }

    //二分查找非递归
    public static int halfSearch2(int[] nums,int start,int end,int target){
        int half;
        while(start<=end){
            half = (start+end)/2;
            if(target>nums[half]){
                start = half+1;
            }else if(target<nums[half]){
                end=half-1;
            }else{
                return half;
            }
        }
        return -1;
    }

}











