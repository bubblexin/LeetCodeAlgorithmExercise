package leetcode.offer;

import leetcode.bean.TreeNode;

import java.util.*;

/**
 * 剑指 Offer 32 - II. 从上到下打印二叉树 III（之字形打印）
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/
 * <p>
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 * <p>
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * <p>
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 * <p>
 * 提示：
 * <p>
 * 节点总数 <= 1000
 */
public class Offer32III {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            // 也可以在此处换位 LinkedList，当 res 长度为奇数，则 addFirst，头插，否则 addLast 尾插
            List<Integer> level = new ArrayList<>();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            // 若 res 的长度为奇数，说明当前是偶数层，则对 level 执行倒序操作
            if (result.size() % 2 == 1) {
                Collections.reverse(level);
            }
            result.add(level);
        }

        return result;
    }
}
