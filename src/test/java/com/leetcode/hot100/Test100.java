package com.leetcode.hot100;

import com.leetcode.config.SpringConfig;
import com.leetcode.util.ListNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class Test100 {

    @Autowired
    private Solution solution;

    /**
     * 1.两数之和Two Sum
     */
    @Test
    public void problem001(){
        int res[];
        //test1
        int nums1[] = {2,7,11,15};
        int target1 = 9;
        res = solution.twoSum(nums1, target1);
        System.out.println("test1===>[" + res[0] +","+res[1] +"]");

        int nums2[] = {3,2,4};
        int target2 = 6;
        res = solution.twoSum(nums2, target2);
        System.out.println("test2===>[" + res[0] +","+res[1] +"]");

        int nums3[] = {3,3};
        int target3 = 6;
        res = solution.twoSum(nums3, target3);
        System.out.println("test3===>[" + res[0] +","+res[1] +"]");
    }

    /**
     * 2.两数相加Add Two Numbers
     */
    @Test
    public void problem002(){
        //test 1
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode res = solution.addTwoNumbers(l1,l2);
        while(res != null){
            System.out.print(res.val + "-->");
            res = res.next;
        }
        System.out.println();

        //test 2
        l1 = new ListNode(0);
        l2 = new ListNode(0);
        res = solution.addTwoNumbers(l1,l2);
        while(res != null){
            System.out.print(res.val + "-->");
            res = res.next;
        }
        System.out.println();

        //test 3
        l1 = new ListNode(9, new ListNode(9, new ListNode(9,new ListNode(9, new ListNode(9, new ListNode(9,new ListNode(9, new ListNode(9, new ListNode(9)))))))));
        l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        res = solution.addTwoNumbers(l1,l2);
        while(res != null){
            System.out.print(res.val + "-->");
            res = res.next;
        }
        System.out.println();
    }

    /**
     * 3.无重复字符的最长子串Longest Substring Without Repeating Characters
     */
    @Test
    public void problem003(){
        //示例1
        String s = "abcabcbb";
        int length = solution.lengthOfLongestSubstring(s);
        System.out.println("示例1：" + length);

        //示例2
        s = "bbbbb";
        length = solution.lengthOfLongestSubstring(s);
        System.out.println("示例2：" + length);

        //示例3
        s = "pwwkew";
        length = solution.lengthOfLongestSubstring(s);
        System.out.println("示例3：" + length);
    }

    /**
     * 4. 寻找两个正序数组的中位数Median of Two Sorted Arrays
     */
    @Test
    public void problem004(){
        //示例1
        int[] nums1 = {1,3}, nums2 = {2};
        double num = solution.findMedianSortedArrays(nums1, nums2);
        System.out.println("中位数1："+ num);

        //示例2
        nums1 = new int[]{1, 2};
        nums2 = new int[]{3, 4};
        num = solution.findMedianSortedArrays(nums1, nums2);
        System.out.println("中位数2："+ num);

        //示例3
        nums1 = new int[]{1, 2, 7, 11};
        nums2 = new int[]{3, 4, 12};
        num = solution.findMedianSortedArrays(nums1, nums2);
        System.out.println("中位数3："+ num);

        //示例
        nums1 = new int[]{1};
        nums2 = new int[]{3, 4};
        num = solution.findMedianSortedArrays(nums1, nums2);
        System.out.println("中位数4："+ num);
    }

    /**
     * 5. 最长回文子串Longest Palindromic Substring
     */
    @Test
    public void problem005(){
        //示例1
        String s = "babad";
        String longestPalindrome = solution.longestPalindrome(s);
        System.out.println("最长回文子串：" + longestPalindrome);

        //示例2
        s = "cbbd";
        longestPalindrome = solution.longestPalindrome(s);
        System.out.println("最长回文子串：" + longestPalindrome);

        //示例3
        s = "asdzxxzcacdyxqwqxydcaadasda";
        longestPalindrome = solution.longestPalindrome(s);
        System.out.println("最长回文子串：" + longestPalindrome);

        //示例4
        s = "iwdfgnxaxaxngfdwiasdfa";
        longestPalindrome = solution.longestPalindrome(s);
        System.out.println("最长回文子串：" + longestPalindrome);
    }

    /**
     * 11. 盛最多水的容器Container With Most Water
     */
    @Test
    public void problem011(){
        //示例1
        int[] height1 = {1,8,6,2,5,4,8,3,7};
        int maxArea = solution.maxArea(height1);
        System.out.println("最大容器容积为：" + maxArea);

        //示例1
        int[] height2 = {1,1};
        maxArea = solution.maxArea(height2);
        System.out.println("最大容器容积为：" + maxArea);

        //示例3
        int[] height3 = {1,8,6,2,5,4,8,3,7,10,24,9,10,22};
        maxArea = solution.maxArea(height3);
        System.out.println("最大容器容积为：" + maxArea);

        //示例4
        int[] height4 = {2000,2000,6,2,5,4,8,3,50};
        maxArea = solution.maxArea(height4);
        System.out.println("最大容器容积为：" + maxArea);
    }

    /**
     *  15. 三数之和3Sum
     */
    @Test
    public void problem015(){
        //示例1
        int[] nums1 = {-1,0,1,2,-1,-4};
        List<List<Integer>> res = solution.threeSum(nums1);
        System.out.println("不重复三元组==>" + res);
        //示例2
        int[] nums2 = {0,1,1};
        res = solution.threeSum(nums2);
        System.out.println("不重复三元组==>" + res);
        //示例3
        int[] nums3 = {0,0,0};
        res = solution.threeSum(nums3);
        System.out.println("不重复三元组==>" + res);
    }

    /**
     * 17. 电话号码的字母组合Letter Combinations of a Phone Number
     */
    @Test
    public void problem017(){
        //示例1
        String digits = "23";
        List<String> strings = solution.letterCombinations(digits);
        System.out.println("电话号码的字母组合==>" + strings);

        //示例2
        digits = "";
        strings = solution.letterCombinations(digits);
        System.out.println("电话号码的字母组合==>" + strings);

        //示例3
        digits = "2";
        strings = solution.letterCombinations(digits);
        System.out.println("电话号码的字母组合==>" + strings);
    }

    /**
     * 19. 删除链表的倒数第 N 个结点Remove Nth Node From End of List
     */
    @Test
    public void problem019(){
        //示例1
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3,
                new ListNode(4, new ListNode(5)))));
        int n = 2;
        ListNode res = solution.removeNthFromEnd(head, n);
        while(res != null){
            System.out.print(res.val + "==>");
            res = res.next;
        }
        System.out.println();
        //示例2
        head = new ListNode(1);
        n = 1;
        res = solution.removeNthFromEnd(head, n);
        while(res != null){
            System.out.print(res.val + "==>");
            res = res.next;
        }
        System.out.println();
        //示例3
        head = new ListNode(1, new ListNode(2));
        n = 1;
        res = solution.removeNthFromEnd(head, n);
        while(res != null){
            System.out.print(res.val + "==>");
            res = res.next;
        }
    }

    /**
     * 20. 有效的括号Valid Parentheses
     */
    @Test
    public void problem020(){
        //示例
        String s = "()";
        boolean res = solution.isValid(s);
        System.out.println(res);
        //示例
        s = "()[]{}";
        res = solution.isValid(s);
        System.out.println(res);
        //示例
        s = "(]";
        res = solution.isValid(s);
        System.out.println(res);
    }

    /**
     * 21. 合并两个有序链表Merge Two Sorted Lists
     */
    @Test
    public void problem021(){
        //示例1
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode listNode = solution.mergeTwoLists(l1, l2);
        while(listNode != null){
            System.out.print(listNode.val + "==>");
            listNode = listNode.next;
        }
        System.out.println();
        //示例2
        l1 = null;
        l2 = null;
        listNode = solution.mergeTwoLists(l1, l2);
        while(listNode != null){
            System.out.print(listNode.val + "==>");
            listNode = listNode.next;
        }
        System.out.println();
        //示例3
        l1 = null;
        l2 = new ListNode(0);
        listNode = solution.mergeTwoLists(l1, l2);
        while(listNode != null){
            System.out.print(listNode.val + "==>");
            listNode = listNode.next;
        }
        System.out.println();
    }

    /**
     *22. 括号生成 Generate Parentheses
     */
    @Test
    public void problem022(){
        //示例1
        int n = 3;
        List<String> strings = solution.generateParenthesis(n);
        System.out.println("[\"((()))\",\"(()())\",\"(())()\",\"()(())\",\"()()()\"]" + "<==>" + strings);

        //示例2
        n = 1;
        strings = solution.generateParenthesis(n);
        System.out.println("[\"()\"]" + "<==>" + strings);
    }
}
