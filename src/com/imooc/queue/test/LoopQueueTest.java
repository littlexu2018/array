package com.imooc.queue.test;

import com.imooc.queue.LoopQueue;

public class LoopQueueTest {

    public static void main(String[] args) {
        LoopQueue<Integer> loopQueue =new LoopQueue();
        for(int i=0;i<10;i++){
            loopQueue.enqueue(i);
            System.out.println(loopQueue);
            if(i%3 ==2){
                loopQueue.dequeue();
                System.out.println(loopQueue);
            }
        }
    }
}
