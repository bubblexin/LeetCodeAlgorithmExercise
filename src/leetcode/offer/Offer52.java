package leetcode.offer;

import leetcode.bean.ListNode;

/**
 * Offer 52. 两个链表的第一个公共节点
 * https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/
 * <p>
 * 输入两个链表，找出它们的第一个公共节点。
 * 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * 输出：Reference of the node with value = 2
 * 输入解释：相交节点的值为 2 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
 * <p>
 * 注意：
 * <p>
 * 如果两个链表没有交点，返回 null.
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 * 本题与主站 160 题相同：https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 */
public class Offer52 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A = headA;
        ListNode B = headB;
        while (A != B) {
            if (A == null || A.next == null) {
                A = headB;
            } else {
                A = A.next;
            }

            if (B == null || B.next == null) {
                B = headA;
            } else {
                B = B.next;
            }
        }
        return A;
    }

    /**
     * 简便写法
     * 双指针法，设 a 链表长度为 l1，b 链表长度为 l2，公共部分长度为 l3，指针 A 指向 aHead，B 指向 bHead
     * 则当 a 遍历到结尾时，让其从 b 链表头继续遍历；b 遍历到链表结尾时，让其从 a 链表头继续遍历；
     * 则他们相遇时 A 总共走了 l1 + l2 - l3，B 总共走了 l2 + l1 - l3
     * 如果他们有交点，则此时的 A/B 就是交点；若他们没有交点，则此时 A/B 为 null
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode A = headA;
        ListNode B = headB;
        while (A != B) {
            A = (A != null) ? A.next : headB;
            B = (B != null) ? B.next : headA;
        }
        return A;
    }
}
