package leetcode.offer;

import leetcode.bean.TreeNode;

/**
 * 剑指 Offer 68 - II. 二叉树的最近公共祖先
 * https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/
 */
public class Offer68II {
    /**
     * 终止条件：
     * 1. 当越过叶节点，直接返回 null
     * 2. 当 root 等于 p/q，直接返回 root
     *
     * 递推工作：
     * 1. 递推左节点，记为 left
     * 2. 递推右节点，记为 right
     *
     * 返回值
     * 1. left 和 right 同时为 null，则 root 左右子树都不包含 p、q，返回 null
     * 2. left 和 right 同时不为 null，p、q 分列 root 两侧，root 为最近公共祖先
     * 3. left 为空，right 不空，
     *      1. p、q 其中一个在 root 右子树，此时 right 指向 p（假设为 p）
     *      2. p、q 都在 root 右子树，此时 right 指向最近公共祖先
     * 4. right 为空，同上罗逻辑
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null && right == null) return null;  // 1
        if (left == null) return right;  // 3
        if (right == null) return left;  // 4
        return root;  // 2 if(left != null && right != null)
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null; // 如果树为空，直接返回null
        if(root == p || root == q) return root; // 如果 p和q中有等于 root的，那么它们的最近公共祖先即为root（一个节点也可以是它自己的祖先）
        TreeNode left = lowestCommonAncestor(root.left, p, q); // 递归遍历左子树，只要在左子树中找到了p或q，则先找到谁就返回谁
        TreeNode right = lowestCommonAncestor(root.right, p, q); // 递归遍历右子树，只要在右子树中找到了p或q，则先找到谁就返回谁
        if(left == null) return right; // 如果在左子树中 p和 q都找不到，则 p和 q一定都在右子树中，右子树中先遍历到的那个就是最近公共祖先（一个节点也可以是它自己的祖先）
        else if(right == null) return left; // 否则，如果 left不为空，在左子树中有找到节点（p或q），这时候要再判断一下右子树中的情况，如果在右子树中，p和q都找不到，则 p和q一定都在左子树中，左子树中先遍历到的那个就是最近公共祖先（一个节点也可以是它自己的祖先）
        else return root; //否则，当 left和 right均不为空时，说明 p、q节点分别在 root异侧, 最近公共祖先即为 root
    }
}
