package com.leetcode.string;

/**
 * Created by guangoon on 7/28/17.
 */
public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] R = new int[26];
        for(int i = 0; i < magazine.length(); i++){
            R[magazine.charAt(i) - 'a']++;
        }

        for(int i = 0; i < ransomNote.length(); i++){
            if(R[ransomNote.charAt(i) - 'a'] > 0){
                R[ransomNote.charAt(i) - 'a']--;
            }else{
                return false;
            }
        }
        return true;
    }
}
