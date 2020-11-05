package easy;

import java.util.Stack;

/**
 * @author wxs
 * @create 2020/9/17   20:08
 */
public class TreeTraversal {
    /**
     * 二叉树的非递归先序遍历
     * @param root
     */
    public void preorder(TreeNode root){
        if(root == null){
            return;
        }
        Stack<TreeNode> nodes = new Stack<>();
        nodes.push(root);
        while(!nodes.isEmpty()){
            TreeNode cur = nodes.pop();
            System.out.println(cur.val);
            //将左右子结点添加到堆栈，先加右结点，后加左结点
            if(cur.right != null){
                nodes.push(cur.right);
            }
            if(cur.left != null){
                nodes.push(cur.left);
            }
        }
    }

    /**
     * 中序遍历
     * @param root
     */
    public void inorder(TreeNode root){
        Stack<TreeNode> nodes = new Stack<>();
        TreeNode tmp = root;
        while (!nodes.isEmpty() || tmp != null){
            while (tmp != null){
                nodes.push(tmp);
                tmp = tmp.left;
            }
            tmp = nodes.pop();
            System.out.println(tmp.val);
            tmp = tmp.right;


        }

    }

    /**
     * 后续遍历
     * @param root
     */
    public void postorder(TreeNode root){
        Stack<TreeNode> nodes = new Stack<>();
        TreeNode tmp = root;
        while (!nodes.isEmpty() || tmp != null){
            while (tmp != null){
                nodes.push(tmp);
                tmp = tmp.left;
            }
            tmp = nodes.peek().right;
            if(tmp != null){

            }else {
                tmp = nodes.pop();
                System.out.println(tmp);

            }
            System.out.println(tmp.val);
            tmp = tmp.right;


        }

    }



}
