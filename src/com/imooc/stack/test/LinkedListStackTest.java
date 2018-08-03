package com.imooc.stack.test;

import com.imooc.stack.LinkedListStack;

public class LinkedListStackTest {

    public static void main(String[] args) {
        LinkedListStack<Integer> stack =new LinkedListStack();
        for (int i=0; i < 10; i ++){
            stack.push(i);
            System.out.println(stack);
        }
        stack.pop();
        System.out.println(stack);
    }

}
