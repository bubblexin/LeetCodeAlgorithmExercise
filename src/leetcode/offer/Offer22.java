package leetcode.offer;

import leetcode.bean.ListNode;

/**
 * 22.链表中倒数第 k 个节点
 * 双指针法，定义一个前指针 former 和一个后指针 latter，让 former 先走 k 步，然后遍历链表
 * 当 former 跳出最后一个节点时（走了 N 步），latter 的位置是 N-k，即倒数第 k 个位置
 * https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 */
public class Offer22 {
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
