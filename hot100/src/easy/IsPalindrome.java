package easy;

import java.util.ArrayList;

/**
 * @author wxs
 * @create 2020/9/20   15:50
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 */
public class IsPalindrome {
    /**
     * 第一次遍历:将链表放入数组
     * 第二次遍历：一个指针从数组头，另一个指针从数组尾，检查值是否相等
     * 时间复杂度:O(n)    空间复杂度:O(n)
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        //将链表的结点放入数组
        ListNode cur = head;
        ArrayList<Integer> list = new ArrayList<>();
        while (cur != null){
            list.add(cur.val);
            cur = cur.next;
        }
        //同时从头和尾遍历数组
        int i = 0;
        int j = list.size()-1;
        boolean flag = true;
        while(i<j){
            if(!list.get(i).equals(list.get(j))){
                flag = false;
                break;
            }
            i++;
            j--;
        }
        return flag;
    }

    /**
     * 1、反转后半部分链表
     * 2、判断是否回文
     * 3、恢复链表
     * @param head
     * @return
     */
    public boolean isPalindrome2(ListNode head){
        //1、反转后半部分链表
        return true;
    }
}






















