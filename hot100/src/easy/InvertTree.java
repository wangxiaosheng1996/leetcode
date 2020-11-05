package easy;

import sun.reflect.generics.tree.Tree;

/**
 * @author wxs
 * @create 2020/9/16   21:53
 * 翻转一棵二叉树。
 *
 * 示例：
 *
 * 输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/invert-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class InvertTree {
    /**
     * 遍历二叉树，结点的左右指针互换
     * @param root
     * @return
     */
    private TreeNode tem = null;
    public TreeNode invertTree(TreeNode root) {
        preorder(root);
        return root;
    }
    public void preorder(TreeNode node){
        if(node == null){
            return;
        }
        tem = node.left;
        node.left = node.right;
        node.right = tem;
        preorder(node.left);
        preorder(node.right);
    }
}











