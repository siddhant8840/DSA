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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int c=0;
        ListNode dummy=new ListNode(-1);
    ListNode curr=dummy;

          while(l1!=null||l2!=null||c!=0){
            int v1=0;
            int v2=0;
            if(l1!=null){
                v1=l1.val;
            }
            if(l2!=null){
                v2=l2.val;
            }
            int sum=v1+v2+c;
            c=sum/10;
            curr.next=new ListNode(sum%10);
            curr=curr.next;
           if (l1 != null)
                l1 = l1.next;
            

            if (l2 != null) 
                l2 = l2.next;
            
          
          }return dummy.next;

        
     
    }
}