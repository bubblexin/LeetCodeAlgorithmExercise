import leetcode.Solution153;
import leetcode.Solution3;

import leetcode.Solution7;
import leetcode.bean.ListNode;
import leetcode.offer.Offer25;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

import static leetcode.Utils.Utils.printListNode;
import static leetcode.Utils.Utils.productListNode;


public class Main {
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(new Solution1().twoSum2(new int[]{3, 2, 4}, 6)));
//        new Solution2().addTwoNumbers()
//        System.out.println(new Solution3().lengthOfLongestSubstring("pwwkew"));
//        System.out.println(new Solution7().reverse(-123));

//        printListNode(new Offer25().mergeTwoLists(productListNode(new int[]{1, 2, 4}), productListNode(new int[]{1, 3, 4})));
        System.out.println(new Solution153().findMin(new int[]{3,4, 5, 1, 2}));
    }

}
