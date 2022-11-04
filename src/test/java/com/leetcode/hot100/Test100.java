package com.leetcode.hot100;

import com.leetcode.config.SpringConfig;
import com.leetcode.util.ListNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class Test100 {

    @Autowired
    private Solution solution;

    /**
     * 1.两数之和
     */
    @Test
    public void problem1(){
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
     * 2.两数相加
     */
    @Test
    public void problem2(){
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
     * 3.无重复字符的最长子串
     */
    @Test
    public void problem3(){
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
     * 4. 寻找两个正序数组的中位数
     */
    @Test
    public void problem4(){
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
}
