package pers.rokin.train;

import java.util.*;
import java.util.stream.IntStream;

class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
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
        mergeAlternately("ab","pqrs");
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
}
