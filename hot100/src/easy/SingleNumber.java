package easy;

import java.util.HashSet;
import java.util.Iterator;

/**
 * @author wxs
 * @create 2020/9/18   15:49
 *
给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。

说明：

你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？

示例 1:

输入: [2,2,1]
输出: 1
 */
public class SingleNumber {
    /**
     * 遍历数组，判断集合是否包含当前数字，如果没有，就加入集合；如果有，就把集合中相同大小的数字去掉。遍历完数组后，集合中只剩下一个数字，就是数组中只出现一次的数字。
     * 时间复杂度：O(n)  空间复杂度O(n)
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        HashSet<Integer> integers = new HashSet<>();
        for(int num : nums){
            if (!integers.contains(num)){
                integers.add(num);
            }else {
                integers.remove(num);
            }
        }
        Iterator<Integer> iterator = integers.iterator();
        return iterator.next();
    }

    /**
     * 使用异或运算
     * 数组中数字总个数为2m+1，有m个出现两次的数字，1个出现一次的数字
     * 令a1,a2,...,am表示m个出现两次的数组，a(m+1)表示出现1次的数字
     * 异或运算满足交换律和结合律，全部数字作异或运算：
     * (a1⊕a1)⊕(a2⊕a2)⊕...⊕(am⊕am)⊕a(m+1) = 0⊕0⊕...⊕0⊕a(m+1) = a(m+1)
     * 结果就是出现1次的数字
     * @param nums
     * @return
     */
    public int singleNumber2(int[] nums) {
        int single = 0;
        for(int num:nums){
            single ^= num;
        }
        return single;

    }

}












