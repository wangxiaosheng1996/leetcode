package easy;


import com.sun.scenario.effect.Brightpass;

/**
 * @author wxs
 * @create 2020/9/16   14:38
 *
给定一个二叉树，找出其最大深度。

二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

说明: 叶子节点是指没有子节点的节点。

示例：
给定二叉树 [3,9,20,null,null,15,7]，

 3
/ \
9  20
  /  \
 15   7
 */
public class MaxDepth {
    /**
     * 遍历二叉树，到底叶子结点的时候计算从根节点到达当前叶子结点的路径长度，找到其中的最大值
     * @param root
     * @return
     */
    private int i=0,max = 0;
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        preorder(root);
        return max;



    }

    public void preorder(TreeNode node){
        i++;
        if(node.left==null && node.right==null){
            max = Math.max(max,i);
            i--;
            return;
        }
        if(node.left != null){
            preorder(node.left);
        }
        if(node.right != null){
            preorder(node.right);
        }
        i--;



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
