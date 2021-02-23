package leetcode.offer;

import leetcode.bean.ListNode;

/**
 * 25.合并两个排序的链表、
 * https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * <p>
 * 示例1：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * 限制：
 * <p>
 * 0 <= 链表长度 <= 1000
 * <p>
 * 题解：
 * 1.因为最后要返回头结点，所以预先声明一个空的节点作为伪头结点，最后返回这个伪头结点的 next 即是需要的 ListNode
 * 2.因为 l1,l2 是递增的，所以可以使用双指针遍历两链表，根据 l1.val 和 l2.val 的大小关系确定添加顺序，两指针交替前进，直到遍历结束
 * 3.l1.val <= l2.val 时，将 l1 赋值给 cur.next；l2.val < l1.val 时，将 l2 赋值给 cur.next
 * 4.移动指针 l1 = l1.next/l2 = l2.next，同时将 cur 前进一步，将 cur.next 赋值给 cur
 * 5.while 的循环条件为 l1!=null || l2!=null
 * 6.注意，当 l1==null 时，将 l2 剩余部分赋值给 cur，然后 return 跳出 while 循环；同理，当 l2==null 时，将 l1 剩余部分赋值给 cur，然后 return 跳出 while 循环
 */
public class Offer25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0); // 定义头结点
        ListNode cur = pre;

        while (l1 != null || l2 != null) {
            if (l1 == null) {
                cur.next = l2;
                break;
            }

            if (l2 == null) {
                cur.next = l1;
                break;
            }

            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;

        }
        return pre.next;
    }
}
