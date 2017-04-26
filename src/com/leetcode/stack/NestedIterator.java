package com.leetcode.stack;


import java.util.Iterator;
import java.util.List;
import java.util.Stack;



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
