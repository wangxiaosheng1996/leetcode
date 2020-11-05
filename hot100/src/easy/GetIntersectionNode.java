package easy;

/**
 * @author wxs
 * @create 2020/9/18   9:09
 * 编写一个程序，找到两个单链表相交的起始节点。
 *
 */
public class GetIntersectionNode {
    /**
     *
     * 第一轮遍历：用两个指针，一个指向链表1，另一个指向链表2，记录谁先到链表尾的步数，这个步数就是两个链表之间长度的差值
     * 第二轮遍历：用两个指针，短链表的指针指向链表头，长链表的指针指向链表头的前n位(n表示两个链表长度的差值)，两指针同时往前遍历，直到指向同一个结点，该结点就是相交结点
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode node1 = headA;
        ListNode node2 = headB;
        int i = 0;//链表长度差
        int j = 0;
        while(true){
            if(node1 == null && node2 == null){
                break;
            }else if(node1 == null && node2 != null){
                j++;
                node2 = node2.next;
            }else if (node1 != null && node2 == null){
                i++;
                node1 = node1.next;
            }else {
                node1 = node1.next;
                node2 = node2.next;
            }

        }
        node1 = headA;
        node2 = headB;
        for (int m = 0;m<i;m++){
            node1 = node1.next;
        }
        for (int n = 0;n<j;n++){
            node2 = node2.next;
        }
        while (node1 != node2){
            node1 = node1.next;
            node2 = node2.next;
        }
        return node1;
    }

    /**
     *设链表A和B的长度分别为a,b
     *两个指针都遍历两个链表，如果相交，会在交点汇合；否则同时到达链表尾
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB){
        ListNode node1 = headA;
        ListNode node2 = headB;
        while(node1 != node2){
            if (node1 == null){
                node1 = headB;
            }
            if (node2 == null){
                node2 = headA;
            }
            node1 = node1.next;
            node2 = node2.next;
        }
        return node1;

    }
}
