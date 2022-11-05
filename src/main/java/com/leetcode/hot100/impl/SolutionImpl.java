package com.leetcode.hot100.impl;

import com.leetcode.hot100.Solution;
import com.leetcode.util.ListNode;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class SolutionImpl implements Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[0];
    }

    @Override
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;
        while(l1 != null || l2 != null){
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if(head == null){
                head = tail = new ListNode(sum % 10);
            }else {
                tail.next= new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        if(carry != 0){
            tail.next = new ListNode(1);
        }
        return head;
    }

    /**
     * 设置滑动窗口，分为左右指针
     *      右指针不断往右滑动，遇到与左指针重复值，记录长度，左指针右滑
     *      重复上一步，比较长度大小，记录最大长度
     *      右指针到头，输出最大长度
     *
     * HashSet.add()        向集合添加元素
     * HashSet.remove()     移除元素
     * HashSet.contains()   是否含有该元素
     * String.charAt()      返回index位置字符
     */
    @Override
    public int lengthOfLongestSubstring(String s) {
        //设置不重复字符集合
        Set<Character> charNotRepet = new HashSet<Character>();
        int n = s.length();
        //右指针-1未开始滑动,最大长度
        int rp = -1, length = 0;
        //左指针i
        for(int i = 0; i < n; ++i){
            //下一个右指针不超出边界&&当前右指针不重复
            while(rp + 1 < n && !charNotRepet.contains(s.charAt(rp + 1))){
                //不断右移指针，往集合添加字符
                rp++;
                charNotRepet.add(s.charAt(rp));
            }
            //下一个右指针字符与左指针重复，剔除左指针元素
            charNotRepet.remove(s.charAt(i));
            length = Math.max(length,rp - i +1);
        }
        return length;
    }

    /**
     *  两个数组分别有一个指针
     *      1.比较指针元素大小
     *          取出小元素放入合并数组
     *          小元素指针右移
     *      2.重复1
     *      3.将剩余数组元素，全部装入
     *      4.找到中位数
     */
    @Override
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //数组指针
        int i = 0, j = 0, k = 0;
        int m = nums1.length, n = nums2.length;
        int length = m + n;
        int[] nums = new int[length];
        while(i < nums1.length && j < nums2.length){
            if(i < m && j < n && nums1[i] < nums2[j]){
                nums[k] = nums1[i];
                k++;i++;
            }
            if(i < m && j < n  && nums1[i] >= nums2[j]){
                nums[k] = nums2[j];
                k++;j++;
            }
        }
        if(i != m){
            do{
                nums[k] = nums1[i];
                k++;i++;
            }while(i != m && k <= length);
        }
        if(j != n){
            do{
                nums[k] = nums2[j];
                k++;j++;
            }while(j != n && k <= length);
        }
        //取中位数
        if(length %2 == 0){
            length--;
            return (double) (nums[length/2] + nums[length/2+1])/2;
        }else {
            length--;
            return (double)(nums[length/2]);
        }
    }

    /**
     * 中心扩展寻找回文串
     *  从字符串起始作为回文串中心，中心不断像末端移动，直到抵达边界，
     *  移动都尝试像两边扩展，若两边相同则继续扩展，扩展达到边界停止
     *      注意：目标串可能是奇串或者是偶串
     */
    @Override
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0){
            return "";
        }
        int start = 0, end = 0;
        for(int i = 0; i < s.length(); ++i){
            int len1 = expendCenter(s, i, i);
            int len2 = expendCenter(s, i, i+1);
            int len = Math.max(len1, len2);
            if(len > end - start){
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1); //裁剪末端这一位不算入
    }
    private int expendCenter(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right - left - 1;
    }
}
