package com.leetcode.hot100;


import com.leetcode.util.ListNode;

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

    }
