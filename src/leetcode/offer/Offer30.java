package leetcode.offer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 30. 包含 min 函数的栈
 * https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/
 * <p>
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 * <p>
 * 示例:
 * <p>
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.min();   --> 返回 -2.
 * <p>
 * 提示：
 * <p>
 * 各函数的调用总次数不超过 20000 次
 * <p>
 * 注意：本题与主站 155 题相同：https://leetcode-cn.com/problems/min-stack/
 *
 * 解题思路：
 * 根据栈的特性，当压入一个新值的时候，若该值不出栈，下边的值都不会出栈（后进先出）
 * 所以只要保证每个新值入栈后，定义另一个辅助栈，依次记录当前状态下的最小值即可
 */
public class Offer30 {
    private Deque<Integer> deque;
    private Deque<Integer> minDeque;

    /**
     * initialize your data structure here.
     */
    public Offer30() {
        deque = new LinkedList<>();
        minDeque = new LinkedList<>();
    }

    public void push(int x) {
        deque.push(x);

        if (minDeque == null || x <= minDeque.peek()) {
            minDeque.push(x);
        }
    }

    public void pop() {
        if (deque.pop().equals(minDeque.peek())) {
            minDeque.pop();
        }
    }

    public int top() {
        return deque.peek();
    }

    public int min() {
        return minDeque.peek();
    }
}
