package leetcode.offer;

import leetcode.bean.TreeNode;

/**
 * 剑指 Offer 26. 树的子结构
 * https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/
 * <p>
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * <p>
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 * <p>
 * 例如:
 * 给定的树 A:
 * <p>
 * 3
 * / \
 * 4   5
 * / \
 * 1   2
 * 给定的树 B：
 * <p>
 * 4
 * /
 * 1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = [1,2,3], B = [3,1]
 * 输出：false
 * 示例 2：
 * <p>
 * 输入：A = [3,4,5,1,2], B = [4,1]
 * 输出：true
 * 限制：
 * <p>
 * 0 <= 节点个数 <= 10000
 */
public class Offer26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) return false; // 特例处理，A 为空，或者 B 为空，直接返回 false
        // 遍历 A 中每个节点，A 树中任一节点包含 B 就能返回 true
        // 若树 B 是树 A 的子结构，则必满足以下三种情况之一，所以用 || 连接
        // 1. B 是 A 的子树
        // 2. B 是 A.left 的子树
        // 3. B 是 A.right 的子树
        return isContain(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    /**
     * 以A为根的数是否包含B（必须从A开始）
     * @param A
     * @param B
     * @return
     */
    public boolean isContain(TreeNode A, TreeNode B) {
        if (B == null) return true;  // 如果 B 为空，则证明遍历到了 B 的最后一个节点，A 中包含 B，返回 true
        if (A == null || A.val != B.val) {  // 如果 A 为空（A 遍历到最后了），或者 A 的值不等于 B 的值（匹配失败），也返回 false
            return false;
        }
        // 返回值递归判断 A.left 与 B.left 的比较，与上 A.right 与 B.right 的比较
        return isContain(A.left, B.left) && isContain(A.right, B.right);
    }
}
