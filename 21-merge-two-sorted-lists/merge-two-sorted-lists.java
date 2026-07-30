/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
       ArrayList <Integer> arr=new ArrayList<>();
       while(l1!=null){
        arr.add(l1.val);
        l1=l1.next;}

        while(l2!=null){
            arr.add(l2.val);
            l2=l2.next;}
        Collections.sort(arr);
        ListNode dumm=new ListNode(-1);
        ListNode curr=dumm;
        dumm.next=null;
        for(int i=0;i<arr.size();i++){
            curr.next=new ListNode(arr.get(i));
           curr=curr.next;
        }
        return dumm.next;

}

}