package com.leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abcabcbb" Output: 3 Explanation: The answer is "abc", with the length of 3. Example
 * 2:
 * <p>
 * Input: s = "bbbbb" Output: 1 Explanation: The answer is "b", with the length of 1. Example 3:
 * <p>
 * Input: s = "pwwkew" Output: 3 Explanation: The answer is "wke", with the length of 3. Notice that
 * the answer must be a substring, "pwke" is a subsequence and not a substring. Example 4:
 * <p>
 * Input: s = "" Output: 0
 * <p>
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 *
 * @Author: jiangfw
 * @Date: 2021-04-25
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring(""));
        System.out.println(lengthOfLongestSubstring(" "));
        System.out.println(lengthOfLongestSubstring("abba"));
    }

    private static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int maxLength = 0;

        char[] cs = s.toCharArray();
        Map<Character, Integer> hashMap = new HashMap<>();

        int startIndex = 0, endIndex = 0;
        for (int i = 0; i < cs.length; i++) {
            char c = cs[i];
            if (hashMap.containsKey(c)) {
                if ((endIndex - startIndex) > maxLength) {
                    maxLength = endIndex - startIndex;
                }
                //指针不能往前移动
                if (hashMap.get(c) >= startIndex) {
                    startIndex = hashMap.get(c) + 1;
                }
            }
            endIndex++;
            hashMap.put(c, i);
        }
        //防止不会有重复字符出现，最后做一次最大长度的对比
        if ((endIndex - startIndex) > maxLength) {
            maxLength = endIndex - startIndex;
        }
        return maxLength;
    }
}
