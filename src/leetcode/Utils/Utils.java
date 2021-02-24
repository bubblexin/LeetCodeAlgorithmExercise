package leetcode.Utils;

import leetcode.bean.ListNode;

public class Utils {
    /**
     * 根据数组生成 ListNode 链表
     *
     * @param array 链表中的数据
     * @return 返回生成的 ListNode
     */
    public static ListNode productListNode(int[] array) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        for (int i = 0; i < array.length; i++) {
            cur.next = new ListNode(array[i]);
            cur = cur.next;
        }
        return pre.next;
    }

    /**
     * 打印 ListNode
     *
     * @param node 要打印的 ListNode
     */
    public static void printListNode(ListNode node) {
        ListNode cur = node;
        System.out.print("[");
        while (cur != null) {
            System.out.print(cur.val);
            cur = cur.next;
        }
        System.out.print("]");
    }

    /**
     * 交换数组中两个位置的元素
     * @param arr
     * @param i
     * @param j
     */
    public static void swapIntArrayElement(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
