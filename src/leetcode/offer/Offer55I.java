package leetcode.offer;

import leetcode.bean.TreeNode;

import javax.xml.soap.Node;
import java.util.LinkedList;
import java.util.List;

/**
 * 55 - I. 二叉树的深度
 * https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof/
 *
 * 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 *
 * 例如：
 *
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 * 提示：
 *
 * 节点总数 <= 10000
 * 注意：本题与主站 104 题相同：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 */
public class Offer55I {
    /**
     * 后序遍历（深度优先搜索）
     * 思路：
     * 采用后续遍历
     * 结束条件是：当某次遍历传入的 root == null 时，代表其已越过最后的叶子节点，即返回 0
     * 递归：分别递归计算左右子树
     * 方法的返回值：取左子树与右子树之间的深度的最大值 + 1
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left + 1, right + 1);
    }

    /**
     * 层序遍历（广度优先搜索）
     *
     * @param root
     * @return
     */
    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<TreeNode> queue = new LinkedList<>(), temp;
        queue.add(root);
        int num = 0;

        while (!queue.isEmpty()) {
            temp = new LinkedList<>();
            for (TreeNode node : queue) {
                if (node.left != null) {
                    temp.add(node.left);
                }
                if (node.right != null) {
                    temp.add(node.right);
                }
            }
            queue = temp;
            num++;
        }
        return num;
    }
}
