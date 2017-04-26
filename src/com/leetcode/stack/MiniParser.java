package com.leetcode.stack;

import java.util.List;
import java.util.Stack;

/**
 * Created by guangoon on 17-4-26.
 */



  class NestedIntegeri implements  NestedInteger{

    public NestedIntegeri(){

    }

    // Constructor initializes a single integer.
    public NestedIntegeri(int value){

    }
      @Override
      public boolean isInteger() {
          return false;
      }

      @Override
      public Integer getInteger() {
          return null;
      }

      @Override
      public List<NestedInteger> getList() {
          return null;
      }

    public void add(NestedInteger ni){

    }
  }

public class MiniParser {
    public NestedInteger deserialize(String s) {
        if(s == null || s.length() <= 0)
            return null;
        if(!s.startsWith("["))
            return new NestedIntegeri(Integer.valueOf(s));
        Stack<NestedInteger> stack = new Stack<NestedInteger>();
        int l = 0;
        NestedInteger cur = null;
        for(int r = 0; r < s.length(); r++){
            if(s.charAt(r) == '[') {
                if(cur != null){
                    stack.push(cur);
                }
                cur = new NestedIntegeri();
                l = r + 1;
            }else if(s.charAt(r) == ']'){
                String num = s.substring(l,r);
                if(!num.isEmpty()){
                    cur.add(new NestedIntegeri(Integer.valueOf(num)));
                }
                if(!stack.isEmpty()){
                    NestedInteger nestedInteger = stack.pop();
                    nestedInteger.add(cur);
                    cur = nestedInteger;
                }
                l = r + 1;
            }else if(s.charAt(r) == ','){
                if(s.charAt(r - 1) != ']'){
                    String num = s.substring(l,r);
                    cur.add(new NestedIntegeri(Integer.valueOf(num)));
                }
                l = r + 1;
            }
        }
        return cur;
    }
}
