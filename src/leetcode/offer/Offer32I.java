package leetcode.offer;

import leetcode.bean.TreeNode;

import java.util.*;

/**
 * 32 - I. 从上到下打印二叉树
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/
 * <p>
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 * <p>
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回：
 * <p>
 * [3,9,20,15,7]
 * <p>
 * 提示：
 * <p>
 * 节点总数 <= 1000
 */
public class Offer32I {
    /**
     * 要求从上至下打印，即按层打印，称为二叉树的广度优先搜索（BFS）（层序遍历）
     * BFS 通常借助队列的先进先出特性实现
     *
     * 特殊处理：
     * 根节点为空，直接返回
     *
     * 队头元素为空，跳出循环
     * 循环里：
     *      将队头 poll 出来，add 到临时 List
     *      如果当前队头的 left、right 不为空，则依次 add 到队列中
     *
     * 最后返回 res 数组
     *
     * @param root
     * @return
     */
    public int[] levelOrder(TreeNode root) {
        // 根节点为空，直接返回
        if (root == null) return new int[0];

        // 创建队列
        Queue<TreeNode> queue = new LinkedList<>();
        // 将根节点先 add 进去
        queue.add(root);

        // 创建辅助 List，用于最后构建 Array
        ArrayList<Integer> tempList = new ArrayList<>();

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            tempList.add(node.val);
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        int[] res = new int[tempList.size()];

        for (int i = 0; i < tempList.size(); i++) {
            res[i] = tempList.get(i);
        }
        return res;
    }
}
