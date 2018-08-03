package com.imooc.solution;

/**
 * 递归删除
 * 1->2->3->4->5->6->NULL
 * 1->3->4->5->6->NULL
 */
public class LeetCode203_2 {


    public ListNode removeElements(ListNode head, int val) {
            if (head==null){
                return null;
            }
           /* ListNode res =removeElements(head.next,val);
            if (head.val==val){
               return res;
            }else{
                head.next=res;
                return head;*/
           head.next =removeElements(head.next,val);
           return head.val==val ? head.next : head;
        }



    public static void main(String[] args) {
        LeetCode203_2 leetCode203_2 =new LeetCode203_2();
            int [] nums={1,2,3,4,5,6};
        ListNode listNode1 = new ListNode(nums);
        System.out.println(listNode1);
        ListNode listNode = leetCode203_2.removeElements(listNode1, 2);
        System.out.println(listNode);
    }

}
