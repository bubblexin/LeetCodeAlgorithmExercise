package leetcode.offer;

import com.sun.org.apache.bcel.internal.generic.IFLE;
import leetcode.bean.TreeNode;

/**
 * 55 - II. 平衡二叉树
 * https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/
 * <p>
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 * <p>
 * 示例 1:
 * <p>
 * 给定二叉树 [3,9,20,null,null,15,7]
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回 true 。
 * <p>
 * 示例 2:
 * <p>
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 * <p>
 * 1
 * / \
 * 2   2
 * / \
 * 3   3
 * / \
 * 4   4
 * 返回 false 。
 * <p>
 * 限制：
 * <p>
 * 0 <= 树的结点个数 <= 10000
 * 注意：本题与主站 110 题相同：https://leetcode-cn.com/problems/balanced-binary-tree/
 */
public class Offer55II {
    /**
     * 思路一：
     * 先序遍历 + 判断深度
     * 分别判断当前子树是否是平衡树、左节点是否是平衡树、右节点是否是平衡树
     * 通过 maxDepth 计算节点深度，深度差小于等于 1 的，是平衡树，空树也是平衡树
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left + 1, right + 1);
    }

    /**
     * 思路二：
     * 后序遍历 + 剪枝 （从底至顶）
     *
     * @param root
     * @return
     */
    public boolean isBalanced2(TreeNode root) {
//        若 recur(root) != -1 ，则说明此树平衡，返回 truetrue ； 否则返回 falsefalse 。
        return recur(root) != -1;
    }

    /**
     * 终止条件：
     * 1.当 root 为空：说明越过叶节点，因此返回高度 0
     * 2.当左（右）子树深度为 -1 ：代表此树的 左（右）子树 不是平衡树，因此剪枝，直接返回 -1
     *
     * 返回值：
     * 1.当节点root 左/右子树的深度差 ≤ 1，则返回当前子树的深度，即节点 root 的左/右子树的深度最大值 +1（max(left, right) + 1）
     * 2.当节点root 左/右子树的深度差 > 2 ：则返回 -1，代表此子树不是平衡树 。
     * 3.root 为空，返回 0
     * @param root
     * @return
     */
    public int recur(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = recur(root.left);
        if (left == -1) return -1;
        int right = recur(root.right);
        if (right == -1) return -1;
        return Math.abs(left - right) <= 1 ? Math.max(left, right) + 1 : -1;
    }
}
