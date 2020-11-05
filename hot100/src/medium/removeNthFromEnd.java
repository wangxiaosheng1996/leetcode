package medium;

/**
 * @author wxs
 * @create 2020/8/3   16:55
 */
public class removeNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        /*第一种方法，两次遍历
        //先遍历链表得到链表的长度l
        //设置哑结点
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curNode = head;
        //链表的长度
        int l=0;
        while(curNode!=null){
            l++;
            curNode = curNode.next;
        }
        //删除链表中倒数第n个结点：相当于删除第l-n+1个结点,将第l-n个结点的next指向l-n+2结点
        curNode = dummy;
        for(int i=0;i<l-n;i++){
            curNode=curNode.next;
        }
        curNode.next = curNode.next.next;
        return dummy.next;
         */
        //第一种方法：一次遍历，用双指针
        //两个指针相距n，后一个指针到达末尾，前一个指针刚好指向倒数第n-1个结点
        //设置哑结点
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        for(int i=0;i<n;i++){
            second=second.next;
        }
        while(second.next!=null){
            first = first.next;
            second = second.next;
        }
        first.next = first.next.next;
        return dummy.next;



    }
}





class ListNode{
    Integer value;
    ListNode next;

    ListNode(int value){
        this.value = value;
    }
}