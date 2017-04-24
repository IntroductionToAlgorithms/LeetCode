package com.leetcode.stack;


import java.util.Iterator;
import java.util.List;
import java.util.Stack;

// This is the interface that allows for creating nested lists.
  // You should not implement it, or speculate about its implementation
   interface NestedInteger {

      // @return true if this NestedInteger holds a single integer, rather than a nested list.
      public boolean isInteger();

      // @return the single integer that this NestedInteger holds, if it holds a single integer
      // Return null if this NestedInteger holds a nested list
      public Integer getInteger();

      // @return the nested list that this NestedInteger holds, if it holds a nested list
      // Return null if this NestedInteger holds a single integer
      public List<NestedInteger> getList();
  }

public class NestedIterator implements Iterator<Integer> {

    Stack<NestedInteger> stack = new Stack<NestedInteger>();
    public NestedIterator(List<NestedInteger> nestedList) {
        for(int i = nestedList.size() - 1; i >= 0; i--){
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while(!stack.isEmpty()){
            NestedInteger cur = stack.peek();
            if(!cur.isInteger()){
                List<NestedInteger> listInteger = stack.pop().getList();
                for(int j = listInteger.size() - 1; j >= 0; j--){
                    stack.push(listInteger.get(j));
                }
            }else{
                return true;
            }
        }
        return false;
    }
}
