package com.imooc.solution;


/**
 * 从链表中删除元素
 * 1->2->3->4->5->6->NULL
 * 1->3->4->5->6->NULL
 */
public class LeetCode203 {


    public ListNode  removeElements(ListNode head, int val) {

        ListNode dummyHead =new ListNode(-1);
        dummyHead.next=head;

        ListNode prev =dummyHead;
        while (prev.next !=null){
            if (prev.val == val){
                prev.next = prev.next.next;
            }else{
                prev=prev.next;
            }
        }
        return dummyHead.next;

    }

    public static void main(String[] args) {
        LeetCode203 leetCode203 =new LeetCode203();
            int [] nums={1,2,3,4,5,6};
        ListNode listNode1 = new ListNode(nums);
        System.out.println(listNode1);
        ListNode listNode = leetCode203.removeElements(listNode1, 2);
        System.out.println(listNode);
    }

}
