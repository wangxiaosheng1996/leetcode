package easy;

/**
 * @author wxs
 * @create 2020/9/18   10:52
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 *  
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MergeTwoLists {
    /**
     * 迭代，两个指针A、B指向两个链表，比较当前结点值大小，让前一个结点pre指向值较小的结点，然后较小结点往后移动一位，pre也往后移动一位，较大结点不动。
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node1 = l1;
        ListNode node2 = l2;
        ListNode head = new ListNode(0);
        ListNode pre = head;
        outer:while (true){
            if(node1 == null && node2== null){
                return null;
            }else if(node1 == null && node2 != null){
                while(node2 != null){
                    pre.next = node2;
                    pre = node2;
                    node2 = node2.next;
                }
                break outer;
            }else if(node1 != null && node2 == null){
                while (node1 != null){
                    pre.next = node1;
                    pre = node1;
                    node1 = node1.next;
                }
                break outer;
            }else {
                if(node1.val<node2.val){
                    pre.next = node1;
                    pre = node1;
                    node1 = node1.next;
                }else {
                    pre.next = node2;
                    pre = node2;
                    node2 = node2.next;
                }
            }

        }
        return head.next;
    }

    /**
     * 递归，当前函数返回当前较小的结点，并让这个结点指向下一个较小的
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2){
        if(l1 == null){
            return l2;
        }else if (l2 == null){
            return l1;
        }else if (l1.val<l2.val){
            l1.next = mergeTwoLists2(l1.next,l2);
            return l1;
        }else {
            l2.next = mergeTwoLists2(l1,l2.next);
            return l2;
        }

    }

}
