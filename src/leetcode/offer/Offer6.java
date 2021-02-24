package leetcode.offer;

import leetcode.bean.ListNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 6. 从尾到头打印链表
 * https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 * 示例 1：
 *
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *
 * 限制：
 *
 * 0 <= 链表长度 <= 10000
 */
public class Offer6 {
    public int[] reversePrint(ListNode head) {
        // 利用栈的特性，后进先出
        Stack<Integer> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur.val);
            cur = cur.next;
        }
        int stackSize = stack.size();
        int[] array = new int[stackSize];
        for (int i = 0; i < stackSize; i++) {
            array[i] = stack.pop();
        }
        return array;
    }

    ArrayList<Integer> tmp = new ArrayList<>();

    /**
     * 递归解法
     * @param head
     * @return
     */
    public int[] reverse(ListNode head) {
        recur(head);
        int[] temp = new int[tmp.size()];
        for (int i = 0; i < tmp.size(); i++) {
            temp[i] = tmp.get(i);
        }
        return temp;
    }

    public void recur(ListNode node) {
        if (node == null) {
            return;
        }
        recur(node.next);
        tmp.add(node.val);
    }
}
