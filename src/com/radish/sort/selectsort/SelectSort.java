package com.radish.sort.selectsort;

import java.util.Arrays;

/**
 * 选择排序， 给定一个数组，随机选取其中的一个元素作为最小值，然后遍历比较是否有比选中最小值还小的元素，并确定元素的位置，
 * 然后将遍历得到的最小值和选中的最小值进行位置交换
 *
 * 可以默认数组的第一位是最小值()
 *
 * 算法实现上来说，会出现 最大值是第一位，这样子的话算法的时间负责度会退化
 *
 * 适用于小规模的数据排序
 *
 * @author fangp fangp@3vjia.com
 * @since 2021-08-20 15:21
 *
 * 选择排序
 * 属于原地排序，时间复杂度O(n2) 假定每次把数组的第一个元素作为最小值，在内存循换中用剩余的元素和假定最小值进行比较； 如果遇到比最小值小的值，最小值下标更新一下，每次比较都会和最新的最小值进行比较
 *
 */
public class SelectSort {

    public static void main(String[] args) {

        int [] array = new int[] {1, 8, 4, 3, 6, 7, 2, 5};
//
//        // 外层循环控制数组的比较轮数(eg: 8个元素的数组, 第一轮需要比较7次 , 8个元素，需要进行6轮比较)
//        for (int i = 0; i < array.length - 1; i++) {
//
//            int min = i;
//            // 选中第一个元素为最小值
//            // 内存循环控制每轮数据之间的比较, 内层for循环每一次取一个元素和最小元素进行比较，获取到比较得到的最小元素的位置
//            for (int j = i+1; j < array.length; j++) {
//                if (array[j] < array[min]) {
//                    min = j;
//                }
//            }
//
//            // 说明最小值发生了变更
//            if (i != min) {
//                int tmp = array[i];
//                array[i] = array[min];
//                array[min] = tmp;
//            }
//
//            System.out.println(Arrays.toString(array));
//        }
//        // 打印一下
//        System.out.print(Arrays.toString(array));

        selectSort(array);

    }


    public static void selectSort(int [] array) {

        for (int i = 0; i < array.length - 1; i++) {
            // 当前元素未最小值
            int min_index = i;
            for (int j = i+1; j < array.length; j++) {
                // 从数组的第二个元素开始比较，最后一个元素不需要比较
                if (array[j] < array[min_index]) {
                    min_index = j;
                }
            }
            // 位置交换
            if (min_index != i) {
                int tmp = array[min_index];
                array[min_index] = array[i];
                array[i] = tmp;
            }
            System.out.println(Arrays.toString(array));
        }
        System.out.print(Arrays.toString(array));
    }

}
