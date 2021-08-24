package com.radish.sort.quicksort;

import com.radish.sort.util.RandomUtil;

/**
 * 快速排序 原地排序算法，不需要额外的内存空间占用
 *
 * 双路快速排序法(从小到大排序)
 * 1、选取一个坐标值 pivot
 * 2、选取数组的第一个元素下标和最后一个元素的下标作为指针
 * 3、从数组的右边开始，取右指针元素和pivot比较大小，如果大于基准元素，右指左移，继续和pivot元素比较大小，停止条件是右指针指向的元素小于等于基准元素；如果小于等于基准元素，右指针停止不动，切换到左指针的元素和pivot 比较；如果左指针元素小于等于pivot 元素，左指针右移，继续和pivot比较；左指针的停止条件是指针指向的元素比pivot 大；一轮比较结束；然后进行新一轮的比较
 *
 * 测试发现：如果数组中存在较多的重复元素，递归的时候会出现递归无法跳出，导致出现 stackOverflow 异常
 *
 *
 * 单边循环法
 *
 *
 *
 * 三路快速排序法
 *
 *
 * @author fangp fangp@3vjia.com
 * @since 2021-08-20 15:19
 */
public class QuickSort {

    public static void main(String[] args) {
        // 这个排序我忘记定义是什么了。。。
        int [] array = new int[] {4,7,3,5,6,2,8,1};

        // 有双边循环和单边循环两种处理方式来解决快速排序、还有三路快速排序法

        // 100w 的随机数进行排序，看看耗时
//        quickSort(array, 0, array.length -1);
        int[] randomArray = RandomUtil.getRandomArray();
        long start = System.currentTimeMillis();
        System.out.println("当前时间戳："+ start);
        quickSort(randomArray, 0, randomArray.length -1);
        System.out.println("结束时间戳：" + System.currentTimeMillis());
        System.out.println("耗时:" + (System.currentTimeMillis() - start));

        // 打印
        for (int i1 : randomArray) {
            System.out.println(i1);
        }

    }

    /**
     * 1、双边循环， 返回数组的中间坐标，用于对数组进行分割递归排序
     * @param array 数组
     * @param startIndex 数组结束下标
     * @param endIndex 数组开始下标
     * @return 返回入参数组的分割下标
     */
    public static int partition(int[] array, int startIndex, int endIndex) {
        // 基准元素
        int pivot = array[startIndex];
        int left = startIndex;
        int right = endIndex;
        // 开始核心代码
        while (left != right) {

            // 右指针的移动, 指针指向的元素大于pivot时，右指针会一直左移，一直到右指针指向的元素小于或者等于pivot 元素才会停下来，同时，左指针开始运动
            while (array[right] > pivot && right > left) {
                right--;
            }

            // 左指针移动，右指针停止之后，左指针元素开始和pivot比较，左指针指向元素比pivot小，左指针右移，直到左指针元素大于pivot ，进行元素位置交换(左指针元素和右指针指向的元素值进行互换)，本轮比较停止
            while (array[left] <= pivot && right > left) {
                left++;
            }

            // 走到这里说明出现了左指针指向的元素大于pivot 元素；需要进行元素位置互换
            if (left < right) {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }
            // 进行下一轮循环
        }

        // 循环结束，说明startIndex = endIndex；交换pivot 的元素到重叠位置的下标
        array[startIndex] = array[left];
        array[left] = pivot;

        return left;
    }


    /**
     * 快速排序
     * @param array
     * @param startIndex
     * @param endIndex
     */
    public static void quickSort(int[] array, int startIndex, int endIndex) {

        // 这个条件不加上的话会出现栈内存溢出
        if (startIndex >= endIndex) {
            return;
        }

        int partition = partition(array, startIndex, endIndex);
        // 递归排序
        quickSort(array, startIndex, partition);
        // 递归排序
        quickSort(array, partition+1, endIndex);

    }

}
