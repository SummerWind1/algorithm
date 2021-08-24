package com.radish.sort.mergesort;

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

//        int [] array = new int[] {1, 8, 4, 3, 6, 7, 2, 5};
//        int [] array = new int[] {5, 8, 6, 3, 9, 2, 1, 7};
        int [] array = new int[] {5, 8, 6, 3};

//        mergeSort(array);

        mergeSortByGray(array, 0, array.length - 1);

        for (int i1 : array) {
            System.out.println(i1);
        }

    }

    /**
     * 百度-知乎版本
     * @param arr
     * @param result
     * @param start
     * @param end
     */
    private static void mergeSortRecursive(int[] arr, int[] result, int start, int end) {
        if (start >= end) {
            return;
        }
        int len = end - start, mid = (len >> 1) + start;
        // 分割入参数组为两个子数组
        int start1 = start, end1 = mid;
        int start2 = mid + 1, end2 = end;
        mergeSortRecursive(arr, result, start1, end1);
        mergeSortRecursive(arr, result, start2, end2);
        int k = start;
        while (start1 <= end1 && start2 <= end2) {
            result[k++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
        }
        while (start1 <= end1) {
            result[k++] = arr[start1++];
        }
        while (start2 <= end2) {
            result[k++] = arr[start2++];
        }
        for (k = start; k <= end; k++) {
            arr[k] = result[k];
        }
    }

    /**
     * 集合排序，入参只有一个数组
     * @param arr
     */
    public static void mergeSort(int[] arr) {
        int len = arr.length;
        int[] result = new int[len];
        mergeSortRecursive(arr, result, 0, len - 1);
    }


    /**
     * 小灰书中的版本比较直观
     */
    public static void mergeSortByGray(int [] array, int start, int end) {

        if (start < end) {
            int middle = (end + start) / 2;
            // 对数组进行递归拆分，直到数组的元素无法在进行细分
            mergeSortByGray(array, start, middle);
            // 同上，只有元素被拆成单个，才会走到下面这个方法
            mergeSortByGray(array, middle+1, end);
            // 将最小粒度的元素进行合并
            merge(array, start, end, middle);
        }
    }

    /**
     * 核心逻辑
     * @param array 原始待排序数组
     * @param start
     * @param end
     * @param middle
     */
    private static void merge(int[] array, int start, int end, int middle) {

        // 需要将元素元素进行合并,创建一个临时的数组
        int [] tempArray = new int[end - start + 1];

        int p1 = start, p2 = middle + 1, p = 0;

        while ((p1 <= middle) && (p2 <= end)) {
            if (array[p1] <= array[p2]) {
                // 这里的操作是p++ 在java 中不会立即加一
                tempArray[p++] = array[p1++];
            } else {
                tempArray[p++] = array[p2++];
            }
        }

        while (p1 <= middle) {
            tempArray[p++] = array[p1++];
        }

        while (p2 <= end) {
            tempArray[p++] = array[p2++];
        }

        for (int i = 0; i < tempArray.length ; i++) {
            array[i + start] = tempArray[i];
        }


    }


}
