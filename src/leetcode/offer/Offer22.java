package leetcode.offer;

import leetcode.bean.ListNode;

/**
 * 22.链表中倒数第 k 个节点
 * https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 *
 * 输入一个链表，输出该链表中倒数第 k 个节点。为了符合大多数人的习惯，本题从 1 开始计数，即链表的尾节点是倒数第 1 个节点。
 *
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 *
 * 返回链表 4->5.
 */
public class Offer22 {
    /**
     * 双指针法，定义一个前指针 former 和一个后指针 latter，让 former 先走 k 步，然后遍历链表
     * 当 former 跳出最后一个节点时（走了 N 步），latter 的位置是 N-k，即倒数第 k 个位置
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode former = head, latter = head;
        for (int i = 1; i <= k; i++)
            former = former.next;
        while (former != null) {
            latter = latter.next;
            former = former.next;
        }
        return latter;
    }
}
