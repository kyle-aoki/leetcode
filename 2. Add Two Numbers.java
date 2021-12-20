class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode placeholder = new ListNode();
        ListNode head = placeholder;
        boolean addOne = false;
        while (!(l1 == null && l2 == null)) {
            int n1;
            int n2;
            if (l1 != null) {
                n1 = l1.val;
                l1 = l1.next;
            } else {
                n1 = 0;
            }
            if (l2 != null) {
                n2 = l2.val;
                l2 = l2.next;
            } else {
                n2 = 0;
            }
            int sum = n1 + n2;
            if (addOne) {
                sum += 1;
                addOne = false;
            }
            if (sum >= 10) {
                addOne = true;
                sum = sum % 10;
            }
            placeholder.val = sum;
            if (!(l1 == null && l2 == null)) {
                placeholder.next = new ListNode();
                placeholder = placeholder.next;
            }
        }
        if (addOne) {
            placeholder.next = new ListNode(1);
        }
        return head;
    }
}
