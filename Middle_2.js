// 2. Add Two Numbers
// Medium

// You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

// You may assume the two numbers do not contain any leading zero, except the number 0 itself.

// Example:

// Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
// Output: 7 -> 0 -> 8
// Explanation: 342 + 465 = 807.

/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */

var addTwoNumbers = function(l1, l2) {
    let temp1 = l1.val;
    let temp2 = l2.val;
    let l3 =  new ListNode((temp1 + temp2)%10)
    let carry = (temp1+temp2>9)?1:0;  
    let head = l3
        // console.log(head,l3)
    while( !(l1.next == null && l2.next == null)){
        if (l1.next!=null){
            l1= l1.next
            temp1 = l1.val   
        } else {
            temp1 = 0
        }
        if (l2.next!=null){
            l2= l2.next
            temp2 = l2.val
        } else {
            temp2 = 0
        }
        l3.next= new ListNode((temp1+ temp2+carry) %10)
        l3 = l3.next;
        carry = (temp1+temp2+carry>9)?1:0;  
    }
    l3.next= carry===1? new ListNode(1): null
    return head;
};