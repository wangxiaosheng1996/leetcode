package easy;

import sun.awt.geom.AreaOp;

/**
 * @author wxs
 * @create 2020/9/14   20:03
 */
public class Test {
    public static void main(String[] args) {
//        TreeNode node1 = new TreeNode(1);
//        TreeNode node2 = new TreeNode(2);
//        TreeNode node3 = new TreeNode(3);
//        TreeNode node4 = new TreeNode(4);
//        TreeNode node5 = new TreeNode(5);
//        node1.left = node2;
//        node1.right = node3;
//        node2.left = node4;
//        node3.right = node5;
//        TreeTraversal traversal = new TreeTraversal();
//        traversal.inorder(node1);
        ListNode node1 = new ListNode(-129);
        ListNode node2 = new ListNode(-129);
        node1.next = node2;
        IsPalindrome isPalindrome = new IsPalindrome();
        System.out.println(isPalindrome.isPalindrome(node1));



    }
}
