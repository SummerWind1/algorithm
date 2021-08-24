package com.radish.sort.util;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 随机数工具类
 *
 * @author fangp fangp@3vjia.com
 * @since 2021-08-24 11:20
 */
public class RandomUtil {


    /**
     * 随机获取100W 个数字的数组
     */
    public static int[] getRandomArray() {

        ThreadLocalRandom current = ThreadLocalRandom.current();

        Set<Integer> set = new HashSet<>(1000000);

        for (int i = 0; i < 1000000; i++) {
            set.add(current.nextInt(0, 1000000));
        }
        int[] ints = set.stream().mapToInt(Integer::intValue).toArray();
        return ints;
    }

    /**
     * 获取指定程度的数组
     * @param length
     * @return
     */
    public static int[] getRandomArrayByLength(int length) {

        ThreadLocalRandom current = ThreadLocalRandom.current();

        Set<Integer> set = new HashSet<>(length);

        for (int i = 0; i < length; i++) {
            set.add(current.nextInt(0, length));
        }
        int[] ints = set.stream().mapToInt(Integer::intValue).toArray();
        return ints;
    }

}
