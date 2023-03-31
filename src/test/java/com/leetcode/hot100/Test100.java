package com.leetcode.hot100;

import com.leetcode.config.SpringConfig;
import com.leetcode.util.ListNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
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

        //示例4
        s = "abcdefcwvuxyz";
        length = solution.lengthOfLongestSubstring(s);
        System.out.println("示例4：" + length);
    }
    @Test
    public void problem003_1(){
        //示例1
        String s = "abcabcbb";
        String[] strings = solution.lengthOfLongestSubstringReturnString(s);
        System.out.println("预期:" + "abc,bca,cab,abc,");
        for(String s1:strings){
            System.out.print(s1+",");
        }

        //示例2
        s = "bbbbb";
        strings = solution.lengthOfLongestSubstringReturnString(s);
        System.out.println("预期:" + "b,");
        for(String s1:strings){
            System.out.print(s1+",");
        }

        //示例3
        s = "pwwkew";
        strings = solution.lengthOfLongestSubstringReturnString(s);
        System.out.println();
        for(String s1:strings){
            System.out.print(s1+",");
        }

        //示例4
        s = "abcdefcwvuxyz";
        strings = solution.lengthOfLongestSubstringReturnString(s);
        System.out.println();
        for(String s1:strings){
            System.out.print(s1+",");
        }
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

    /**
     * 23. 合并K个升序链表Merge k Sorted Lists
     */
    @Test
    public void problem023(){
        //示例1
        ListNode[] lists1 = {new ListNode(1, new ListNode(4, new ListNode(5))),
                new ListNode(1, new ListNode(3, new ListNode(4))),
                new ListNode(2, new ListNode(6))};
        ListNode listNode = solution.mergeKLists(lists1);
        while(listNode != null){
            System.out.print("==>" + listNode.val);
            listNode = listNode.next;
        }
        System.out.println();

        //示例2
        ListNode[] lists2 = null;
        listNode = solution.mergeKLists(lists2);
        while(listNode != null){
            System.out.print("==>" + listNode.val);
            listNode = listNode.next;
        }
        System.out.println();

        //示例3
        ListNode[] lists3 = {null};
        listNode = solution.mergeKLists(lists3);
        while(listNode != null){
            System.out.print("==>" + listNode.val);
            listNode = listNode.next;
        }
        System.out.println();
    }

    /**
     * 31. 下一个排列Next Permutation
     */
    @Test
    public void problem031(){
        //示例1
        int[] nums1 = {1, 2, 3};
        solution.nextPermutation(nums1);
        System.out.print("预期：132结果：");
        for(int i = 0; i < nums1.length; i++){
            System.out.print(nums1[i]);
        }
        System.out.println();

        //示例2
        int[] nums2 = {3, 2, 1};
        solution.nextPermutation(nums2);
        System.out.print("预期：123结果：");
        for(int i = 0; i < nums2.length; i++){
            System.out.print(nums2[i]);
        }
        System.out.println();

        //示例3
        int[] nums3 = {1, 1, 5};
        solution.nextPermutation(nums3);
        System.out.print("预期：151结果：");
        for(int i = 0; i < nums3.length; i++){
            System.out.print(nums3[i]);
        }
        System.out.println();

        //示例4
        int[] nums4 = {1, 3, 2};
        solution.nextPermutation(nums4);
        System.out.print("预期：213结果：");
        for(int i = 0; i < nums4.length; i++){
            System.out.print(nums4[i]);
        }
        System.out.println();

        //示例5
        int[] nums5 = {2, 3, 1};
        solution.nextPermutation(nums5);
        System.out.print("预期：312结果：");
        for(int i = 0; i < nums5.length; i++){
            System.out.print(nums5[i]);
        }
        System.out.println();
    }

    //32. 最长有效括号
    @Test
    public void problem032(){
        //示例1
        String s = "(()";
        int i = solution.longestValidParentheses(s);
        System.out.println("预期结果：2，实际结果：" + i);

        //示例2
        s = ")()())";
        i = solution.longestValidParentheses(s);
        System.out.println("预期结果：4，实际结果：" + i);

        //示例3
        s = "";
        i = solution.longestValidParentheses(s);
        System.out.println("预期结果：0，实际结果：" + i);
    }

    //33. 搜索旋转排序数组
    @Test
    public void problem033(){
        // 示例1  nums = [4,5,6,7,0,1,2], target = 0
        int[] nums = {4,5,6,7,0,1,2}; int target = 0, result = 4;
        int search = solution.search(nums, target);
        System.out.println("预期结果：" + result + "，实际结果：" + search);

        // 示例2  nums = [4,5,6,7,0,1,2], target = 3
        target = 3; result = -1;
        search = solution.search(nums, target);
        System.out.println("预期结果：" + result + "，实际结果：" + search);
    }

    //34. 在排序数组中查找元素的第一个和最后一个位置
    @Test
    public void problem034(){
        //示例 1：输入：nums = [5,7,7,8,8,10], target = 8; 输出：[3,4]
        int[] nums1 = {5,7,7,8,8,10};
        int target = 8;
        int[] result1 = solution.searchRange(nums1, target);
        System.out.println("预期结果：[3,4]，实际结果：" + Arrays.toString(result1));
        //示例 2：输入：nums = [5,7,7,8,8,10], target = 6; 输出：[-1,-1]
        int[] nums2 = {5,7,7,8,8,10};
        target = 6;
        int[] result2 = solution.searchRange(nums1, target);
        System.out.println("预期结果：[-1,-1]，实际结果：" + Arrays.toString(result2));
        //示例 3：输入：nums = [], target = 0; 输出：[-1,-1]
        int[] nums3 = {};
        target = 0;
        int[] result3 = solution.searchRange(nums1, target);
        System.out.println("预期结果：[-1,-1]，实际结果：" + Arrays.toString(result3));
    }

    @Test
    public void problem039(){
        // 示例1 输入：candidates = [2,3,6,7], target = 7;输出：[[2,2,3],[7]]
        int[] candidates1 = {2,3,6,7};
        int target = 7;
        List<List<Integer>> lists1 = solution.combinationSum(candidates1, target);
        System.out.println("预期结果：[[2,2,3],[7]]，实际结果：" + lists1.toString());

        //示例 2：输入: candidates = [2,3,5], target = 8;输出: [[2,2,2,2],[2,3,3],[3,5]]
        int[] candidates2 = {2,3,5};
        target = 8;
        List<List<Integer>> lists2 = solution.combinationSum(candidates2, target);
        System.out.println("预期结果：[[2,2,2,2],[2,3,3],[3,5]]，实际结果：" + lists2.toString());
        //示例 3：输入: candidates = [2], target = 1 ;输出: []
        int[] candidates3 = {2};
        target = 1;
        List<List<Integer>> lists3 = solution.combinationSum(candidates3, target);
        System.out.println("预期结果：[]，实际结果：" + lists3.toString());
    }

    @Test
    public void problem042(){
        // 示例1: 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]; 输出：6
//        int[] height1 = {0,1,0,2,1,0,1,3,2,1,2,1};
//        int res = solution.trap(height1);
//        System.out.println("预期结果：6，实际结果：" + res);

        // 示例2: 输入：height = [4,2,0,3,2,5]; 输出：9
        int[] height2 = {4,2,0,3,2,5};
        int res = solution.trap(height2);
        System.out.println("预期结果：9，实际结果：" + res);
    }

}
