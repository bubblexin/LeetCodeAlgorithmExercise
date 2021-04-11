package leetcode;

import leetcode.bean.ListNode;

/**
 * 92. 反转链表 II（定区间反转链表）
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 * <p>
 * 示例：
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 * <p>
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 * <p>
 * 提示：
 * <p>
 * 链表中节点数目为 n
 * 1 <= n <= 500
 * -500 <= Node.val <= 500
 * 1 <= left <= right <= n
 * <p>
 * 进阶： 你可以使用一趟扫描完成反转吗？
 */
public class Solution92 {
    /******************************** 解法一 **************************************/

    /**
     * 时间复杂度：O(N)，N 是链表总节点数，最坏情况下，需要遍历整个链表
     * 空间复杂度：O(1)，只用到常数个变量
     *
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = new ListNode(-1);
        temp.next = head;

        // 求 left 前一个 node
        ListNode preLeftNode = temp;
        for (int i = 0; i < left - 1; i++) {
            preLeftNode = preLeftNode.next;
        }

        // 求要反转链表的最后一个节点
        ListNode rightNode = preLeftNode;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }

        // 记录链表左节点，右节点的下一个节点
        ListNode rightNextNode = rightNode.next;
        ListNode leftNode = preLeftNode.next;

        // 断开要翻转的链表
        preLeftNode.next = null;
        rightNode.next = null;

        // 翻转链表
        reverseNode(leftNode);

        // 连接断开的链表
        preLeftNode.next = rightNode;
        leftNode.next = rightNextNode;

        return temp.next;
    }

    // 反转链表
    public void reverseNode(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
    }

    /******************************** 解法二 **************************************/
    /**
     * 一次遍历（就是头插法），解答时画个图更清晰，
     *
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween2(ListNode head, int left, int right) {
        ListNode temp = new ListNode(-1);
        temp.next = head;

        // 记录 pre，left 的前一个节点
        ListNode pre = temp;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        // 记录 cur，cur 是待反转链表的头结点，不会变
        ListNode cur = pre.next;
        // 永远指向 cur 的 next
        ListNode curNext = cur.next;

        // 遍历反转链表
        for (int i = 0; i < right - left; i++) {
            // 先将 left 头结点的 next 指向带插入头的 next
            cur.next = curNext.next;
            // 新插入的头结点的 next 永远是 pre 的 next
            curNext.next = pre.next;
            // 连接 pre.next 与 新插入的头结点
            pre.next = curNext;
            // 更新 curNext 的值
            curNext = cur.next;
        }
        return temp.next;
    }
}
