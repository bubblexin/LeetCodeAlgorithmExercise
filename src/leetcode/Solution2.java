package leetcode;

import leetcode.bean.ListNode;

/**
 * 2.两数相加
 * https://leetcode-cn.com/problems/add-two-numbers/
 * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * <p>
 * 1.定义前置节点
 * 2.遍历 l1、l2 链表，有一个不为空时就继续循环相加
 * 3.l1、l2 哪个短，哪个在最后补 0 (将两个链表看成是相同长度的进行遍历，如果一个链表较短则在前面补 0，比如 987 + 23 = 987 + 023 = 1010)
 * 4.求 sum，l1、l2 对应位置相加，再加上 carry 进位值，对十求余，取其个位值 (l1+l2+carry)%10
 * 5.算出下一位的进位，l1、l2 对应位置相加对 10 求除数 (l1+l2)/10
 * 6.移动当前链表指针，移动 l1 l2 指向位置
 * 7.循环结束，处理进位，若进位还不为空，则在最后添加一个新节点值为进位 carry 的值
 *
 * 小技巧：对于链表问题，返回结果为头结点时，通常可以先初始化一个预先指针 pre，该指针的下一个节点指向真正的头结点 head。
 * 使用预先指针的目的在于链表初始化时无可用节点值，而且链表构造过程需要指针移动，进而会导致头指针丢失，无法返回结果。
 *
 * <p>
 */
public class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0); // 初始化定义前置节点
        ListNode cur = pre; // 定义当前节点等于前置节点
        int carry = 0; // 定义保存进位的变量
        while (l1 != null || l2 != null) {
            // l1、l2 某条链表过短，空缺的位置赋值为 0
            // 将两个链表看成是相同长度的进行遍历，如果一个链表较短则在前面补 0，比如 987 + 23 = 987 + 023 = 1010
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;

            cur.next = new ListNode(sum % 10);
            carry = sum / 10;

            cur = cur.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        // while 循环之后，进位还不为 0，则新添加一个节点，代表进位
        if (carry > 0) {
            cur.next = new ListNode(carry);
        }
        return pre.next;
    }
}
