package com.imooc.map;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * leetCode 349
 * int[1,2,2,3]
 * int[2,2]
 * 不重复的交集:[2]
 */
public class LeetCode349 {

    public int[] executor(int[] num1,int[] num2){
        TreeSet<Integer> set =new TreeSet<Integer>();
        for (int i : num1) {
            set.add(i);
        }

        ArrayList<Integer> list =new ArrayList<Integer>();
        for (Integer n:set) {
            if (set.contains(n)){
                list.add(n);
                set.remove(n);
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i <res.length ; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

}
