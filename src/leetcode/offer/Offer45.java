package leetcode.offer;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 45. 把数组排成最小的数
 * https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/
 * <p>
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [10,2]
 * 输出: "102"
 * 示例2:
 * <p>
 * 输入: [3,30,34,5,9]
 * 输出: "3033459"
 * <p>
 * 提示:
 * <p>
 * 0 < nums.length <= 100
 * 说明:
 * <p>
 * 输出结果可能非常大，所以你需要返回一个字符串而不是整数
 * 拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0
 *
 * 题解：
 * 将数组转为 String 类型的数组，则对应的每两个相邻元素的 + 操作得出的字符串可以得出如下公式：
 * x + y > y + x 则 x > y，交换 xy 的位置，如 “3” + “30” = "330" > "30" + "3" = "303"
 */
public class Offer45 {
    public String minNumber(int[] nums) {
        // 将数组元素拼接成字符串数组
        String[] str = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            str[i] = String.valueOf(nums[i]);
        }

        // 冒泡排序（也可以用别的排序）
        for (int i = 0; i < str.length; i++) {
            boolean flag = true;
            for (int j = 0; j < str.length - 1 - i; j++) {
                // 前边拼接的和大于参数
                if ((str[j] + str[j + 1]).compareTo(str[j + 1] + str[j]) >= 0) {
                    String temp = str[j];
                    str[j] = str[j + 1];
                    str[j + 1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }

        // 拼接数组中内容，输出
        StringBuilder builder = new StringBuilder();
        for (String s : str) {
            builder.append(s);
        }
        return builder.toString();
    }

    public String minNumber2(int[] nums) {
        // 将数组元素拼接成字符串数组
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }

        // 使用 Arrays 的 sort 方法，传入一个自定义 Comparator 对象，返回比较规则
        Arrays.sort(strs, (o1, o2) -> (o1 + o2).compareTo(o2 + o1));

        // 拼接数组中内容，输出
        StringBuilder builder = new StringBuilder();
        for (String s : strs) {
            builder.append(s);
        }
        return builder.toString();
    }

    public String minNumber3(int[] nums) {
        // 将数组元素拼接成字符串数组
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }

        // 快排
        fastSort();

        // 拼接数组中内容，输出
        StringBuilder builder = new StringBuilder();
        for (String s : strs) {
            builder.append(s);
        }
        return builder.toString();
    }

    private void fastSort() {

    }
}
