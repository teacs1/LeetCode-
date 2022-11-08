package com.leetcode.hot100.impl;

import com.leetcode.hot100.Solution;
import com.leetcode.util.ListNode;
import org.springframework.stereotype.Component;

import java.util.*;

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

    /**
     * 用双指针作为边界计算最大容积
     * @param height
     * @return
     */
    @Override
    public int maxArea(int[] height) {
        if (height == null) {
            return 0;
        }
        int left = 0, len = height.length, right = len - 1;
        int maxArea = 0;
        while(left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(area, maxArea);
            if(height[left] < height[right]){
                ++left;
            }else {
                --right;
            }
        }
        return maxArea;
    }

    /**
     * 1.特判，对于数组长度 n，如果数组为 null 或者数组长度小于 3，返回[]。
     * 2.对数组进行排序。
     * 3.遍历排序后数组：
     *      若 nums[i]>0：因为已经排序好，所以后面不可能有三个数加和等于 00，直接返回结果。
     *      对于重复元素：跳过，避免出现重复解
     *      令左指针 L=i+1，右指针 R=n-1，当 L<R时，执行循环：
     *          当 nums[i]+nums[L]+nums[R]==0，执行循环，判断左界和右界是否和下一位置重复，去除重复解。并同时将 L,R 移到下一位置，寻找新的解
     *          若和大于0，说明 nums[R]太大，R 左移
     *          若和小于0，说明 nums[L]太小，L 右移
     */
    @Override
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        int len = nums.length;
        for(int left = 0; left < len; ++left){
            if(nums[left] > 0){
                return lists;
            }
            if(left > 0 && nums[left - 1] == nums[left]){
                continue;
            }
            int center = left + 1, right = len - 1;
            while (center < right) {
                int temp = nums[left] + nums[center] + nums[right];
                if(temp == 0){
                    List<Integer> integers = new ArrayList<>();
                    integers.add(nums[left]);
                    integers.add(nums[center]);
                    integers.add(nums[right]);
                    lists.add(integers);
                    while(center < right && nums[center + 1] == nums[center]){
                        ++center;
                    }
                    while(center < right && nums[right - 1] == nums[right]){
                        --right;
                    }
                    ++center;
                    --right;
                }else if(temp < 0){
                    ++center;
                }else{
                    --right;
                }
            }
        }
        return lists;
    }

    /**
     *17. 电话号码的字母组合Letter Combinations of a Phone Number
     * @param digits
     * @return
     */
    @Override
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<String>();
        if (digits.length() == 0) {
            return combinations;
        }
        Map<Character, String> phoneMap = new HashMap<>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
        return combinations;
    }
    private void backtrack(List<String> combinations, Map<Character, String> phoneMap,
                           String digits, int index, StringBuffer combination){
        if(index == digits.length()){
            combinations.add(combination.toString());
        }else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int length = letters.length();
            for(int i = 0; i < length; ++i){
                combination.append(letters.charAt(i));
                backtrack(combinations, phoneMap, digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }
    }

    /**
     * 19. 删除链表的倒数第 N 个结点Remove Nth Node From End of List
     * 分析，删除倒数第n个节点，主要问题是不知道有多少个节点
     *      遍历一遍获得节点数量，以便找到要删除的节点
     */
    @Override
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tail = head;
        int len = 0;
        while(tail != null){
            tail = tail.next;
            len++;
        }
        if(len == n){
            head = head.next;
            return head;
        }
        tail = head;
        int index = len - n;
        while(index > 0){
            if(index == 1){
                tail.next = tail.next.next;
            }
            tail = tail.next;
            index--;
        }
        return head;
    }

    /**
     * 20. 有效的括号Valid Parentheses
     */
    @Override
    public boolean isValid(String s) {
        int n = s.length();
        if(n % 2 == 1){
            return false;
        }
        Map<Character, Character> pairs = new HashMap<>();
        pairs.put(')', '(');
        pairs.put(']', '[');
        pairs.put('}', '{');
        Deque<Character> stack = new LinkedList<>();
        for(int i = 0; i < n; ++i){
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                if(stack.isEmpty() || stack.peek() != pairs.get(ch)){
                    return false;
                }
                stack.pop();
            }else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }

    /**
     * 21. 合并两个有序链表Merge Two Sorted Lists
     */
    @Override
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode preHead = new ListNode(-1);
        ListNode tail = preHead;

        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                tail.next = list1;
                list1 = list1.next;
            }else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        tail.next = list1 == null ? list2 :list1;
        return preHead.next;
    }

    /**
     *22. 括号生成 Generate Parentheses
     * 做法：括号当作一个整体，不断进行插入n对
     */
    @Override
    public List<String> generateParenthesis(int n) {
        if(n == 1){
            return Arrays.asList("()");
        }
        Set<String> set = new HashSet<>();
        for(String str : generateParenthesis(n - 1)){
            for(int i = 0; i <= str.length() / 2; ++i){
                set.add(str.substring(0, i) + "()" + str.substring(i, str.length()));
            }
        }
        return new ArrayList<>(set);
    }
}