package com.imooc.stack.test;

import com.imooc.stack.ArrayStack;
import com.imooc.stack.LinkedListStack;
import com.imooc.stack.Stack;

import java.util.Random;

public class StackTest {


    public static void main(String[] args) {

        int opCount = 10000;
        ArrayStack  arrayStack= new ArrayStack();
        double time1=StackTest.testStack(arrayStack,opCount);
        System.out.printf("ArrayStack,time:%ss%n", time1);

        LinkedListStack linkedListStack = new LinkedListStack();
        double time2 =StackTest.testStack(linkedListStack,opCount);

        System.out.printf("LinkedListStack,time:%ss%n", time2);

//        ArrayStack,time:0.029020451s
//        LinkedListStack,time:0.022125542s

    }

    //测试使用s运行opCount个 push 和pop操作所需要的时间，单位：秒
    private static double testStack(Stack<Integer> s, int opCount){

        long startTime =System.nanoTime();

        Random random = new Random();
        for(int i=0;i<opCount;i++){
            s.push(random.nextInt(Integer.MAX_VALUE));
        }

        for (int i=0 ;i<opCount; i++){
            s.pop();
        }

        long endTime =System.nanoTime();
        return (endTime-startTime)/1000000000.0;
    }
}
