package easy;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author wxs
 * @create 2020/9/16   18:44
 * 给定一个链表，判断链表中是否有环。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 *
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class hasCycle {
    /**
     * 用两个指针，一个快指针，每次前进两步；一个慢指针，一次前进一步。
     * 如果慢指针能追上快指针，说明是环形；如果快指针先到达链表尾，说明不是环形。
     * @param head
     * @return
     */
    public boolean hasCycle2(ListNode head){
        //头指针为空或者链表只有一个结点返回false
        if(head == null || head.next == null){
            return false;
        }
        ListNode fast = head.next;//初始指向第二个结点
        ListNode slow = head;//初始指向头结点
        while(slow != fast){
            //快指针到达结尾，说明不是环形，返回false
            if(fast == null || fast.next == null){
                return false;
            }
            slow  = slow.next;//慢指针前进一步
            fast = fast.next.next;//快指针前进两步
        }
        return true;

    }

    /**
     * 遍历链表，用一个hashset来存储遍历过的结点，如果发现有重复的，说明是环形；如果到达结尾，说明不是环形。
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head){
        if(head == null){
            return false;
        }
        Set<ListNode> set = new HashSet<>();
        ListNode cur = head;
        while(!set.contains(cur)){
            set.add(cur);
            cur = cur.next;
            if(cur == null){
                return false;
            }
        }
        return true;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}