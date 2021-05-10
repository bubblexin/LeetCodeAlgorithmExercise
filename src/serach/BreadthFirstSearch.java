package serach;

import leetcode.bean.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * BFS（Breadth First Search）：层序遍历，广度优先搜索
 */
public class BreadthFirstSearch {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // 只要队列不空，就继续循环
        while (!queue.isEmpty()) {
            // 开始新的一层的遍历
            List<Integer> breadth = new ArrayList<>();
            int size = queue.size();
            // 里边是对一层 node 的遍历操作
            while (size-- > 0) {
                TreeNode node = queue.poll();
                breadth.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            // 遍历完一层，add 进 list
            ans.add(breadth);
        }
        return ans;
    }

    public List<Integer> levelOrder2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            ans.add(node.val);
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        return ans;
    }
}
