package leetcode;

import java.util.HashMap;

/**
 * 同 Solution 146
 * 此处不继承 LinkedHashMap，自己使用 HashMap 和一个双向链表实现
 */
public class Solution146I {
    private HashMap<Integer, Entry> table = new HashMap<>();
    private int size = 0;
    private final int capacity;
    private final Entry head;
    private final Entry tail;

    public Solution146I(int capacity) {
        this.capacity = capacity;
        head = new Entry();
        tail = new Entry();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        Entry entry;
        if ((entry = table.get(key)) == null) return -1;
        moveToHead(entry);
        return entry.value;
    }

    public void put(int key, int value) {
        Entry entry;
        if ((entry = table.get(key)) == null) {
            Entry newEntry = new Entry(key, value);
            // 添加到 HashMap 中
            table.put(key, newEntry);
            // 添加到双向链表表头
            addToHead(newEntry);
            ++size;
            if (size > capacity) {
                Entry tailPre = removeTail();
                table.remove(tailPre.key);
                --size;
            }
        } else {
            // key 存在，则将其放到双向链表的链表头
            entry.value = value;
            moveToHead(entry);
        }
    }

    /**
     * 移除一个 Entry
     *
     * @param entry
     */
    private void removeEntry(Entry entry) {
        entry.next.pre = entry.pre;
        entry.pre.next = entry.next;
    }

    private Entry removeTail() {
        Entry tailPre = tail.pre;
        removeEntry(tailPre);
        return tailPre;
    }

    /**
     * 头插法
     *
     * @param entry
     */
    private void addToHead(Entry entry) {
        entry.pre = head;
        entry.next = head.next;
        head.next.pre = entry;
        head.next = entry;
    }

    private void moveToHead(Entry entry) {
        removeEntry(entry);
        addToHead(entry);
    }

    /**
     * 用于存储顺序的双向链表
     */
    static class Entry {
        int key, value;
        Entry pre, next;

        public Entry() {
        }

        public Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
