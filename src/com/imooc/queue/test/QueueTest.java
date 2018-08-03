package com.imooc.queue.test;

import com.imooc.queue.ArrayQueue;
import com.imooc.queue.LinkedListQueue;
import com.imooc.queue.LoopQueue;
import com.imooc.queue.Queue;

import java.util.Random;

public class QueueTest {


    public static void main(String[] args) {

        int opCount = 100000;
        ArrayQueue arrayQueue = new ArrayQueue();
        double time1=QueueTest.testQueue(arrayQueue,opCount);
        System.out.printf("ArrayQueue,time:%ss%n", time1);

        LoopQueue loopQueue = new LoopQueue();
        double time2 =QueueTest.testQueue(loopQueue,opCount);

        System.out.printf("LoopQueue,time:%ss%n", time2);

        LinkedListQueue linkedListQueue = new LinkedListQueue();
        double time3 =QueueTest.testQueue(linkedListQueue,opCount);

        System.out.printf("LinkedListQueue,time:%ss%n", time3);

//        ArrayQueue,time:4.173274892s
//        LoopQueue,time:0.017335558s

    }

    //测试使用Q运行opCount个 enqueueu 和dequeue操作所需要的时间，单位：秒
    private static double testQueue(Queue<Integer> q,int opCount){

        long startTime =System.nanoTime();

        Random random = new Random();
        for(int i=0;i<opCount;i++){
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }

        for (int i=0 ;i<opCount; i++){
            q.dequeue();
        }

        long endTime =System.nanoTime();
        return (endTime-startTime)/1000000000.0;
    }
}
