package com.imooc.linkedList;

import javafx.beans.binding.When;

/***
 * 链表
 * @param <E>
 */
public class MyLinkedList<E> {

    private Node dummyHead; //虚拟头节点
    private int size;

    public MyLinkedList(){
        dummyHead=new Node(null,null);
        size=0;
    }
    //获取链表的长度
    public int getSize(){
        return size;
    }
    //判断链表是否为空
    public boolean isEmpty(){
        return size==0;
    }


    //在链表的index位置添加E 元素，
    //链表中不是一个常用的操作，主要是练习用
    public void add(int index,E e){
        if (index<0 || index>size)
            throw new IllegalArgumentException("Add failed Illegal index");

        //拿到头部的节点 ，通过循环找到index位置的节点
        Node prev=dummyHead;
        for (int i=0;i<index;i++){
            prev = prev.next;
        }
        //插入中间去
           /* Node node =new Node(e);
            node.next=prev.next;
            prev.next=node;*/
        prev.next=new Node(e,prev.next);
        size++;
    }

    //在链表头部添加元素
    public void addFirst(E e){
        add(0,e);
    }

    //在链表的末尾添加一个元素
    public void addLast(E e){
        add(size,e);
    }
    //获取第index上的元素，在应用中不常用，主要练习
    public E get(int index){
        if(index<0 || index>size){
            throw new IllegalArgumentException("Get failed Illegal index");
        }
        Node cur =dummyHead;
        for (int i=0;i<index;i++){
            cur=cur.next;
        }
        return cur.e;
    }

    public E getFrist(){
        return get(0);
    }

    public E getLast(){
        return get(size-1);
    }
    //修改index位置的元素
    public void set(int index,E e){
        if (index<0 || index>size){
            throw new IllegalArgumentException("Set failed Illegal index");
        }
        Node cur =dummyHead;
        for (int i=0;i<index;i++){
          cur = cur.next;
        }
         cur.e=e;
    }
    //查找链表中是否有元素e
    public boolean constants(E e){
        Node cur=dummyHead.next;
        while (cur!=null){
            if (cur.e.equals(e)){
                return true;
            }
            cur=cur.next;
        }
        return false;
    }
    //从节点中删除一个元素，使用递归算法，适用练习
    public E remove(int index){
        if (index<0 || index>size){
            throw new  IllegalArgumentException("remove failed index Illegal");
        }
        Node prev =dummyHead;
        for (int i=0;i<index;i++){
            prev=prev.next;
        }
        //找到待删除的前一个节点
        Node retNode =prev.next;
        prev.next=retNode.next;
        retNode.next=null;
        size--;
        return retNode.e;
    }
    //从列表中删除第一个元素
    public E removeFirst(){
        return remove(0);
    }
    //从列表中删除最后一个元素
    public E removeLast(){
        return remove(size-1);
    }

    public void removeElement(E e){
        Node prev = dummyHead;
        while (prev.next!=null){
            if (prev.next.e.equals(e)){
                break;
            }
            prev = prev.next;
        }
        if (prev.next != null){
            Node delNode =prev.next;
            prev.next = delNode.next;
            delNode.next = null;
        }
    }
    //私有节点内部类
    private class Node{
        public E e;
        public Node next;
        public Node(E e,Node next){
            this.e = e;
            this.next = next;
        }
        public Node(E e){
            this(e,null);
        }
        public Node(){
            this(null,null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    @Override
    public String toString() {
        StringBuilder res=new StringBuilder();
         Node cur =dummyHead.next;
        while (cur!=null){
            res.append(cur.e+"->");
            cur=cur.next;
        }
        //下面的for和while等价
        //for (Node cur=dummyHead.next; cur!=null;cur=cur.next)

        res.append("NULL");
        return res.toString();
    }
}
