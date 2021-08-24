package com.radish.sort.quicksort;

/**
 * 快速排序
 *
 * 双路快速排序法(从小到大排序)
 * 1、选取一个坐标值 pivot
 * 2、选取数组的第一个元素下标和最后一个元素的下标作为指针
 * 3、从数组的右边开始，取右指针元素和pivot比较大小，如果大于基准元素，右指左移，继续和pivot元素比较大小，停止条件是右指针指向的元素小于等于基准元素；如果小于等于基准元素，右指针停止不动，切换到左指针的元素和pivot 比较；如果左指针元素小于等于pivot 元素，左指针右移，继续和pivot比较；左指针的停止条件是指针指向的元素比pivot 大；一轮比较结束；然后进行新一轮的比较
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
        int [] array = new int[] {1, 8, 4, 3, 6, 7, 2, 5};

        // 有双边循环和单边循环两种处理方式来解决快速排序、还有三路快速排序法



    }

    /**
     * 1、双边循环
     * @param array
     */
    public static void partition(int[] array) {


    }

}
