package com.leetcode.hot100.impl;

import com.leetcode.hot100.Solution;
import com.leetcode.util.ListNode;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class SolutionImpl implements Solution {

    /**
     * 题目1：两数之和
     */
    public int[] twoSum(int[] nums, int target) {
        // 1.暴力求解
//        for(int i = 0; i < nums.length; i++){
//            for(int j = i+1; j < nums.length; j++){
//                if(nums[i] + nums[j] == target){
//                    return new int[]{i,j};
//                }
//            }
//        }
//        return new int[0];
        // 2.哈希映射
        int len = nums.length;
        Map<Integer, Integer> hashTable = new HashMap<>();
        for(int i = 0; i < len; i++){
            if(hashTable.containsKey(target - nums[i])){
                return new int[] {i, hashTable.get(target - nums[i])};
            }
            hashTable.put(nums[i], i);
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
        //Map<Character, Integer> map = new HashMap();
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
     * 返回最长的子串
     * @param
     * @return
     */
/*    public String[] lengthOfLongestSubstringReturnString(String input) {
        //设置不重复字符集合
        Set<Character> charNotRepet = new HashSet<Character>();
        Set<String> strings = new HashSet<>();
        int n = input.length();
        //右指针-1未开始滑动,最大长度
        int rp = 0, length = 0;
        //左指针i
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < n; ++i){
            //下一个右指针不超出边界&&当前右指针不重复
            while(rp < n && !charNotRepet.contains(input.charAt(rp))){
                //不断右移指针，往集合添加字符
                charNotRepet.add(input.charAt(rp));
                //得到一个不重复串
                stringBuilder.append(input.charAt(rp));
                rp++;
            }
            //下一个右指针字符与左指针重复，剔除左指针元素
            charNotRepet.remove(input.charAt(i));
            //向list中添加最长字符串
            if (rp - i >= length){
                strings.add(stringBuilder.toString());
            }
            stringBuilder.deleteCharAt(0);
            length = Math.max(length,rp - i);
        }
        String[] ans = new String[strings.size()];
        int i = 0;
        for(String s:strings){
            if(s.length() == length){
                ans[i] = s;
                i++;
            }
        }
        return ans;
    }*/
    public String[] lengthOfLongestSubstringReturnString(String s) {
        //判断输入是否合法
        if(s == null || s.length() == 0){
            return new String[0];
        }
        //定义一个哈希表存储字符和对应的位置
        HashMap<Character,Integer> map = new HashMap<>();
        //定义最大长度和子串的起始位置
        Set<Integer> set = new HashSet<>();

        set.iterator().next();int x = 1;
        int max = 0;
        int start = 0;
        //定义一个ArrayList存储所有不重复子串
        ArrayList<String> list = new ArrayList<>();
        //遍历字符串
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            //如果字符已经在哈希表中出现过，并且出现的位置在当前子串的起始位置之后
            if(map.containsKey(c) && map.get(c) >= start){
                //更新子串的起始位置为重复字符的下一个位置
                start = map.get(c) + 1;
            }
            //否则更新最大长度和哈希表中字符的位置，并把对应的子串加入到list中
            //else{
                int cur = i - start + 1;
                if(cur > max){
                    list.clear();
                    max = cur;
                }
                if(cur == max){
                    list.add(s.substring(start,start+max));
                }
            //}
            map.put(c,i);
        }
        //遍历list中的每个子串
        for(int i = 0; i < list.size(); i++){
            //如果子串的长度不等于max
            if(list.get(i).length() != max){
                //从list中移除该子串
                list.remove(i);
                //更新索引值
                i--;
            }
        }
        //把list转换成数组并返回
        return list.toArray(new String[list.size()]);
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
        List<List<Integer>> lists = new ArrayList();
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
                    //lists.add(Arrays.asList(nums[left], nums[center], nums[right]));
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

    /**
     * 23. 合并K个升序链表Merge k Sorted Lists
     */
    @Override
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null){
            return null;
        }
        int len = lists.length;
        ListNode ans = null;
        for(int i = 0; i < len; i++){
            ans = merge2Lists(ans, lists[i]);
        }
        return ans;
    }
    private ListNode merge2Lists(ListNode a, ListNode b){
        if(a == null || b == null){
            return a != null ? a : b;
        }
        ListNode preHead = new ListNode(-1);
        ListNode tail = preHead;
        while(a != null && b != null){
            if(a.val < b.val){
                tail.next = a;
                a = a.next;
            }else {
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }
        tail.next = (a != null ? a : b);
        return preHead.next;
    }

    /**
     * 31. 下一个排列Next Permutation
     */
    @Override
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int temp = 0;
        for(int i = len - 1; i > 0; i--){   //从右往左找
            if(nums[i - 1] < nums[i]){      //找到最左边交换位置 i-1

            }
        }
        int i = len - 2;
        while(i >= 0 && nums[i] > nums[i + 1]){
            i--;
        }
        if(i >= 0){
            int j = len - 1;
            while(j >= 0 && nums[i] >= nums[j]){
                j--;
            }
            swap31(nums, i, j);
        }
        reverse31(nums, i+1);
    }
    private void swap31(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void reverse31(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap31(nums, left, right);
            left++;
            right--;
        }
    }

    /**
     *32. 最长有效括号
     *
     * 动态规划
     */
    @Override
    public int longestValidParentheses(String s) {
        int len = s.length();
        int maxAns = 0;
        int dp[] = new int[len];
        for(int i = 1; i < len; i++){
            if(s.charAt(i) == ')'){
                if(s.charAt(i - 1) == '('){
                    //对应情况(),()() ==> )
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if(i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '('){
                    //对应情况 (()),((())),(()()) ==> ))
                    dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] >= 2 ? dp[i -1 - dp[i-1] - 1] : 0);
                }
                maxAns = Math.max(maxAns, dp[i]);
            }
        }
        return maxAns;
    }

    /**
     * 33. 搜索旋转排序数组
     *    两种情况,目标值大于等于首元素,或者目标值小于首元素
     *       1.大于等于首元素,一直比较到旋转出
     *       2.小于,则从尾部开始比较
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int length = nums.length;
        if(length == 0){
            return -1;
        }
        if(length == 1){
            return nums[0] == target ? 0 : -1;
        }
        // 判断目标值是否大于等于nums[0]
        if(target >= nums[0]){
            for(int i = 0; i < length; i++){
                if(target == nums[i]){
                    return i;
                }
                if(nums[0] > nums[i]) return -1;
            }
        } else{
            for(int i = length - 1; i > -1; i--){
                if(target == nums[i]){
                    return i;
                }
                if(nums[i] > nums[length - 1]) return -1;
            }
        }
        return -1;
    }

    /**
     * 34. 在排序数组中查找元素的第一个和最后一个位置
     * 使用二分查找
     * @param nums
     * @param target
     * @return
     */
    @Override
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return new int[] {-1, -1};
        }
        int length = nums.length, left = 0, right = length - 1, min = -1, max = -1;
        if(target > nums[length - 1] || target < nums[0]) return new int[] {-1, -1};
        while(left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] < target){
                left = mid + 1;
            }else {
                min = mid;
                right = mid - 1;
            }
        }
        if(nums[min] != target) return new int[] {-1, -1};
        else {
            max = min;
            while(max < length){
                max++;
                if(max < length && nums[max] != target) break;
            }
        }
        return new int[] {min, max - 1};
    }

    /**
     * 39. 组合总和
     *
     *      回溯算法 + 剪枝
     *
     * @param candidates
     * @param target
     * @return
     */
    @Override
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if(len == 0){
            return  res;
        }
        // 排序,准备剪枝,无序的话剪枝时可能把减去了大的，而忽略了小的
        Arrays.sort(candidates);
        Deque<Integer> path = new ArrayDeque<>();
        combinationSumDfs(candidates, 0, len, target, path, res);
        return res;
    }
    /**
     * 深度优先算法
     * @param candidates    候选数组
     * @param begin         搜索起点
     * @param len           冗余变量，是 candidates 里的属性，可以不传
     * @param target        每减去一个元素，目标值变小
     * @param path          从根结点到叶子结点的路径，是一个栈
     * @param res           结果集列表
     */
    private void combinationSumDfs
            (int[] candidates, int begin, int len, int target, Deque<Integer> path, List<List<Integer>> res){
        if(target == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        // 从begin开始向下搜索,begin之前的是已经搜索的
        for(int i = begin; i < len; i++){
            if(target - candidates[i] < 0){
                return;
            }
            path.addLast(candidates[i]);
            combinationSumDfs(candidates, i, len, target - candidates[i], path, res);
            path.removeLast();
        }
    }

    /**
     * 42. 接雨水
     */
    @Override
    public int trap(int[] height) {
        // 动态规划,提前预存位置i处两边的最高点
/*        int sum = 0, len = height.length;
        if(len < 2){
            return sum;
        }
        int[] maxLeft = new int[len];
        int[] maxRight = new int[len];
        for(int i = 1; i < len - 1; i++){
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i - 1]);
            maxRight[len - 1 - i] = Math.max(maxRight[len - i], height[len - i]);
        }
        for(int i = 1; i < len -1; i++){
            int min = Math.min(maxLeft[i], maxRight[i]);
            if(min > height[i]){
                sum += min - height[i];
            }
        }
        return sum;*/

        // 栈,像存储括号一样存储,左右括号的距离就是存储的水
        // 左括号入栈,右括号为当前位置,用于判断与最近左括号的距离
        // 像右移动，记录当前最高点并入栈

        int sum = 0, len = height.length;
        if(len < 2){
            return sum;
        }
        Stack<Integer> stack = new Stack<>();
        int current = 0;
        while(current < len){
            //  若当前指针为符合要求的右括号,出栈(判断是否高于栈顶元素对应的高度)
            while(!stack.isEmpty() && height[current] > height[stack.peek()]){
                int h = height[stack.peek()];
                stack.pop();
                if(stack.isEmpty()){
                    break;
                }
                int distance = current - stack.peek() - 1;
                int min = Math.min(height[stack.peek()], height[current]);
                sum += distance * (min - h);
            }
            // 当前墙入栈
            stack.push(current);
            // 指针向后移动
            current++;
        }
        return sum;
    }
}