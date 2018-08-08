package com.imooc.hash;

/**
 * @Author peterlee
 * @Date 2018/8/8 下午2:38
 * @Describtion :
 */
public class test {

    public static void main(String[] args) {
        MyHashTable hashTable =new MyHashTable();
        hashTable.add(0,"value=0");
        hashTable.add(1,"value=1");
        hashTable.add(2,"value=2");
        hashTable.add(3,"value=3");
        /*for (int i =0;i<hashTable.getSize();i++){
            System.out.println(hashTable.get(i));
        }*/
        hashTable.remove(1);
        for (int i =0;i<hashTable.getSize();i++){
            System.out.println(hashTable.get(i));
        }
    }
}
