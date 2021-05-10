package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 面试题 03.06. 动物收容所（猫狗队列）
 * https://leetcode-cn.com/problems/animal-shelter-lcci/
 * https://52heartz.top/articles/cat-dog-queue/  用类实现
 *
 * <p>
 * 动物收容所。有家动物收容所只收容狗与猫，且严格遵守“先进先出”的原则。在收养该收容所的动物时，收养人只能收养所有动物中“最老”（由其进入收容所的时间长短而定）的动物，
 * 或者可以挑选猫或狗（同时必须收养此类动物中“最老”的）。换言之，收养人不能自由挑选想收养的对象。请创建适用于这个系统的数据结构，实现各种操作方法，
 * 比如enqueue、dequeueAny、dequeueDog和dequeueCat。允许使用Java内置的LinkedList数据结构。
 * <p>
 * enqueue方法有一个animal参数，animal[0]代表动物编号，animal[1]代表动物种类，其中 0 代表猫，1 代表狗。
 * <p>
 * dequeue*方法返回一个列表[动物编号, 动物种类]，若没有可以收养的动物，则返回[-1,-1]。
 * <p>
 * 示例1:
 * <p>
 * 输入：
 * ["AnimalShelf", "enqueue", "enqueue", "dequeueCat", "dequeueDog", "dequeueAny"]
 * [[], [[0, 0]], [[1, 0]], [], [], []]
 * 输出：
 * [null,null,null,[0,0],[-1,-1],[1,0]]
 * 示例2:
 * <p>
 * 输入：
 * ["AnimalShelf", "enqueue", "enqueue", "enqueue", "dequeueDog", "dequeueCat", "dequeueAny"]
 * [[], [[0, 0]], [[1, 0]], [[2, 1]], [], [], []]
 * 输出：
 * [null,null,null,null,[2,1],[0,0],[1,0]]
 * 说明:
 * <p>
 * 收纳所的最大容量为 20000
 */
public class AnimalShelf {
    public Queue<int[]> dequeDog;
    public Queue<int[]> dequeCat;
    public static final int CAT = 0;
    public static final int DOG = 1;

    public AnimalShelf() {
        dequeDog = new LinkedList<>();
        dequeCat = new LinkedList<>();
    }

    /**
     * animal[0]代表动物编号，animal[1]代表动物种类
     * 其中 0 代表猫，1 代表狗。
     *
     * @param animal
     */
    public void enqueue(int[] animal) {
        if (animal[1] == CAT) {
            dequeCat.offer(animal);
        } else {
            dequeDog.offer(animal);
        }
    }

    public int[] dequeueAny() {
        if (dequeCat.isEmpty() && !dequeDog.isEmpty()) {
            // 猫空，狗不空，返回狗头
            return dequeDog.poll();
        } else if (!dequeCat.isEmpty() && dequeDog.isEmpty()) {
            // 狗空，猫不空，返回猫头
            return dequeCat.poll();
        } else if (dequeCat.isEmpty() && dequeDog.isEmpty()) {
            // 猫狗都空，返回 [-1,-1]
            return new int[]{-1, -1};
        } else {
            // 猫狗都不空，比较两个队列头，谁在前面返回谁
            int[] cat = dequeCat.peek();
            int[] dog = dequeDog.peek();
            if (cat[0] < dog[0]) {
                return dequeCat.poll();
            } else {
                return dequeDog.poll();
            }
        }
    }

    public int[] dequeueDog() {
        if (!dequeDog.isEmpty()) {
            return dequeDog.poll();
        }
        return new int[]{-1, -1};
    }

    public int[] dequeueCat() {
        if (!dequeCat.isEmpty()) {
            return dequeCat.poll();
        }
        return new int[]{-1, -1};
    }
}
