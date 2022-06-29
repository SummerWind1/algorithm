package com.radish.sort.binarysort;

import java.util.Arrays;

/**
 * 二分查找
 *
 * 二分法可以在快速的在有序数组中定一个元素的位置； 不能改变数组的大小，不使用额外的内存
 * 二分查找有很多变种问题，假如数组中存在重复的元素，二分查找会衍生出很多变种问题，比如查找出现的第一个、第n个。
 *
 *
 * @author fangp
 * @since 2021-08-25 10:49
 */
public class BinarySort {

    public static void main(String[] args) {

        int [] array = new int[]{1,3,3,4,6,12,22,43};
        Arrays.sort(array);
        System.out.println(array);

        System.out.println(binarySort(3, array));

    }

    public static int binarySort(int a, int [] array) {

        // 优化方向，找到出现的第一个,和最后一个目标数的下标

        // 每次都找数组的中间位置的数据， 和给定要查询的数据比较大小， 定义两个指针来确定数组的下表范围;
        int left = 0;
        int right = array.length - 1;

        while (right >= left) {
            // 中位数下标
            int mid = (right + left) / 2;
            if (array[mid] == a) {
                right = mid -1;
            }
            if (array[mid] > a) {
                right = mid -1;
            }
            if (array[mid] < a) {
                left = mid + 1;
            }
        }
        return left;
    }

    public static int binarySortGetFirst(int a, int [] array) {

        // 每次都找数组的中间位置的数据， 和给定要查询的数据比较大小， 定义两个指针来确定数组的下表范围
        int left = 0;
        int right = array.length - 1;
        int index = array.length;
        while (right >= left) {
            // 中位数下标
            int mid = (right + left) / 2;
            if (array[mid] == a) {
                while (mid != 0 && array[mid] == array[mid - 1]) {
                    mid--;
                }
                return mid;
            }
            if (array[mid] > a) {
                right = mid -1;
            }
            if (array[mid] < a) {
                left = mid + 1;
            }
        }
        return index;
    }

    public static int binarySortGetEnd(int a, int [] array) {

        // 每次都找数组的中间位置的数据， 和给定要查询的数据比较大小， 定义两个指针来确定数组的下表范围
        int left = 0;
        int right = array.length - 1;
        while (right >= left) {
            // 中位数下标
            int mid = (right + left) / 2;
            if (array[mid] == a) {
                while (mid != 0 && array[mid] == array[mid + 1]) {
                    mid ++;
                }
                return mid;
            }
            if (array[mid] > a) {
                right = mid -1;
            }
            if (array[mid] < a) {
                left = mid + 1;
            }
        }
        return left;
    }


}
