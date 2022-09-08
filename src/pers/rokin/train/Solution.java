package pers.rokin.train;

import java.util.*;
import java.util.stream.IntStream;

import static jdk.nashorn.internal.runtime.JSType.isNumber;

class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static void main(String[] args) {
        int [][] envelopes = {{5,4},{6,4},{6,7},{2,3}};
        int [] test = {3,5,1,6,2,5};
        Arrays.sort(test,1,4);
//        maxEnvelopes(envelopes);

        int [] ints = {-1,-1,-1,1,1,1};
        int [] moveZeroesiii = {0,1,0,3,1};
//        search(ints,5);
//        searchInsert(ints,5);

//        rotate(ints,3);

//        pivotIndex(ints);

//        isIsomorphic("bbbaaaba","aaabbbba");

//        isSubsequence("abc","ahbgdc");

//        moveZeroes(moveZeroesiii);
        int [] twoSumo = {0,0,3,4};
//        twoSum(twoSumo,0);

        char [] chars = {'a','b','c'};
//        reverseString(chars);
        String s = "asdasda";
        String[] s1 = s.split(" ");

//        reverseWords("abc asd fgdsg");

        int [] averagei = {4000,3000,1000,2000};
//        double average = average(averagei);

        int i = 00000000000000000000000010000000;
//        hammingWeight(i);

        int subtractProductAndSumi = 213213;
//        subtractProductAndSum(subtractProductAndSumi);

        int [][] nearestValidPointi = {{1,2},{3,1},{2,4},{2,3},{4,4}};
//        nearestValidPoint(3,4,nearestValidPointi);

        int [] iarraySign = {41,65,14,80,20,10,55,58,24,56,28,86,96,10,3,84,4,41,13,32,42,43,83,78,82,70,15,-41};
//        arraySign(iarraySign);

        int [] imaxProfit = {2,4,1};
//        maxProfit(imaxProfit);

        int [][] imaximumWealth = {{1,2,3},{3,2,1}};
//        maximumWealth(imaximumWealth);

        int [][] iorangesRotting = {{2,1,1},{1,1,0},{0,1,1}};
//        orangesRotting(iorangesRotting);

        char [][] inumIslands = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
//        numIslands(inumIslands);

        int [][] idiagonalSum = {{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1}};
//        diagonalSum(idiagonalSum);
        int [][] imatrixReshape = {{1,2},{3,4}};
//        matrixReshape(imatrixReshape,2,4);

        int [] ipermute = {1,2,3};
//        permute(ipermute);

//        fib(3);
//        mergeAlternately("ab","pqrs");

//        uniquePaths(3,7);
//        findAnagrams("abcsadsadgghfdhabccba","abc");

//        characterReplacement("AABAACDSGASZSF",2);
//        int [] irob = {2,2,3,1,1};
//        rob(irob);
//        isAnagram("anagram","nagaram");

        int [] itwosSum = {3,2,4};
//        twosSum(itwosSum,6);

//        backspaceCompare("ac#b","as#b");
        int [] isearchRange = {5,7,7,8,8,10};
//        searchRange(isearchRange,8);

        int [][] isearchMatrix = {{1},{3}};
//        searchMatrix(isearchMatrix,3);

        int [] ithreeSum = {-1,0,1,2-1,-4};
//        threeSum(ithreeSum);

        int [] imaxArea = {1,8,6,2,5,4,8,3,7};
//        maxArea(imaxArea);

        addBinary("1011","100011");

    }
    /**
     * 给你一个二维整数数组 envelopes ，其中 envelopes[i] = [wi, hi] ，表示第 i 个信封的宽度和高度。
     * 当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
     * 请计算 最多能有多少个 信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
     * 注意：不允许旋转信封。
     */
    public static int maxEnvelopes(int[][] envelopes) {
        int length = envelopes.length;
        if(length == 0)
            return 0;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] != o2[0]){
                    return o1[0]-o2[0];
                }else{
                    return o2[1]-o1[1];
                }
            }
        });
        int [] temp = new int [length];
        int ans = 1;
        Arrays.fill(temp,1);
        for (int i = 1; i<length; i++){
            for (int j = 0; j<i; j++){
                if(envelopes[j][1]<envelopes[i][1]){
                    temp[i] = Math.max(temp[i], temp[j] + 1);
                }
            }
            ans = Math.max(ans,temp[i]);
        }
        return ans;
    }
    /*给定一个n个元素有序的（升序）整型数组nums 和一个目标值target ，写一个函数搜索nums中的 target，如果目标值存在返回下标，否则返回 -1。*/
    public static int search(int[] nums, int target) {
        int length = nums.length;
        if(length <= 2){
            for(int i = 0; i<length; i++){
                if(nums[i] == target)
                    return i;
            }
            return -1;
        }
        Arrays.sort(nums);
        int left = 0;
        int right = length-1;
        while(left <= right){
            int min = left + (right-left)/2;
            if(nums[min] == target){
                return min;
            }
            if(nums[min]<target){
                left = min+1;
            }
            if(nums[min]>target){
                right = min-1;
            }
        }
        return -1;
    }
    /*给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。 */
    public static int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int l=0,r=n-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(nums[mid]<target)
                l=mid+1;
            else r=mid-1;
        }
        return l;
    }
    /*给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。*/
    public int[] sortedSquares(int[] nums) {
        int [] newnums = new int [nums.length];
        for(int i = 0; i<nums.length; i++){
            newnums[i] = (int) Math.pow(nums[i],2);
        }
        Arrays.sort(newnums);
        return newnums;
    }
    /*给你一个数组，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。     */
    public static void rotate(int[] nums, int k) {
        int index = k%nums.length;
        int [] newnums = new int [nums.length];
        for (int i = 0; i<nums.length; i++){
            newnums[index] = nums[i];
            index++;
            if(index == nums.length)
                index = 0;
        }
        System.arraycopy(newnums,0,nums,0,newnums.length);
    }
    /*给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。请返回 nums 的动态和。*/
    public int[] runningSum(int[] nums) {
        int [] sum = new int [nums.length];
        int temp = 0;
        for (int i = 0; i<nums.length; i++){
            temp += nums[i];
            sum[i] = temp;
        }
        return sum;
    }
    /*给你一个整数数组nums ，请计算数组的 中心下标 。数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
    如果中心下标位于数组最左端，那么左侧数之和视为 0 ，因为在下标的左侧不存在元素。这一点对于中心下标位于数组最右端同样适用。
    如果数组有多个中心下标，应该返回 最靠近左边 的那一个。如果数组不存在中心下标，返回 -1 。*/
    public static int pivotIndex(int[] nums) {
        int left = 0;
        int right = 0;
        for (int i = 0; i<nums.length; i++){
            right += nums[i];
        }
        int index = 0;
        for (int i = 0; i<nums.length; i++){
            right -= nums[index];
            if(left == right){
                break;
            }
            left += nums[index];
            index++;

            if(index == nums.length-1){
                right = 0;
                break;
            }
        }

        return left == right ? index:-1;
    }
    /*给定两个字符串s和t，判断它们是否是同构的。
    如果s中的字符可以按某种映射关系替换得到t，那么这两个字符串是同构的。
    每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。*/
    public static boolean isIsomorphic(String s, String t) {
        HashMap<Character, Integer> shm = new HashMap<>();
        HashMap<Character, Integer> thm = new HashMap<>();
        String sStr = "";
        String tStr = "";
        Integer snum = 0;
        Integer tnum = 0;
        if(s.length() != t.length())
            return false;
        for (int i = 0; i<s.length(); i++){
            Integer shmvalues = shm.get(s.charAt(i));
            if(shmvalues == null){
                snum++;
                shm.put(s.charAt(i),snum);
                sStr += snum;
            }else{
                Integer svalue = shm.get(s.charAt(i));
                sStr += svalue;
            }

            Integer thmvalues = thm.get(t.charAt(i));
            if(thmvalues == null){
                tnum++;
                thm.put(t.charAt(i),tnum);
                tStr += tnum;
            }else{
                Integer tvalue = thm.get(t.charAt(i));
                tStr += tvalue;
            }
        }
        boolean falg = sStr.equals(tStr);
        return falg;
    }
    /*给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
    字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。*/
    public static boolean isSubsequence(String s, String t) {
        String target = "";
        boolean falg = true;
        if(s.length() == 0)
            return falg;
        int index = 0;
            for (int j = 0; j<t.length(); j++){
                char c = s.charAt(index);
                if(t.charAt(j) == c){
                    target += c;
                    if(index == s.length()-1)
                        break;
                    index++;
                }
            }
        return target.equals(s);
    }
    /*给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
    请注意 ，必须在不复制数组的情况下原地对数组进行操作。*/
    public static void moveZeroes(int[] nums) {
        int index = 0;
        int zero = 0;
        for(int i = 0; i<nums.length; i++){
            if(nums[i] != 0){
                nums[index] = nums[i];
                index++;
            }else{
                zero++;
            }
        }
        for (int i = 0; i<zero; i++){
            nums[nums.length-1-i] = 0;
        }
    }

    /*给你一个下标从 1 开始的整数数组numbers ，该数组已按 非递减顺序排列 ，请你从数组中找出满足相加之和等于目标数target 的两个数。
    如果设这两个数分别是 numbers[index1] 和 numbers[index2] ，则 1 <= index1 < index2 <= numbers.length 。
以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。
你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。你所设计的解决方案必须只使用常量级的额外空间。*/
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum < target) {
                i++;
            } else if (sum > target) {
                j--;
            } else {
                return new int[]{i+1, j+1};
            }
        }
        return new int[]{-1, -1};
    }
    /*编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。*/
    public static void reverseString(char[] s) {
        for(int left = 0, right = s.length-1; left <right; left++,right--){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
        }
        System.out.println(s);
    }
    /*给定一个字符串 s ，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。*/
    public static String reverseWords(String s) {
        String[] s1 = s.split(" ");
        String result = "";
        for (int i = 0; i<s1.length; i++){
            StringBuilder sb = new StringBuilder(s1[i]);
            sb.reverse();
            result += sb ;
            if(i != s1.length-1)
                result += " ";
        }
        return result;
    }
    /*将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。*/
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        else if (l2 == null) {
            return l1;
        }
        else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
    /*给你两个非负整数 low 和 high 。请你返回 low 和 high 之间（包括二者）奇数的数目。*/
    public int countOdds(int low, int high) {
        if (high % 2 == 1 ) {
            high++;
        }
        return (high - low + 1) / 2;
    }
    /*给你一个整数数组salary，数组里每个数都是 唯一的，其中salary[i] 是第i个员工的工资。
请你返回去掉最低工资和最高工资以后，剩下员工工资的平均值。*/
    public static double average(int[] salary) {
        Arrays.sort(salary);
        salary[0] = 0;
        salary[salary.length-1] = 0;
        IntStream stream = Arrays.stream(salary);
        double i = stream.sum();
        int len = salary.length-2;
        return i/len;
    }
    /*编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。
    * 输入必须是长度为 32 的 二进制串 。
     */
    public static int hammingWeight(int n) {
        return Integer.bitCount(n);
    }
    /*给你一个整数 n，请你帮忙计算并返回该整数「各位数字之积」与「各位数字之和」的差。*/
    public static int subtractProductAndSum(int n) {
        int i = Integer.bitCount(n);
        System.out.println(i);
        return 0;
    }
    /*给定由一些正数（代表长度）组成的数组 nums ，返回 由其中三个长度组成的、面积不为零的三角形的最大周长 。如果不能形成任何面积不为零的三角形，返回 0。*/
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for (int i = A.length - 1; i >= 2; --i) {
            if (A[i - 2] + A[i - 1] > A[i]) {
                return A[i - 2] + A[i - 1] + A[i];
            }
        }
        return 0;
    }
    /*给你两个整数x 和y，表示你在一个笛卡尔坐标系下的(x, y)处。
    同时，在同一个坐标系下给你一个数组points，其中points[i] = [ai, bi]表示在(ai, bi)处有一个点。
    当一个点与你所在的位置有相同的 x 坐标或者相同的 y 坐标时，我们称这个点是 有效的。
    请返回距离你当前位置曼哈顿距离最近的有效点的下标（下标从 0 开始）。如果有多个最近的有效点，请返回下标最小的一个。如果没有有效点，请返回-1。
    两个点 (x1, y1)和 (x2, y2)之间的 曼哈顿距离为abs(x1 - x2) + abs(y1 - y2)。*/
    public static int nearestValidPoint(int x, int y, int[][] points) {
        int min = Integer.MAX_VALUE;
        int ans = -1;
        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            int a = point[0], b = point[1];
            if (a == x || b == y) {
                int dist = Math.abs(a - x) + Math.abs(b - y);
                if (dist < min) {
                    ans = i;
                    min = dist;
                }
            }
        }
        return ans;

    }
    /*已知函数signFunc(x) 将会根据 x 的正负返回特定值：
如果 x 是正数，返回 1 。
如果 x 是负数，返回 -1 。
如果 x 是等于 0 ，返回 0 。
给你一个整数数组 nums 。令 product 为数组 nums 中所有元素值的乘积。
返回 signFunc(product) 。*/
    public static int arraySign(int[] nums) {
        boolean flag = true;
        for (int i = 0; i<nums.length; i++){
            if(nums[i] == 0)
                return 0;
            if(nums[i] < 0)
                flag = !flag;

        }
        if(flag)
            return 1;
        else
            return -1;
    }
    /*给你一个数字数组 arr 。
如果一个数列中，任意相邻两项的差总等于同一个常数，那么这个数列就称为 等差数列 。
如果可以重新排列数组形成等差数列，请返回 true ；否则，返回 false 。
*/
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int d = arr[1]-arr[0];
        for(int i = 0; i<arr.length; i++){
            if(arr[i] != arr[0] + i*d)
                return false;
        }
        return true;
    }

    /*编写一个算法来判断一个数 n 是不是快乐数。
「快乐数」定义为：
对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
如果这个过程 结果为1，那么这个数就是快乐数。
如果 n 是 快乐数 就返回 true ；不是，则返回 false 。*/
    public int squareSum(int n) {
        int sum = 0;
        while(n > 0){
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }
    public boolean isHappy(int n) {
        int slow = n, fast = squareSum(n);
        while (slow != fast){
            slow = squareSum(slow);
            fast = squareSum(squareSum(fast));
        };
        return slow == 1;
    }
    /*给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。*/
    public static int maxProfit(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }
    /*nums1中数字x的 下一个更大元素 是指x在nums2 中对应位置 右侧 的 第一个 比x大的元素。
给你两个 没有重复元素 的数组nums1 和nums2 ，下标从 0 开始计数，其中nums1是nums2的子集。
对于每个 0 <= i < nums1.length ，找出满足 nums1[i] == nums2[j] 的下标 j ，
并且在 nums2 确定 nums2[j] 的 下一个更大元素 。如果不存在下一个更大元素，那么本次查询的答案是 -1 。
返回一个长度为nums1.length 的数组 ans 作为答案，满足 ans[i] 是如上所述的 下一个更大元素 。*/
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int [] newnums = new int [nums1.length];
        for(int i = 0; i<nums1.length; i++){
            for (int j = 0; j<nums2.length; j++){
                if(nums1[i] == nums2[j]){
                    newnums[i] = nums(nums2,j);
                }
            }
        }
        return newnums;
    }
    public int nums(int [] nums2,int index){
        for (int i = index; i<nums2.length; i++){
            if(nums2[i]>nums2[index])
                return nums2[i];
        }
        return -1;
    }
    /*给定一个数组coordinates，其中coordinates[i] = [x, y]，[x, y]表示横坐标为 x、纵坐标为 y的点。请你来判断，这些点是否在该坐标系中属于同一条直线上。*/
    public boolean checkStraightLine(int[][] coordinates) {
        if(coordinates.length == 2)
            return true;
        for(int i = 1; i < coordinates.length - 1; i++){
            int res1 = (coordinates[i][0] - coordinates[i - 1][0]) * (coordinates[i + 1][1] - coordinates[i][1]);
            int res2 = (coordinates[i + 1][0] - coordinates[i][0]) * (coordinates[i][1] - coordinates[i - 1][1]);
            if(res1 != res2){
                return false;
            }
        }
        return true;
    }
/*给你一个正整数数组arr，请你计算所有可能的奇数长度子数组的和。
子数组 定义为原数组中的一个连续子序列。
请你返回 arr中 所有奇数长度子数组的和 。*/
    public int sumOddLengthSubarrays(int[] arr) {
        int result = Arrays.stream(arr).sum();
        if(arr.length <= 2){
            return result;
        }

        int sum = 0;
        int n = arr.length;
        for (int start = 0; start < n; start++) {
            for (int length = 1; start + length <= n; length += 2) {
                int end = start + length - 1;
                for (int i = start; i <= end; i++) {
                    sum += arr[i];
                }
            }
        }
        return sum;

    }
    /*给你一个 m x n 的整数网格 accounts ，其中 accounts[i][j] 是第 i位客户在第 j 家银行托管的资产数量。返回最富有客户所拥有的 资产总量 。
客户的 资产总量 就是他们在各家银行托管的资产数量之和。最富有客户就是 资产总量 最大的客户。*/
    public static int maximumWealth(int[][] accounts) {
        int [] sum = new int [accounts.length];
        for (int i = 0; i<accounts.length; i++){
            int temp = 0;
            for (int j = 0; j<accounts[i].length; j++){
                temp += accounts[i][j];
            }
            sum[i] = temp;
        }
        Arrays.sort(sum);
        return sum[sum.length-1];
    }

    /*给定一个由 0 和 1 组成的矩阵 mat，请输出一个大小相同的矩阵，其中每一个格子是 mat 中对应位置元素到最近的 0 的距离。
两个相邻元素间的距离为 1 。*/
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dist = new int[m][n];
        boolean[][] seen = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<int[]>();
        // 将所有的 0 添加进初始队列中
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    seen[i][j] = true;
                }
            }
        }

        // 广度优先搜索
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int i = cell[0], j = cell[1];
            for (int d = 0; d < 4; ++d) {
                int ni = i + dirs[d][0];
                int nj = j + dirs[d][1];
                if (ni >= 0 && ni < m && nj >= 0 && nj < n && !seen[ni][nj]) {
                    dist[ni][nj] = dist[i][j] + 1;
                    queue.offer(new int[]{ni, nj});
                    seen[ni][nj] = true;
                }
            }
        }

        return dist;
    }
    /*在给定的m x n网格grid中，每个单元格可以有以下三个值之一：
值0代表空单元格；
值1代表新鲜橘子；
值2代表腐烂的橘子。
每分钟，腐烂的橘子周围4 个方向上相邻 的新鲜橘子都会腐烂。
返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回-1。*/
    public static int orangesRotting(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();

        int count = 0; // count 表示新鲜橘子的数量
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                if (grid[r][c] == 1) {
                    count++;
                } else if (grid[r][c] == 2) {
                    queue.add(new int[]{r, c});
                }
            }
        }

        int round = 0; // round 表示腐烂的轮数，或者分钟数
        while (count > 0 && !queue.isEmpty()) {
            round++;
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                int[] orange = queue.poll();
                int r = orange[0];
                int c = orange[1];
                if (r-1 >= 0 && grid[r-1][c] == 1) {
                    grid[r-1][c] = 2;
                    count--;
                    queue.add(new int[]{r-1, c});
                }
                if (r+1 < M && grid[r+1][c] == 1) {
                    grid[r+1][c] = 2;
                    count--;
                    queue.add(new int[]{r+1, c});
                }
                if (c-1 >= 0 && grid[r][c-1] == 1) {
                    grid[r][c-1] = 2;
                    count--;
                    queue.add(new int[]{r, c-1});
                }
                if (c+1 < N && grid[r][c+1] == 1) {
                    grid[r][c+1] = 2;
                    count--;
                    queue.add(new int[]{r, c+1});
                }
            }
        }

        if (count > 0) {
            return -1;
        } else {
            return round;
        }
    }
    /*给你一个由'1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
此外，你可以假设该网格的四条边均被水包围。*/
    static void dfs(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;

        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    ++num_islands;
                    dfs(grid, r, c);
                }
            }
        }

        return num_islands;
    }
    /*给你一个正方形矩阵 mat，请你返回矩阵对角线元素的和。
请你返回在矩阵主对角线上的元素和副对角线上且不在主对角线上元素的和。*/
    public static int diagonalSum(int[][] mat) {
        int result = 0;
        int x = 0;
        int y = 0;
        int yi = mat[0].length-1;
        HashSet hashSet = new HashSet();
        while(true){
            if(x==mat.length && y == mat.length)
                break;
            if(yi == y)
                result += mat[x][y];
            else{
                result += mat[x][y];
                result += mat[x][yi];
            }
            x++;
            y++;
            yi--;
        }
        return result;
    }
    /*在 MATLAB 中，有一个非常有用的函数 reshape ，它可以将一个m x n 矩阵重塑为另一个大小不同（r x c）的新矩阵，但保留其原始数据。
给你一个由二维数组 mat 表示的m x n 矩阵，以及两个正整数 r 和 c ，分别表示想要的重构的矩阵的行数和列数。
重构后的矩阵需要将原始矩阵的所有元素以相同的 行遍历顺序 填充。
如果具有给定参数的 reshape 操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。*/
    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        int m = nums.length;
        int n = nums[0].length;
        if (m * n != r * c) {
            return nums;
        }

        int[][] ans = new int[r][c];
        for (int x = 0; x < m * n; ++x) {
            ans[x / c][x % c] = nums[x / n][x % n];
        }
        return ans;
    }

    /*给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
你可以按 任何顺序 返回答案。*/
    List<Integer> temp = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    public List<List<Integer>> combine(int n, int k) {
        dfs(1, n, k);
        return ans;
    }
    public void dfs(int cur, int n, int k) {
        // 剪枝：temp 长度加上区间 [cur, n] 的长度小于 k，不可能构造出长度为 k 的 temp
        if (temp.size() + (n - cur + 1) < k) {
            return;
        }
        // 记录合法的答案
        if (temp.size() == k) {
            ans.add(new ArrayList<Integer>(temp));
            return;
        }
        // 考虑选择当前位置
        temp.add(cur);
        dfs(cur + 1, n, k);
        temp.remove(temp.size() - 1);
        // 考虑不选择当前位置
        dfs(cur + 1, n, k);
    }

    /*给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。*/
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> output = new ArrayList<Integer>();
        for (int num : nums) {
            output.add(num);
        }

        int n = nums.length;
        backtrack(n, output, res, 0);
        return res;
    }
    public static void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
        // 所有数都填完了
        if (first == n) {
            res.add(new ArrayList<Integer>(output));
        }
        for (int i = first; i < n; i++) {
            // 动态维护数组
            Collections.swap(output, first, i);
            // 继续递归填下一个数
            backtrack(n, output, res, first + 1);
            // 撤销操作
            Collections.swap(output, first, i);
        }
    }

    /*给定一个字符串 s ，通过将字符串 s 中的每个字母转变大小写，我们可以获得一个新的字符串。
返回 所有可能得到的字符串集合 。以 任意顺序 返回输出。*/
    public List<String> letterCasePermutation(String S) {
        List<StringBuilder> ans = new ArrayList();
        ans.add(new StringBuilder());
        for (char c: S.toCharArray()) {
            int n = ans.size();
            if (Character.isLetter(c)) {
                for (int i = 0; i < n; ++i) {
                    ans.add(new StringBuilder(ans.get(i)));
                    ans.get(i).append(Character.toLowerCase(c));
                    ans.get(n+i).append(Character.toUpperCase(c));
                }
            } else {
                for (int i = 0; i < n; ++i)
                    ans.get(i).append(c);
            }
        }
        List<String> finalans = new ArrayList();
        for (StringBuilder sb: ans)
            finalans.add(sb.toString());
        return finalans;
    }

    /*斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
     */
    public static int fib(int n) {
        if (n < 2) {
            return n;
        }
        int p = 0, q = 0, r = 1;
        for (int i = 2; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }

    /*假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？*/
    public int climbStairs(int n) {
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
    /*给你两个字符串 word1 和 word2 。请你从 word1 开始，通过交替添加字母来合并字符串。如果一个字符串比另一个字符串长，就将多出来的字母追加到合并后字符串的末尾。
返回 合并后的字符串 。*/
    public static String mergeAlternately(String word1, String word2) {
        int len = 0;
        String res = "";
        if(word1.length()<word2.length()){
            len = word1.length();
            String substring = word2.substring(0, len);
            String endstring = word2.substring(len,word2.length());
            char[] chars1 = word1.toCharArray();
            char[] chars2 = substring.toCharArray();
            for (int i = 0; i<len; i++){
                res += chars1[i] + "" + chars2[i];
            }
            res += endstring;
        }else{
            len = word2.length();
            String substring = word1.substring(0, len);
            String endstring = word1.substring(len,word1.length());
            char[] chars1 = word2.toCharArray();
            char[] chars2 = substring.toCharArray();
            for (int i = 0; i<len; i++){
                res += chars2[i] + "" + chars1[i];
            }
            res += endstring;
        }
        return res;
    }
    /*请你设计一个可以解释字符串 command 的 Goal 解析器 。command 由 "G"、"()" 和/或 "(al)" 按某种顺序组成。Goal 解析器会将 "G" 解释为字符串 "G"、"()" 解释为字符串 "o" ，"(al)" 解释为字符串 "al" 。然后，按原顺序将经解释得到的字符串连接成一个字符串。
给你字符串 command ，返回 Goal 解析器 对 command 的解释结果。*/
    public String interpret(String command) {
        return command.replace("()", "o").replace("(al)", "al");
    }
    /*给定两个字符串 s 和 t ，它们只包含小写字母。
字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
请找出在 t 中被添加的字母。*/
    public char findTheDifference(String s, String t) {
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            cnt[ch - 'a']++;
        }
        for (int i = 0; i < t.length(); ++i) {
            char ch = t.charAt(i);
            cnt[ch - 'a']--;
            if (cnt[ch - 'a'] < 0) {
                return ch;
            }
        }
        return ' ';
    }

    /*给你一个字符串 s ，将该字符串中的大写字母转换成相同的小写字母，返回新的字符串。*/
    public String toLowerCase(String s) {
        return s.toLowerCase();
    }
    /*给你一个字符串s，它由数字（'0' - '9'）和'#'组成。我们希望按下述规则将s映射为一些小写英文字符：
字符（'a' - 'i'）分别用（'1' -'9'）表示。
字符（'j' - 'z'）分别用（'10#'-'26#'）表示。
返回映射之后形成的新字符串。
题目数据保证映射始终唯一。
*/
    public String freqAlphabets(String s) {
        String[] table = new String[17];
        for(int i=0;i<table.length;i++)
            table[i] = i+10+"#";
        for(int j=0;j<table.length;j++)
            s=s.replace(table[j],String.valueOf((char)(j+'a'+9)));
        for(int i=1;i<=9;i++)
            s=s.replace(i+"", String.valueOf((char)(i+'a'-1)));
        return s;
    }
    /*某种外星语也使用英文小写字母，但可能顺序 order 不同。字母表的顺序（order）是一些小写字母的排列。
给定一组用外星语书写的单词 words，以及其字母表的顺序 order，只有当给定的单词在这种外星语中按字典序排列时，返回 true；否则，返回 false。*/
    public boolean isAlienSorted(String[] words, String order) {
        int[] index = new int[26];
        for (int i = 0; i < order.length(); ++i) {
            index[order.charAt(i) - 'a'] = i;
        }
        for (int i = 1; i < words.length; i++) {
            boolean valid = false;
            for (int j = 0; j < words[i - 1].length() && j < words[i].length(); j++) {
                int prev = index[words[i - 1].charAt(j) - 'a'];
                int curr = index[words[i].charAt(j) - 'a'];
                if (prev < curr) {
                    valid = true;
                    break;
                } else if (prev > curr) {
                    return false;
                }
            }
            if (!valid) {
                /* 比较两个字符串的长度 */
                if (words[i - 1].length() > words[i].length()) {
                    return false;
                }
            }
        }
        return true;
    }

    /*给你一个单链表的引用结点head。链表中每个结点的值不是 0 就是 1。已知此链表是一个整数数字的二进制表示形式。
请你返回该链表所表示数字的 十进制值 。*/
    public int getDecimalValue(ListNode head) {
        ListNode curNode = head;
        int ans = 0;
        while (curNode != null) {
            ans = ans * 2 + curNode.val;
            curNode = curNode.next;
        }
        return ans;
    }

    /*给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。
你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
请你计算并返回达到楼梯顶部的最低花费。*/
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[n];
    }
    /*一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
问总共有多少条不同的路径？*/
    public static int uniquePaths(int m, int n) {
        int [][] dp = new int [m][n];
        for (int i = 0; i < n; i++) dp[0][i] = 1;
        for (int i = 0; i < m; i++) dp[i][0] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
    /*给定两个字符串s和 p，找到s中所有p的异位词的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。*/
    public static List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        if (sLen < pLen) {
            return new ArrayList<Integer>();
        }

        List<Integer> ans = new ArrayList<Integer>();
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for (int i = 0; i < pLen; ++i) {
            ++sCount[s.charAt(i) - 'a'];
            ++pCount[p.charAt(i) - 'a'];
        }

        if (Arrays.equals(sCount, pCount)) {
            ans.add(0);
        }

        for (int i = 0; i < sLen - pLen; ++i) {
            --sCount[s.charAt(i) - 'a'];
            ++sCount[s.charAt(i + pLen) - 'a'];

            if (Arrays.equals(sCount, pCount)) {
                ans.add(i + 1);
            }
        }

        return ans;
    }
    /*给你一个字符串 s 和一个整数 k 。你可以选择字符串中的任一字符，并将其更改为任何其他大写英文字符。该操作最多可执行 k 次。
在执行上述操作后，返回包含相同字母的最长子字符串的长度。*/
    public static int characterReplacement(String s, int k) {
        int[] num = new int[26];
        int n = s.length();
        int maxn = 0;
        int left = 0, right = 0;
        while (right < n) {
            num[s.charAt(right) - 'A']++;
            maxn = Math.max(maxn, num[s.charAt(right) - 'A']);
            if (right - left + 1 - maxn > k) {
                num[s.charAt(left) - 'A']--;
                left++;
            }
            right++;
        }
        return right - left;
    }
    /*你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
    影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。*/
    public static int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        // 子问题：
        // f(k) = 偷 [0..k) 房间中的最大金额

        // f(0) = 0
        // f(1) = nums[0]
        // f(k) = max{ rob(k-1), nums[k-1] + rob(k-2) }

        int N = nums.length;
        int[] dp = new int[N+1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int k = 2; k <= N; k++) {
            dp[k] = Math.max(dp[k-1], nums[k-1] + dp[k-2]);
        }
        return dp[N];
    }
    /*给定一个三角形 triangle ，找出自顶向下的最小路径和。
每一步只能移动到下一行中相邻的结点上。
相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。*/
    public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] f = new int[n][n];
        f[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; ++i) {
            f[i][0] = f[i - 1][0] + triangle.get(i).get(0);
            for (int j = 1; j < i; ++j) {
                f[i][j] = Math.min(f[i - 1][j - 1], f[i - 1][j]) + triangle.get(i).get(j);
            }
            f[i][i] = f[i - 1][i - 1] + triangle.get(i).get(i);
        }
        int minTotal = f[n - 1][0];
        for (int i = 1; i < n; ++i) {
            minTotal = Math.min(minTotal, f[n - 1][i]);
        }
        return minTotal;
    }
    /*给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
如果存在一个整数 x 使得n == 2x ，则认为 n 是 2 的幂次方。
*/
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    /*给你一个整数数组arr。请你将数组中的元素按照其二进制表示中数字 1 的数目升序排序。
如果存在多个数字二进制中1的数目相同，则必须将它们按照数值大小升序排列。
请你返回排序后的数组。*/
    public int[] sortByBits(int[] arr) {
        int [] res = new int [arr.length];
        for (int i =0; i<arr.length; i++){
            //转二进制
            res[i] = Integer.bitCount(arr[i]) * 100000 + arr[i];
        }
        Arrays.sort(res);
        for (int i = 0; i<res.length; i++){
            res[i] = res[i]%100000;
        }
        return res;
    }
    /*给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
注意：若s 和 t中每个字符出现的次数都相同，则称s 和 t互为字母异位词。*/
    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return  false;
        int [] stemp = new int [26];
        int [] ttemp = new int [26];
        for(int i = 0; i<s.length(); i++){
            ++stemp[s.charAt(i) - 'a'];
            ++ttemp[t.charAt(i) - 'a'];
        }
        if(Arrays.equals(stemp,ttemp))
            return true;
        return false;
    }
    /*给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。*/
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i<nums.length-1; i++){
            if(nums[i] == nums[i+1])
                return true;
        }
        return false;
    }
    /*给定一个整数数组 nums和一个整数目标值 target，
    请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
你可以按任意顺序返回答案。*/
    public static int[] twosSum(int[] nums, int target) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        int [] res = new int [2];
        for (int i = 0; i<nums.length; i++){
            int temp = target - nums[i];
            if(!hash.containsKey(temp)){
                hash.put(nums[i],i);
            }else{
                res[0] = hash.get(temp);
                res[1] = i;
            }
        }
        return res;
    }
    /*你在和朋友一起玩 猜数字（Bulls and Cows）游戏，该游戏规则如下：
写出一个秘密数字，并请朋友猜这个数字是多少。朋友每猜测一次，你就会给他一个包含下述信息的提示：
猜测数字中有多少位属于数字和确切位置都猜对了（称为 "Bulls"，公牛），
有多少位属于数字猜对了但是位置不对（称为 "Cows"，奶牛）。也就是说，这次猜测中有多少位非公牛数字可以通过重新排列转换成公牛数字。
给你一个秘密数字secret 和朋友猜测的数字guess ，请你返回对朋友这次猜测的提示。
提示的格式为 "xAyB" ，x 是公牛个数， y 是奶牛个数，A 表示公牛，B表示奶牛。
请注意秘密数字和朋友猜测的数字都可能含有重复数字。*/
    public String getHint(String secret, String guess) {
        int A = 0;
        int B = 0;
        int [] sarr = new int [10];
        int [] garr = new int [10];
        int n = secret.length();
        for (int i = 0; i<n;i++){
            if(secret.charAt(i) == guess.charAt(i)){
                A++;
            }else{
                ++sarr[secret.charAt(i)-'0'];
                ++garr[guess.charAt(i)-'0'];
            }
        }
        for (int i = 0; i<10; i++){
            B += Math.min(sarr[i],garr[i]);
        }
        return A + "A" + B + "B";
    }
    /*颠倒给定的 32 位无符号整数的二进制位。
提示：
请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
在 Java 中，编译器使用二进制补码记法来表示有符号整数。因此，在 示例 2 中，输入表示有符号整数 -3，输出表示有符号整数 -1073741825。
*/
    public int reverseBits(int n) {
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            ret <<= 1;
            ret += (n & 1);
            n >>= 1;
        }
        return ret;
    }
    /*给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
说明：
你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？*/
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }

/*给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，如果两者相等，返回 true 。# 代表退格字符。
注意：如果对空文本输入退格字符，文本继续为空。*/
    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;

        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (S.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else {
                    break;
                }
            }
            while (j >= 0) {
                if (T.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }
            if (i >= 0 && j >= 0) {
                if (S.charAt(i) != T.charAt(j)) {
                    return false;
                }
            } else {
                if (i >= 0 || j >= 0) {
                    return false;
                }
            }
            i--;
            j--;
        }
        return true;
    }
    /*给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
如果数组中不存在目标值 target，返回[-1, -1]。
你必须设计并实现时间复杂度为O(log n)的算法解决此问题。*/
    public int[] searchRange(int[] nums, int target) {
        int leftIdx = binarySearch(nums, target, true);
        int rightIdx = binarySearch(nums, target, false) - 1;
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return new int[]{leftIdx, rightIdx};
        }
        return new int[]{-1, -1};
    }

    public int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    /*整数数组 nums 按升序排列，数组中的值 互不相同 。
在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，
使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为[4,5,6,7,0,1,2] 。
给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回-1。
你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。*/
    public int searchs(int[] nums, int target) {
        for(int i = 0; i<nums.length; i++){
            if(target == nums[i])
                return i;
        }
        return -1;
    }
    /*编写一个高效的算法来判断m x n矩阵中，是否存在一个目标值。该矩阵具有如下特性：
每行中的整数从左到右按升序排列。
每行的第一个整数大于前一行的最后一个整数*/
    public static boolean searchMatrix(int[][] matrix, int target) {
        int index = 0;
        System.out.println(matrix.length-1);
        for (int i = 0; i<matrix.length-1; i++){
            if(matrix[i][0] <= target && matrix[i+1][0] > target){
                index = i;
                break;
            }
            if(i == matrix.length-2)
                index = matrix.length-1;
        }
        for (int i = 0; i<matrix[index].length; i++){
            if(target == matrix[index][i])
                return true;
        }
        return  false;

    }
    /*已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,2,4,5,6,7] 在变化后可能得到：
若旋转 4 次，则可以得到 [4,5,6,7,0,1,2]
若旋转 7 次，则可以得到 [0,1,2,4,5,6,7]
注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
给你一个元素值 互不相同 的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
你必须设计一个时间复杂度为O(log n) 的算法解决此问题。*/
    public int findMin(int[] nums) {
        Arrays.sort(nums);
        return nums[0];
    }
    /*峰值元素是指其值严格大于左右相邻值的元素。
给你一个整数数组nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
你可以假设nums[-1] = nums[n] = -∞ 。
你必须实现时间复杂度为 O(log n) 的算法来解决此问题。*/
    public int findPeakElement(int[] nums) {
        int idx = 0;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] > nums[idx]) {
                idx = i;
            }
        }
        return idx;
    }
    /*给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]]
     满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
你返回所有和为 0 且不重复的三元组。
注意：答案中不可以包含重复的三元组。*/
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        int len = nums.length;
        if(nums == null || len < 3) return ans;
        Arrays.sort(nums); // 排序
        for (int i = 0; i < len ; i++) {
            if(nums[i] > 0) break; // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
            if(i > 0 && nums[i] == nums[i-1]) continue; // 去重
            int L = i+1;
            int R = len-1;
            while(L < R){
                int sum = nums[i] + nums[L] + nums[R];
                if(sum == 0){
                    ans.add(Arrays.asList(nums[i],nums[L],nums[R]));
                    while (L<R && nums[L] == nums[L+1]) L++; // 去重
                    while (L<R && nums[R] == nums[R-1]) R--; // 去重
                    L++;
                    R--;
                }
                else if (sum < 0) L++;
                else if (sum > 0) R--;
            }
        }
        return ans;
    }
    /*给定两个由一些 闭区间 组成的列表，firstList 和 secondList ，其中 firstList[i] = [starti, endi] 而secondList[j] = [startj, endj] 。每个区间列表都是成对 不相交 的，并且 已经排序 。
返回这 两个区间列表的交集 。
形式上，闭区间[a, b]（其中a <= b）表示实数x的集合，而a <= x <= b 。
两个闭区间的 交集 是一组实数，要么为空集，要么为闭区间。例如，[1, 3] 和 [2, 4] 的交集为 [2, 3] 。*/
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> ans = new ArrayList();
        int i = 0, j = 0;

        while (i < A.length && j < B.length) {
            // Let's check if A[i] intersects B[j].
            // lo - the startpoint of the intersection
            // hi - the endpoint of the intersection
            int lo = Math.max(A[i][0], B[j][0]);
            int hi = Math.min(A[i][1], B[j][1]);
            if (lo <= hi)
                ans.add(new int[]{lo, hi});

            // Remove the interval with the smallest endpoint
            if (A[i][1] < B[j][1])
                i++;
            else
                j++;
        }

        return ans.toArray(new int[ans.size()][]);
    }
    /*给定一个长度为 n 的整数数组height。有n条垂线，第 i 条线的两个端点是(i, 0)和(i, height[i])。
找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
返回容器可以储存的最大水量。
说明：你不能倾斜容器。*/
    public static int maxArea(int[] height) {
        int i = 0, j = height.length - 1, res = 0;
        while(i < j) {
            res = height[i] < height[j] ?
                    Math.max(res, (j - i) * height[i++]):
                    Math.max(res, (j - i) * height[j--]);
        }
        return res;
    }
    /*如果数组是单调递增或单调递减的，那么它是单调 的。
如果对于所有 i <= j，nums[i] <= nums[j]，那么数组 nums 是单调递增的。 如果对于所有 i <= j，nums[i]> = nums[j]，那么数组 nums是单调递减的。
当给定的数组 nums是单调数组时返回 true，否则返回 false。*/
    public boolean isMonotonic(int[] nums) {
        if(nums[0] < nums[nums.length-1]){
            for (int i = 0; i< nums.length-1; i++){
                if(nums[i] > nums[i+1]){
                    return false;
                }
            }
        }else if(nums[0] > nums[nums.length-1]){
            for (int i = 0; i< nums.length-2; i++){
                if(nums[i] < nums[i+1]){
                    return false;
                }
            }
        }else if(nums.length <= 2 && nums[0] == nums[nums.length-1]){
            return true;
        }else{
            for (int i = 0; i< nums.length-1; i++){
                if(nums[i] != nums[i+1]){
                    return false;
                }
            }
        }
        return true;
    }
    /*实现strStr()函数。
给你两个字符串haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。
说明：
当needle是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
对于本题而言，当needle是空字符串时我们应当返回 0 。这与 C 语言的strstr()以及 Java 的indexOf()定义相符。*/
    public int strStr(String haystack, String needle) {
            return haystack.indexOf(needle);
    }
    /*给定一个二叉树，判断它是否是高度平衡的二叉树。
本题中，一棵高度平衡二叉树定义为：
一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。*/
    public boolean isBalanced(TreeNode root) {
        return recur(root) != -1;
    }
    private int recur(TreeNode root) {
        if (root == null) return 0;
        int left = recur(root.left);
        if(left == -1) return -1;
        int right = recur(root.right);
        if(right == -1) return -1;
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }
    /*给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。*/
        public boolean repeatedSubstringPattern(String s) {
            return kmp(s + s, s);
        }

        public boolean kmp(String query, String pattern) {
            int n = query.length();
            int m = pattern.length();
            int[] fail = new int[m];
            Arrays.fill(fail, -1);
            for (int i = 1; i < m; ++i) {
                int j = fail[i - 1];
                while (j != -1 && pattern.charAt(j + 1) != pattern.charAt(i)) {
                    j = fail[j];
                }
                if (pattern.charAt(j + 1) == pattern.charAt(i)) {
                    fail[i] = j + 1;
                }
            }
            int match = -1;
            for (int i = 1; i < n - 1; ++i) {
                while (match != -1 && pattern.charAt(match + 1) != query.charAt(i)) {
                    match = fail[match];
                }
                if (pattern.charAt(match + 1) == query.charAt(i)) {
                    ++match;
                    if (match == m - 1) {
                        return true;
                    }
                }
            }
            return false;
    }
    /*给你一个整数数组 nums 和一个整数 k ，请你返回子数组内所有元素的乘积严格小于 k 的连续子数组的数目。
     */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        // 滑动窗口：寻找以每个 right 指针为右边界的有效连续子树组的个数
        int length = nums.length;
        int product = 1;
        int cnt = 0;
        int left = 0, right = 0;
        while (right < length) {
            product *= nums[right++];

            while (left < right && product >= k) {
                product /= nums[left++];
            }

            cnt += (right - left);
        }

        return cnt;
    }
    /*给定一个含有n个正整数的数组和一个正整数 target 。
找出该数组中满足其和 ≥ target 的长度最小的 连续子数组[numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。*/
    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int sum = 0;
        while (end < n) {
            sum += nums[end];
            while (sum >= s) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
    /*根据 逆波兰表示法，求表达式的值。
有效的算符包括+、-、*、/。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
注意两个整数之间的除法只保留整数部分。
可以保证给定的逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。*/
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i<tokens.length; i++){
            String n = tokens[i];
            if(isNumber(n)){
                stack.push(Integer.parseInt(n));
            }else{
                int nums1 = stack.poll();
                int nums2 = stack.poll();
                switch(n){
                    case "+" : stack.push(nums1 + nums2); break;
                    case "-" : stack.push(nums1 - nums2); break;
                    case "*" : stack.push(nums1 * nums2); break;
                    case "/" : stack.push(nums1 / nums2); break;
                    default:
                }
            }
        }
        return stack.poll();
    }
    /*给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
你可以假设除了整数 0 之外，这个整数不会以零开头*/
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
    /*有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。
省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 isConnected[i][j] = 0 表示二者不直接相连。
返回矩阵中 省份 的数量。*/
    public int findCircleNum(int[][] isConnected) {
        int cities = isConnected.length;
        boolean[] visited = new boolean[cities];
        int provinces = 0;
        for (int i = 0; i < cities; i++) {
            if (!visited[i]) {
                dfs(isConnected, visited, cities, i);
                provinces++;
            }
        }
        return provinces;
    }

    public void dfs(int[][] isConnected, boolean[] visited, int cities, int i) {
        for (int j = 0; j < cities; j++) {
            if (isConnected[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(isConnected, visited, cities, j);
            }
        }
    }
    /*给你一棵以root为根的二叉树和一个head为第一个节点的链表。
如果在二叉树中，存在一条一直向下的路径，且每个点的数值恰好一一对应以head为首的链表中每个节点的值，那么请你返回 True ，否则返回 False 。
一直向下的路径的意思是：从树中某个节点开始，一直连续向下的路径。*/
        public boolean isSubPath(ListNode head, TreeNode root) {
            if (head == null) {//满足条件，直接返回true。
                return true;
            }

            if (root == null) {//能执行到这里说明head不为空，此时root为空的话不可能有正确结果，直接返回false。
                return false;
            }
            //这里可能比较难以理解，这里是调用了一个DfsSame和两个isSubPath.
            //DfsSame的含义大家可以看下面，注释很详细。
            //isSubPath就是当前的这个方法，所干的事情就是深度优先遍历DFS，他利用本身这个方法调用，来遍历root中每一个节点。
            //所以总结一下就是两个isSubPath用来遍历当前位置的左右子树。
            //一个DfsSame判断当前的root节点的值是否与head的第一个节点的值相同。
            //在本方法中调用的DfsSame，root节点比较的永远是head第一个节点的值，也必须比较head第一个节点的值。
            //判断head后续节点的值需要的前提条件是之前的节点已经找到了连续向下的路径。
            return DfsSame(head,root) || isSubPath(head,root.left) || isSubPath(head,root.right);
        }

        //判断当前root节点与当前head节点的内容是否相同。
        private boolean DfsSame(ListNode head,TreeNode root) {
            if(head == null) {//则说明head已经遍历完毕，已经在root中寻找到了与head相同连续向下的路径
                return true;
            }

            if (root == null) {//head不为空但root以为空，在此路径上不可能寻找到相同路径了，返回false
                return false;
            }

            if (root.val != head.val) {//值不相同，直接返回false.
                return false;
            }
            //当前位置相同，root向下(向下寻找左右子树),head向后寻找下一个节点
            return DfsSame(head.next,root.left) || DfsSame(head.next,root.right);
        }
        /*给定两个以字符串形式表示的非负整数num1和num2，返回num1和num2的乘积，它们的乘积也表示为字符串形式。
注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。*/
        public String multiply(String num1, String num2) {
            if (num1.equals("0") || num2.equals("0")) {
                return "0";
            }
            int m = num1.length(), n = num2.length();
            int[] ansArr = new int[m + n];
            for (int i = m - 1; i >= 0; i--) {
                int x = num1.charAt(i) - '0';
                for (int j = n - 1; j >= 0; j--) {
                    int y = num2.charAt(j) - '0';
                    ansArr[i + j + 1] += x * y;
                }
            }
            for (int i = m + n - 1; i > 0; i--) {
                ansArr[i - 1] += ansArr[i] / 10;
                ansArr[i] %= 10;
            }
            int index = ansArr[0] == 0 ? 1 : 0;
            StringBuffer ans = new StringBuffer();
            while (index < m + n) {
                ans.append(ansArr[index]);
                index++;
            }
            return ans.toString();
        }
        /*
        * 给你两个二进制字符串，返回它们的和（用二进制表示）。
输入为 非空 字符串且只包含数字 1 和 0。*/
    public static String addBinary(String a, String b) {
        return Integer.toBinaryString(
                Integer.parseInt(a, 2) + Integer.parseInt(b, 2)
        );

    }
    /*整数的 数组形式 num是按照从左到右的顺序表示其数字的数组。
例如，对于 num = 1321 ，数组形式是 [1,3,2,1] 。
给定 num ，整数的 数组形式 ，和整数 k ，返回 整数 num + k 的 数组形式 。*/
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> res = new ArrayList<Integer>();
        int n = num.length;
        for (int i = n - 1; i >= 0; --i) {
            int sum = num[i] + k % 10;
            k /= 10;
            if (sum >= 10) {
                k++;
                sum -= 10;
            }
            res.add(sum);
        }
        for (; k > 0; k /= 10) {
            res.add(k % 10);
        }
        Collections.reverse(res);
        return res;
    }
    /*给你一个 n x n 的二进制矩阵 grid 中，返回矩阵中最短 畅通路径 的长度。如果不存在这样的路径，返回 -1 。
二进制矩阵中的 畅通路径 是一条从 左上角 单元格（即，(0, 0)）到 右下角 单元格（即，(n - 1, n - 1)）的路径，该路径同时满足下述要求：
路径途经的所有单元格都的值都是 0 。
路径中所有相邻的单元格应当在 8 个方向之一 上连通（即，相邻两单元之间彼此不同且共享一条边或者一个角）。
畅通路径的长度 是该路径途经的单元格总数。*/
    static class Node {
        int x;
        int y;
        int step;

        public Node(int start, int end, int step) {
            this.x = start;
            this.y = end;
            this.step = step;
        }
    }

    int[] dx = {0, 0, -1, 1,-1, 1,-1, 1};
    int[] dy = {-1, 1, 0, 0, -1,-1, 1, 1};

    public int shortestPathBinaryMatrix(int[][] grid) {

        Node node = new Node(0, 0, 2);
        Deque<Node> queue = new ArrayDeque<>();
        queue.addLast(node);

        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        } else if (n <= 2) {
            return n;
        }
        while (!queue.isEmpty()){
            Node cur = queue.removeFirst();
            int x = cur.x;
            int y = cur.y;
            int step = cur.step;
            for (int i = 0; i < 8; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if(0<=newX && newX<n && 0<=newY && newY<n && grid[newX][newY] == 0){
                    //找到终点
                    if(newX == n-1 && newY == n-1){
                        return step ;
                    }
                    queue.addLast(new Node(newX, newY, step + 1));
                    grid[newX][newY] = 1; //标记已遍历过，避免重复
                }
            }
        }
        return -1;
    }
    /*给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。*/
    static int n,m;
    public static void solve(char[][] board) {
        n = board.length;
        if (n == 0) {
            return;
        }
        m = board[0].length;
        for (int i = 0; i < n; i++) {
            dfs1(board, i, 0);
            dfs1(board, i, m - 1);
        }
        for (int i = 1; i < m - 1; i++) {
            dfs1(board, 0, i);
            dfs1(board, n - 1, i);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public static void dfs1(char[][] board, int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= m || board[x][y] != 'O') {
            return;
        }
        board[x][y] = 'A';
        dfs1(board, x + 1, y);
        dfs1(board, x - 1, y);
        dfs1(board, x, y + 1);
        dfs1(board, x, y - 1);
    }
    /*给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。*/
    /**
     * 增量构造法：递归
     */
    public List<List<Integer>> subsets(int[] nums) {
        //res.add(new ArrayList<>());
        int[] record = new int[nums.length];
        subSet(nums, record, 0);
        return res;
    }

    List<List<Integer>> res = new ArrayList<>();

    /**
     * 用record记录选取的下标序号集合
     */
    private void subSet(int[] nums, int[] record, int cur) {
        ArrayList<Integer> temp = new ArrayList<>(cur);
        for (int i = 0; i < cur; i++) {
            temp.add(nums[record[i]]);      //添加当前选取元素到集合
        }
        res.add(temp);
        int start = cur != 0 ? record[cur - 1] + 1 : 0; //确定当前元素下标的最小可能值
        for (int i = start; i < nums.length; i++) {
            record[cur] = i;
            subSet(nums, record, cur + 1);  //递归构造子集
        }
    }
}
