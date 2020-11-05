package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wxs
 * @create 2020/9/14   9:55
 * 二叉树展开为链表
 */
public class BinaryTreeExpand {
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        preorder2(root,list);
        TreeNode pre = null;
        TreeNode cur = null;
        for(TreeNode node:list){
            cur = node;
            if(pre != null){
                pre.left = null;
                pre.right = cur;
            }
            pre = cur;
        }
    }

    public void preorder2(TreeNode node,List<TreeNode> list){
        if(node == null){
            return;
        }
        list.add(node);
        preorder2(node.left,list);
        preorder2(node.right,list);
    }


    TreeNode pre = null;
    TreeNode cur = null;
    //该方法实现的链表中指向下一个结点的指针是left
    public void preorder(TreeNode node){
        if(node == null){
            return;
        }
        cur = node;
        if(pre != null){
            pre.left = cur;
        }
        pre = cur;

        preorder(node.left);
        preorder(node.right);
    }
}
