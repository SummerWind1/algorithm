package com.radish.sort.insertsort;

/**
 * 插入排序, 类似于扑克牌，每次选定一个位置，然后保证位置左右的扑克牌是有序的.可以依赖递归实现
 *
 * 这个算法的主要判断难度在于如何将一个元素放入有序数组中，还能保证数组的有序性
 *
 * TODO 回头看看小灰的算法是怎么实现的
 *
 * @author fangp fangp@3vjia.com
 * @since 2021-08-20 15:20
 */
public class InsertSort {

    public static void main(String[] args) {

        int [] array = new int[] {1, 8, 4, 3, 6, 7, 2, 5};

        // 外层循环控制比较的轮数, 最后一个数不需要比较
        for (int i = 0; i < array.length -1; i++) {
            // 内层循环控制每轮的比较, 每一轮都要和已经排好序的数组最后一个元素进行比较，然后判断是否需要进行位置交换
            for (int j = i+1; j > 0; j--) {
                if (array[j] < array[j-1]) {
                    // 需要进行位置互换, 如何保证有序区间添加新元素之后继续有序(for 循环将元素换到指定位置)
                    int temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                } else {
                    // 此轮结束
                    break;
                }
            }
        }
        // 打印
        for (int i1 : array) {
            System.out.println(i1);
        }

    }

}
