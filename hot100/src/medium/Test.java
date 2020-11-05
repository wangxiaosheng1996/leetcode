package medium;

/**
 * @author wxs
 * @create 2020/8/3   16:30
 */
public class Test {
    public static void main(String[] args){
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        node1.left = node2;
        node1.right = node5;
        node2.left = node3;
        node2.right = node4;
        node5.right = node6;

        BinaryTreeExpand treeExpand = new BinaryTreeExpand();
        treeExpand.flatten(node1);
        System.out.println();

    }
}
