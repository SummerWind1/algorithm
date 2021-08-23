package com.radish.sort.bubblesort;

/**
 * 冒泡排序
 *
 * @author fangp fangp@3vjia.com
 * @since 2021-08-20 14:48
 */
public class BubbleSort {

    public static void main(String[] args) {

        int [] array = new int[] {1, 8, 4, 3, 6, 7, 2, 5};

        // 外层嵌套控制比较的轮数，eg: 8个数只用比较7次，最后一个数据不用和谁比较
        for (int i = 0; i < array.length -1 ; i++) {

            System.out.println("当前是第" + i + "轮");
            // 内层嵌套控制每一轮比较的次数；
            // 这里有一个优化的地方，每一轮比较之后（假设从小到大排列），都会有最大的元素处在数组的最右边
            // 随着比较的继续，每一轮需要比较的元素数量都会减少一个

            // 优化方法，如果一轮下来已经没有了元素交换，那么下一轮其实不需要再进行下去了
            boolean flag = false;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }

        // 打印一下
        for (int i1 : array) {
            System.out.println(i1);
        }
    }

}
