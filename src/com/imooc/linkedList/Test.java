package com.imooc.linkedList;

public class Test {

    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList =new MyLinkedList();
        for (int i=0; i<5;i++){
            myLinkedList.addFirst(i);
            System.out.println(myLinkedList);
        }
        myLinkedList.add(2,2222);
        System.out.println(myLinkedList);

//        0->NULL
//        1->0->NULL
//        2->1->0->NULL
//        3->2->1->0->NULL
//        4->3->2->1->0->NULL
//        4->3->2222->2->1->0->NULL
    }
}
