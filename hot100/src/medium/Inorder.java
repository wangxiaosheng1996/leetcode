package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author wxs
 * @create 2020/9/14   9:16
 */
public class Inorder {
    List<Integer> list = new ArrayList<Integer>();
    public List<Integer> inorderTraversal(TreeNode root) {
        inorder(root);
        return list;
    }

    public void inorder(TreeNode node){
        if(node==null){
            return;
        }
        inorder(node.left);
        list.add(node.val);
        inorder(node.right);
    }
    //中序遍历，使用栈
    public void inorder2(TreeNode node){
        Stack<TreeNode> stack = new Stack<>();
        while(node != null || !stack.isEmpty()){
            while (node!=null){
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            list.add(node.val);
            node = node.right;

        }
    }


}















