package com.leetcode.string;

/**
 * Created by guangoon on 7/28/17.
 */
public class DetectCapital {
    public boolean detectCapitalUse(String word) {
        if(word.length() == 0)
            return false;
        if(word.length() == 1)
            return true;
        boolean upStart = Character.isUpperCase(word.charAt(0)) ? true : false;
        boolean up2Start =  Character.isUpperCase(word.charAt(1)) ? true : false;
        if(!upStart && up2Start){
            return false;
        }
        for(int i = 2; i < word.length(); i++){

            if(upStart){
                if(up2Start){
                    if(!Character.isUpperCase(word.charAt(i)))
                        return false;
                }else{
                    if(!Character.isLowerCase(word.charAt(i)))
                        return false;
                }
            }else{
                if(!Character.isLowerCase(word.charAt(i)))
                    return false;
            }

        }
        return true;
    }
}
