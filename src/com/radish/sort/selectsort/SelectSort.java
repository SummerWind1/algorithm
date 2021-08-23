package com.radish.sort.selectsort;

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
 * TODO 看看小灰书里是怎么实现的
 *
 */
public class SelectSort {

    public static void main(String[] args) {

        int [] array = new int[] {1, 8, 4, 3, 6, 7, 2, 5};

        // 外层循环控制数组的比较轮数(eg: 8个元素的数组, 第一轮需要比较7次 , 8个元素，需要进行6轮比较)
        for (int i = 0; i < array.length - 1; i++) {

            int min = i;
            // 选中第一个元素为最小值
            // 内存循环控制每轮数据之间的比较, 内层for循环每一次取一个元素和最小元素进行比较，获取到比较得到的最小元素的位置
            for (int j = i+1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }

            // 说明最小值发生了变更
            if (i != min) {
                int tmp = array[i];
                array[i] = array[min];
                array[min] = tmp;
            }

        }
        // 打印一下
        for (int i1 : array) {
            System.out.println(i1);
        }
    }
}
