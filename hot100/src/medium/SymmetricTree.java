package medium;

import sun.reflect.generics.tree.Tree;

/**
 * @author wxs
 * @create 2020/9/13   20:59
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 *  
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *  
 *
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/symmetric-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SymmetricTree {
    private boolean flag = true;
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        if(root.left==null && root.right==null){
            return true;
        }else if(root.left!=null && root.right!=null){
            search(root.left,root.right);
            return flag;
        }else{
            return false;
        }

    }

    private void search(TreeNode leftNode,TreeNode rightNode){
        if(leftNode.val!=rightNode.val){
            flag = false;
            return;
        }
        if(leftNode.left==null && rightNode.right==null){
        }else if(leftNode.left!=null && rightNode.right!=null){
            search(leftNode.left,rightNode.right);
        }else{
            flag = false;
            return;
        }
        if(leftNode.right==null && rightNode.left==null){
            return;
        }else if(leftNode.right!=null && rightNode.left!=null){
            search(leftNode.right,rightNode.left);
        }else{
            flag = false;
            return;
        }
    }

    public boolean isSymmetric2(TreeNode root){
        if(root==null){
            return true;
        }
        if(root.left == null && root.right == null){
            return true;
        }
        if (root.left == null || root.right == null){
            return false;
        }

        return check(root.left,root.right);

    }

    public boolean check(TreeNode p, TreeNode q){
        if(p==null && q==null){
            return true;
        }
        if(p == null || q== null){
            return false;
        }
        return p.val == q.val && check(p.left,q.right) && check(p.right,q.left);
    }
















}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}