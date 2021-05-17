package leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * 阻塞队列 + wait() + notify() 模式实现生产者消费者
 */
public class ProducerConsumer {
    public static void main(String[] args) {
        int size = 10;
        Queue<Integer> queue = new LinkedList<>();
        Producer p = new Producer(queue, size);
        Consumer c = new Consumer(queue);
        Thread pThread = new Thread(p);
        Thread cThread = new Thread(c);
        cThread.start();
        pThread.start();
    }
}

class Producer implements Runnable {
    private final Queue<Integer> queue;
    private final int size;

    public Producer(Queue<Integer> queue, int size) {
        this.queue = queue;
        this.size = size;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (queue) {
                // 满了，就不生产了
                if (size == queue.size()) {
                    try {
                        System.out.println("满了");
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                int i = new Random().nextInt(100);
                System.out.println("生产了" + i);
                queue.add(i);
                queue.notifyAll();
            }
        }
    }
}

class Consumer implements Runnable {
    private final Queue<Integer> queue;

    public Consumer(Queue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (queue) {
                // 空的，不消费
                if (queue.size() <= 0) {
                    try {
                        System.out.println("空的");
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                int i = queue.remove();
                System.out.println("消费了" + i);
                queue.notifyAll();
            }
        }
    }
}