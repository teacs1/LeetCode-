# LeetCode-Hot100-Test
目前有力扣上热门一百的部分测试用例，以及部分解法
更方便书写一些

## 目录结构
![image](https://user-images.githubusercontent.com/44944681/201463356-6c42d31b-aced-4966-a16f-a61b8aed919d.png)
![image](https://user-images.githubusercontent.com/44944681/201462624-617d9c19-c8a5-46fe-ae95-ad5f45ee8f0b.png)
## 示例
测试文件Test100.java
``` java
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
```
接口Solution.java
``` java
    /**
     * 题目1：两数之和
     */
    public int[] twoSum(int[] nums, int target);
```
实现SolutionImpl.java
``` java
    /**
     * 题目1：两数之和
     */
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
```
