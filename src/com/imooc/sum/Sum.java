package com.imooc.sum;

/**
 * 数组递归：简单递归
 */
public class Sum {

    //调用方法
    public int sum(int[] arr){
        return sum(arr,0);
    }

    /**
     * 计算：从数组左边l开始计算数组的和
     *  arr[l,n)的值
     * @param arr
     * @param l  左边开始
     * @return
     */
    private int sum(int[] arr ,int l){
        //如果数组大小和左端相等，说明数组的长度为0 值为0
        if (arr.length ==l){
            return 0;
        }
        //递归：左边界+1 直到 左边界和数组的长度相同
        return arr[l]+sum(arr,l+1);
    }

    public static void main(String[] args) {
        int[] nums ={1,2,3,4,5,6,7,8,9,10};
        System.out.println(new Sum().sum(nums));
    }


}
