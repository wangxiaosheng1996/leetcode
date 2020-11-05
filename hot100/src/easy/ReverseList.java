package easy;


/**
 * @author wxs
 * @create 2020/9/17   8:57
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
public class ReverseList {
    /**
     * 迭代法，遍历结点，将当前结点的next指针指向上一个结点
     * 时间复杂度O(n) 空间复杂度O(1)
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){//如果头结点为空或者链表只有一个结点，直接返回head
            return head;
        }
        ListNode cur = head;
        ListNode pre = null;
        ListNode tem = null;
        while (cur != null){
            tem = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tem;
        }
        return pre;
    }

    /**
     * 递归法 时间复杂度O(n) 空间复杂度O(n)
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        if(head == null){
            return head;
        }
        reverse(null,head);
        return temp;

    }
    private ListNode temp = null;
    public void reverse(ListNode pre,ListNode cur){
        if(cur == null){
            temp = pre;
            return;
        }
        temp = cur.next;
        cur.next = pre;
        reverse(cur,temp);
    }


}















