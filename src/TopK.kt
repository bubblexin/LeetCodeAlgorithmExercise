import java.util.*
import kotlin.Comparator

/**
 * TopK 问题
 * 经典解法是可以用堆（优先队列）来解决，时间复杂度 O(nlogk)
 *
 * 求 Top K 最大值用小顶堆
 * 求 Top K 最小值用大顶堆
 * Java 中带的 PriorityQueue 默认是小顶堆，如要使用大顶堆，需要在构建时为其传入一个 Comparator 对象，返回第二个数减第一个数，让其变为大顶堆
 */
class TopK {
    // 寻找数组中最大的三个数
    fun test(a: IntArray, k: Int): IntArray {
        if (a.size == k) {
            return a
        }
        Arrays.sort(a)
        return a.copyOfRange(a.size - k, a.size)
    }

    fun test2(arr: IntArray, k: Int): IntArray {
        if (arr.size == k) {
            return arr
        }
        val queue = PriorityQueue<Int>(k)
        for (index in arr.indices) {
            if (index < k) {
                queue.offer(arr[index])
            } else if (arr[index] > queue.peek()) {
                queue.poll()
                queue.offer(arr[index])
            }
        }
        var j = 0
        val result = IntArray(k)
        queue.forEach {
            result[j++] = it
        }
        return result
    }

    /**
     * topK 小的数
     */
    fun test3(arr: IntArray, k: Int): IntArray {
        if (arr.size == k) return arr
        val queue = PriorityQueue<Int>(k) { o1, o2 ->
            o2 - o1
        }

        for (index in arr.indices) {
            if (index < k) {
                queue.offer(arr[index])
            } else if (arr[index] < queue.peek()) {
                queue.poll()
                queue.offer(arr[index])
            }
        }

        var j = 0
        var result = IntArray(k)
        queue.forEach {
            result[j++] = it
        }
        return result
    }
}