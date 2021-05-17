package leetcode;

import leetcode.bean.ListNode;

/**
 * 61. 旋转链表
 * https://leetcode-cn.com/problems/rotate-list/
 * <p>
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 * <p>
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[4,5,1,2,3]
 * <p>
 * 提示：
 * <p>
 * 链表中节点的数目在范围 [0, 500] 内
 * -100 <= Node.val <= 100
 * 0 <= k <= 2 * 109
 */
public class Solution61 {
    /**
     * 移动的最终次数为 k % n
     * 移动后链表尾部的元素在原来链表中的位置为 n - k % n
     * 如果 k % n 为 0（k % n == 0 || n - k % n == n），则直接返回 head 即可
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) return head;
        ListNode iter = head;
        int n = 1;
        while (iter.next != null) {
            iter = iter.next;
            n++;
        }

        // 求出移动 k 次后尾部索引
        int tailIndex = n - k % n;
        // 如果移动 k 次，尾部索引为 n，则证明 k 为 n 的整数次，等于没移动
        if (tailIndex == n) {
            return head;
        }
        // 成环操作
        iter.next = head;

        // 此时 tailIndex 指向原链表末尾，则移动上一步求出来的，新的链表尾在原链表中的索引次，得到新链表的最后一个节点
        while (tailIndex-- > 0) {
            iter = iter.next;
        }
        ListNode newHead = iter.next;
        iter.next = null;
        return newHead;
    }
}
