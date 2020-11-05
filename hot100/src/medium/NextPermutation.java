package medium;

/**
 * @author wxs
 * @create 2020/8/7   12:53
 *
 *实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须原地修改，只允许使用额外常数空间。
 *
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 */
public class NextPermutation {
    /*
    思路:从数字序列的后面开始遍历，如果是从从小到大升序，就一直遍历下去，
    直到出现降序，将出现降序的位置的数字与后面的值中比降序数字大的数字中的最小值交换，再将后面的数字升序排列。
    如果没有出现降序的数字，那么对原数字序列进行头尾交换。
     */
    public void nextPermutation(int[] nums) {
        if(nums==null || nums.length==0 || nums.length==1){
            return;
        }

        int n = nums.length;
        int pos = 0;    //保存出现降序的数字
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                pos = i;
                break;
            }
            if(i==0){
                for(int p=0;p<n/2;p++){
                    int temp = nums[p];
                    nums[p] = nums[n-1-p];
                    nums[n-1-p] = temp;
                }
                return;

            }
        }

        for(int j=n-1;j>pos;j--){
            if(nums[j]>nums[pos]){
                int temp = nums[j];
                nums[j] = nums[pos];
                nums[pos] = temp;
                break;
            }

        }
        int m = (n-pos-1)/2;
        for(int i=pos+1;i<pos+1+m;i++){
            int temp = nums[i];
            nums[i] = nums[n+pos-i];
            nums[n+pos-i] = temp;
        }


    }
}
