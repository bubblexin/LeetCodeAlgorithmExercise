package leetcode.offer;

import leetcode.bean.TreeNode;

/**
 * 剑指 Offer 54. 二叉搜索树的第k大节点
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/
 * <p>
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [3,1,4,null,2], k = 1
 * 3
 * / \
 * 1   4
 * \
 * 2
 * 输出: 4
 * 示例 2:
 * <p>
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 * 5
 * / \
 * 3   6
 * / \
 * 2   4
 * /
 * 1
 * 输出: 4
 * <p>
 * 限制：
 * <p>
 * 1 ≤ k ≤ 二叉搜索树元素个数
 */
public class Offer54 {
    int res, k;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }

    /**
     * 由二叉搜索树的定义可知，按照中序遍历的倒序遍历，遍历 k 次，即是第 k 大的数
     * @param root
     */
    public void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.right);
        if (k == 0) return;
        if (--k == 0) res = root.val;
        dfs(root.left);
    }
}
