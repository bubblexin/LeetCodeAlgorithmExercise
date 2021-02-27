package leetcode.offer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 9. 用两个栈实现队列
 * https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 * <p>
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"] （leetcode 上的函数调用顺序）
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 * 示例 2：
 * <p>
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 * 提示：
 * <p>
 * 1 <= values <= 10000
 * 最多会对 appendTail、deleteHead 进行 10000 次调用
 */
public class Offer9 {
    Deque<Integer> pushStack; // 用于添加元素
    Deque<Integer> popStack; // 用于删除元素

    public Offer9() {
        pushStack = new LinkedList<>();
        popStack = new LinkedList<>();
    }

    public void appendTail(int value) {
        pushStack.push(value);
    }

    public int deleteHead() {
        // pop 为空，push 不为空，pushStack 出栈到 popStack
        if (popStack.isEmpty()) {
            if (pushStack.isEmpty()) {
                return -1;
            }
            // peek() 方法不安全
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
        return popStack.pop();
    }
}
