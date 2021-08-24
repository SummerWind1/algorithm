package com.radish.sort.mergesort;

import com.radish.sort.util.RandomUtil;

import java.util.Arrays;

/**
 * 归并排序
 *
 * 基本思想就是将大数组分成小数组，然后小数组排序后合并成有序的大数组(插入排序优化点)；最终数组变成有序
 *
 * @author fangp fangp@3vjia.com
 * @since 2021-08-24 14:28
 */
public class MergeSort {


    public static void main(String[] args) {

//        int[] randomArrayByLength = RandomUtil.getRandomArrayByLength(20);

        int [] array = new int[] {1, 8, 4, 3, 6, 7, 2, 5};

        sort(array);

        for (int i1 : array) {
            System.out.println(i1);
        }

    }

    /**
     * 两个数组进行合并
     * @param left
     * @param right
     */
    public static int[] merge(int [] left, int [] right) {

        // 创建一个新数组用于存放两个数组合并后的有序数据
        int[] result = new int[left.length + right.length];

        int i = 0;

        // 两个数组的数据进行比较，取第一个数组中的第一个数据和第二个数组的第一个数据作比较 eg a [2,5], b [6,1]
        // 2 < 6 ; 2 放入新数组result 的首位，同时a 数组修改为[5]
        // 5 < 6 ; 5 放入新数组result 的第二位
        while (left.length > 0 && right.length > 0) {
            if (left[0] <= right[0]) {
                result[i++] = left[0];
                // 这里是复制出来一个新的数组放余下的数据
                left = Arrays.copyOfRange(left, 1, left.length);
            } else {
                result[i++] = right[0];
                right = Arrays.copyOfRange(right, 1, right.length);
            }
        }

        // 如上操作的情况下，这里不会走
        while (left.length > 0) {
            result[i++] = left[0];
            left = Arrays.copyOfRange(left, 1, left.length);
        }

        // 如上情况，这两会将right 数组直接放到result 数组的最后两位
        while (right.length > 0) {
            result[i++] = right[0];
            right = Arrays.copyOfRange(right, 1, right.length);
        }

        return result;
    }

    /**
     * 数组，对数组进行排序
     */
    public static int[] sort(int [] sourceArray) {

        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        if (arr.length < 2) {
            return arr;
        }
        // 数组分开
        int middle = (int) Math.floor(arr.length >> 1);

        int[] left = Arrays.copyOfRange(arr, 0, middle);
        int[] right = Arrays.copyOfRange(arr, middle, arr.length);

        return merge(sort(left), sort(right));

    }



}
