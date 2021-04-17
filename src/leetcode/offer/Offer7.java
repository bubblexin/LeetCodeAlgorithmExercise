package leetcode.offer;

import leetcode.bean.TreeNode;

import java.util.HashMap;

/**
 * 剑指 Offer 07. 重建二叉树
 * https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/
 * <p>
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * <p>
 * 例如，给出
 * <p>
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 限制：
 * <p>
 * 0 <= 节点个数 <= 5000
 *
 * 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 *
 * 思路：通过递归分治思想，将问题拆解
 * 1. 由前序遍历第一个节点即为树的根节点
 * 2. 则由根节点在中序遍历中的位置，可将中序遍历分为三部分：左子树 -> 根 -> 右子树
 * 3. 求出根节点在中序遍历中的 index，则就可知道前序遍历中，从哪个 left 到 right 是左子树，从哪个 left 到 right 是右子树了
 * （即，将先序遍历划分为了 根 -> 左子树 -> 右子树）
 */
public class Offer7 {
    int[] preorder;
    HashMap<Integer, Integer> dic = new HashMap<>();  // 保存中序遍历中各元素的位置

    /**
     * @param preorder 前序遍历
     * @param inorder  中序遍历
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++)
            dic.put(inorder[i], i); // 将中序遍历的各个元素与索引关系存在 map 中
        // 当前根的索引
        // 递归树的左边界，即数组左边界
        // 递归树的右边界，即数组右边界
        return recur(0, 0, inorder.length - 1);
    }

    /**
     *
     * @param preRootIndex 根节点在先序遍历的 index
     * @param inLeft 子树在中序遍历的左边界
     * @param inRight 子树在中序遍历的右边界
     * @return
     */
    private TreeNode recur(int preRootIndex, int inLeft, int inRight) {
        if (inLeft > inRight) return null;
        TreeNode node = new TreeNode(preorder[preRootIndex]);
        int i = dic.get(preorder[preRootIndex]);  // 取出中序遍历中，根节点所在的索引
        // 递归左子树的根的位置为原来的先序中的根的索引 +1
        // 递归左子树的左边界为原来的中序 inLeftIndex
        // 递归左子树的右边界为中序根的索引 -1
        node.left = recur(preRootIndex + 1, inLeft, i - 1);
        // 递归右子树的根的位置为原来的先序遍历的当前根的位置加左子树数量 +1
        // 递归右子树的左边界为中序遍历中当前根节点索引 +1
        // 递归右子树的右边界为中序遍历原来右子树的边界
        node.right = recur(preRootIndex + i - inLeft + 1, i + 1, inRight);
        return node;
    }
}
