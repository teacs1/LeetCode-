package com.leetcode.hot100;


import com.leetcode.util.ListNode;

import java.util.List;

public interface Solution {
    /**
     * 题目1：两数之和
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target);

    /**
     * 题目2：两数相加
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2);

    /**
     * 题目3：无重复字符串的最长子串
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s);

    /**
     * 题目4. 寻找两个正序数组的中位数
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2);

    /**
     * 题目5. 最长回文子串
     * @param s
     * @return
     */
    public String longestPalindrome(String s);

    /**
     * 11. 盛最多水的容器 Container With Most Water
     * @param height
     * @return
     */
    int maxArea(int[] height);

    /**
     *  15. 三数之和3Sum
     */
    public List<List<Integer>> threeSum(int[] nums);

    /**
     * 17. 电话号码的字母组合Letter Combinations of a Phone Number
     */
    public List<String> letterCombinations(String digits);

    /**
     * 19. 删除链表的倒数第 N 个结点Remove Nth Node From End of List
     */
    public ListNode removeNthFromEnd(ListNode head, int n);

    /**
     * 20. 有效的括号Valid Parentheses
     */
    public boolean isValid(String s);

    /**
     * 21. 合并两个有序链表Merge Two Sorted Lists
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2);

    /**
     *22. 括号生成 Generate Parentheses
     */
    public List<String> generateParenthesis(int n);

    /**
     * 23. 合并K个升序链表Merge k Sorted Lists
     */
    public ListNode mergeKLists(ListNode[] lists);

    /**
     * 31. 下一个排列Next Permutation
     */
    public void nextPermutation(int[] nums);
}
