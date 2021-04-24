package com.leetcode.util;

import java.util.Random;

/**
 * 数据生成器
 *
 * @Author: jiangfw
 * @Date: 2021-04-24
 */
public class Generator {

    public static void main(String[] args) {
        generateArray();
    }

    private static void generateArray() {
        for (int i = 0; i < 1000; i++) {
            System.out.print("," + new Random().nextInt(100000));
        }
    }
}
