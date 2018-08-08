package com.imooc.set;

import java.util.ArrayList;

public class test {

    public static void main(String[] args) {
        System.out.println("pride and prijudice");
        ArrayList<String> words1 = new ArrayList();
        FileOperation.readFile("/Users/ligang/IdeaProjects/array/src/com/imooc/set/pride-and-prejudice.txt",words1);
        System.out.println(" Total words: " + words1.size());

        BinarySearchSet<String> set =new BinarySearchSet();
        for (String s : words1){
            set.add(s);
        }
        System.out.println("Total distinct words: " + set.getSize());
    }
}
