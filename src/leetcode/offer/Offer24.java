package leetcode.offer;

import leetcode.bean.ListNode;

/**
 * 24. 反转链表
 * https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
 *
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * <p>
 * 限制：
 * <p>
 * 0 <= 节点个数 <= 5000
 * <p>
 * 题解：
 * 涉及到链表的操作，一定要在纸上把过程先画出来，再写程序。
 * <p>
 */
public class Offer24 {
    /**
     * 使用双指针法，每次完成相邻两个元素的反转，直到遍历到最后一个节点
     *  1、定义一个 pre 指针，和一个 cur 指针，pre 指针在 cur 的前面
     *  2、while 循环的条件是 cur ！= null 的时候，因为当 cur 为空时，证明遍历到最后一个节点了
     *  3、每次 while 循环中先记录 cur 节点的 next 节点（正常顺序的下一个节点是谁，最后移动当前节点时将其赋值给 cur）
     *  4、将 pre 赋值给 cur.next，因为 pre 永远在 cur 前边，完成小范围反转
     *  5、将 cur、pre 向前移动一个位置
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode cur = head; //
        ListNode pre = null;
        while (cur != null) {
            // 记录正常顺序的 next 节点，用于后边移动 cur 指针
            ListNode temp = cur.next;
            // 将 pre 赋值给 cur.next
            cur.next = pre;
            // 将 cur、pre 都向前移动一步
            pre = cur;
            cur = temp;
        }

        return pre;
    }

    /**
     * 递归实现
     * @param head
     * @return
     */
    public ListNode reverse(ListNode head) {
        // 链表为空， 或者链表的 next 为空，证明只有自己，直接返回
        if (head == null || head.next == null) {
            return head;
        }

        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;

        return last;
    }
}
