package pers.rokin.sort;

import java.util.Arrays;


public class Sort {
    public static void main(String[] args) {
        int [] arr = {5,10,1,984,1,65,4,7};
//        //冒泡排序
//        Bubbling(arr);
//
//        //选择排序
//        Choice(arr);
//
//        //插入排序
//        Insert(arr);

        //希尔排序
//        Hill(arr);

        //快速排序
//        Fast(arr, 0, arr.length-1);

        //归并排序
//        Merge(arr);

        //基数排序
//        Base(arr);

        //堆排序
        Heap(arr);
//        for(int x : arr)
//            System.out.print(x + " ");
        System.out.println();
        System.out.println(Arrays.toString(arr));
    }

    //冒泡排序
    private static void Bubbling( int [] arr){
        for (int i = 0; i<arr.length-1; i++){
            for (int j = 0; j<arr.length-1-i; j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    //选择排序
    private static void Choice(int [] arr){
        for (int i = 0; i<arr.length-1; i++){
            for (int j=i+1; j<arr.length; j++){
                if(arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
    //插入排序
    private static void Insert(int [] arr){
        for (int i = 1; i<arr.length; i++){
            for (int j = i; j>0; j--){
                if(arr[j]<arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
    }

    //希尔排序
    private static void Hill(int [] arr){

//        for (int h = arr.length/2; h>0; h/=2){  //直接除以2不是很好  可以利用克努特序列来进行优化
//            for (int i = h; i<arr.length; i++){
//                for (int j = i; j>h-1; j-=h){
//                    if(arr[j]<arr[j-h]){
//                        int temp = arr[j];
//                        arr[j] = arr[j-h];
//                        arr[j-h] = temp;
//                    }
//                }
//            }
//        }

        //利用克努特序列
        int va = 1;
        while(va<=arr.length/3){
            va = va*3-1;
        }
        for (int h = va; h>0; h/=2){  //直接除以2不是很好  可以利用克努特序列来进行优化
            for (int i = h; i<arr.length; i++){
                for (int j = i; j>h-1; j-=h){
                    if(arr[j]<arr[j-h]){
                        int temp = arr[j];
                        arr[j] = arr[j-h];
                        arr[j-h] = temp;
                    }
                }
            }
        }

    }

    //快速排序
    //传入开始位置与结束位置
    /*
    * 1 将基准数挖出形成第一个坑
    * 2 由后向前找出比他小的数，找到后挖出此数填到前一个坑中
    * 3 由前向后找到比他大或等于的数 找到后也挖出此数填到前一个坑中
    * */
    private static void Fast(int [] arr, int start, int end){
        if(start < end){
            int index = getInext(arr,start,end);
            Fast(arr,start,index-1);
            Fast(arr,index+1,end);
        }
    }

    private static int getInext(int[] arr, int start, int end) {
        int i = start;
        int j = end;
        int va = arr[i];
        while(i<j){
            while(i<j && arr[j]>=va){
                j--;
            }
            if(i<j){
                arr[i]=arr[j];
                i++;
            }
            while(i<j && arr[i]<va){
                i++;
            }
            if(i<j){
                arr[j] = arr[i];
                j--;
            }
        }
        arr[i] = va;//把基准数填到最后一个坑中
        return i;
    }

    //归并排序
    private static void Merge(int [] arr){
        //先拆分
        Separate(arr, 0, arr.length-1);
    }

    private static void Separate(int[] arr, int startindex, int endindex) {
        int centerindex = (startindex+endindex)/2;
        if(startindex < endindex){
            Separate(arr,startindex,centerindex); //拆分左边的
            Separate(arr,centerindex+1,endindex); // 拆分右边的
            //再归并
            Integration(arr,startindex,centerindex,endindex);
        }
    }

    private static void Integration(int[] arr, int startindex, int centerindex, int endindex) {
        //先定义一个临时数组
        int [] temparr = new int[endindex-startindex+1];
        int i = startindex; //左边数组的起始索引
        int j = centerindex+1;//右边数组的起始索引
        int index = 0;  //临时数组的起始索引
        while(i <= startindex && j<=endindex){
            if(arr[i] <= arr[j]){
                temparr[index] = arr[i];
                i++;
            }
            if(arr[j] <= arr[i]){
                temparr[index] = arr[j];
                j++;
            }
            index++;
        }
        //处理剩余数据
        while(i<= startindex){
            temparr[index] = arr[i];
            i++;
            index++;
        }
        while(j<= endindex){
            temparr[index] = arr[j];
            j++;
            index++;
        }
    }

    //基数排序
    private static void Base(int[] arr) {
        int [][] temparr = new int [10][arr.length];
        int [] coutarr =new int[10];    //计数
        int max = getMax(arr);
        int len = String.valueOf(max).length();
        for (int i = 0,n = 1; i<len; i++,n*=10){
            for (int j = 0; j<arr.length; j++){     //将数据放入10个桶中
                int value = arr[j]/n%10;
                temparr[value][coutarr[value]++] = arr[j];
            }
            //将桶中数据取出
            int index = 0;
            for (int k = 0; k<coutarr.length; k++){
                for (int h = 0; h<coutarr[k]; h++){
                    arr[index] = temparr[k][h];
                    index++;
                }
                coutarr[k] = 0; //清除上一次统计的个数
            }
        }
    }

    private static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i<arr.length; i++){
            if(arr[i]>max)
                max = arr[i];
        }
        return max;
    }

    //堆排序
    private static void Heap(int[] arr) {
        int len = arr.length;
        buildMaxHeap(arr,len);  //构建大顶堆
    }

    private static void buildMaxHeap(int[] arr, int len) {
        for (int i = len/2-1; i>=0; i--){
            //从第一个非叶子节点从下至上 从右至左调整结构
            changeHeap(arr,i,len);
        }
        //调整结构+交换堆顶元素与末尾元素
        for (int j = len-1;j>0; j--){
            swap(arr,0,j);//交换元素
            changeHeap(arr,0,j);    //重新排序
        }
    }

    private static void changeHeap(int[] arr, int i, int len) {
        int temp = arr[i];      //先取当前元素i
        for (int k = i*2+1; k<len; k=k*2+1){    //从i节点的左子节点开始  也就是2i=1
            if(k+1<len && arr[k]<arr[k+1]){ //如果左子节点小于右子节点 k指向右子节点
                k++;
            }
            if(arr[k]>temp){    //如果子节点大于父节点 将子节点值赋给父节点（不用进行交换）
                arr[i] = arr[k];
                i=k;
            }else{
                break;
            }
        }
        arr[i] = temp;  //将temp值放于最后
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
