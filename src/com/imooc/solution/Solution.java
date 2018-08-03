package com.imooc.solution;

import com.imooc.stack.ArrayStack;

import java.util.Stack;

/**
 * import java.util.Stack;
 * 对栈的使用（先进后出的模式【杯子】）
 * LeetCode :20
 *
 */
class Solution {
    public boolean isValid(String s){
        ArrayStack<Character> stack =new ArrayStack();
        for (int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if (c=='(' || c=='{' || c=='['){
                stack.push(c);
            }else{
                if (stack.isEmpty()){
                    return false;
                }
                char topChar =stack.pop();
                if (c==')' && topChar !='(')
                    return false;
                if (c=='}' && topChar !='{')
                    return false;
                if (c==']' && topChar !='[')
                    return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        boolean result =new Solution().isValid("()[]{}");
        System.out.println(result);
    }
}
