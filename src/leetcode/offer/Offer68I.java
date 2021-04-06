package leetcode.offer;

import leetcode.bean.TreeNode;

/**
 * 剑指 Offer 68 - I. 二叉搜索树的最近公共祖先
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof/
 * <p>
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 例如，给定如下二叉搜索树: root = [6,2,8,0,4,7,9,null,null,3,5]
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * 输出: 6
 * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
 * 示例 2:
 * <p>
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * 输出: 2
 * 解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
 * <p>
 * 说明:
 * <p>
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉搜索树中。
 * 注意：本题与主站 235 题相同：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 */
public class Offer68I {
    /**
     * 二叉搜索树，所有子树的左节点都比根节点小，所有子树的右节点都比根节点大
     * <p>
     * 若 root 是 p,q 的最近公共祖先，则只可能是如下情况
     * 1. p、q 在 root 的子树中，分列 root 两侧
     * 2. p = root，q 在 p 的左或右子树中
     * 3. q = root，p 在 q 的左或右子树中
     * <p>
     * 由题目的两个条件 ① 树为 二叉搜索树 ，② 树的所有节点的值都是唯一的可以得出
     * 1. 若 root.val < p.val，则 p 在 root 右子树中
     * 2. 若 root.val > p.val，则 p 在 root 左子树中
     * 3. 若 root.val == p.val，则 p == root
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            // 若 p、q 在同一侧，则继续向下遍历
            if (root.val < p.val && root.val < q.val) root = root.right;
            if (root.val > p.val && root.val > q.val) root = root.left;
                // p、q 不在同一侧，break
            else break;
        }

        return root;
    }

    /**
     * 递归解法
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        // 若 p、q 在同一侧，则继续向下遍历
        if (root.val < p.val && root.val < q.val) return lowestCommonAncestor2(root.right, p, q);
        if (root.val > p.val && root.val > q.val) return lowestCommonAncestor2(root.left, p, q);

        return root;
    }
}
