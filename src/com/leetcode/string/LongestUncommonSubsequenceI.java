package com.leetcode.string;

/**
 * Created by guangoon on 7/28/17.
 */
public class LongestUncommonSubsequenceI {
    public int findLUSlength(String a, String b) {
        if (a.equals(b))
            return -1;
        return Math.max(a.length(), b.length());
    }
}
