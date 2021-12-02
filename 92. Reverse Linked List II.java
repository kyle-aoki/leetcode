class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode prev = null;
        ListNode node = head;

        int index = 1;
        boolean isFirst = false;
        boolean adjacent = right - left == 1;

        ListNode pln = null;
        ListNode ln = null;
        ListNode prn = null;
        ListNode rn = null;


        while (node != null) {
            if (index == left) {
                isFirst = index == 1;
                pln = prev;
                ln = node;
            } else if (left < index && index < right) {
                ListNode nextNode = node.next;
                node.next = prev;
                prev = node;
                node = nextNode;
                index++;
                continue;
            } else if (index == right) {
                boolean isLast = node.next == null;
                rn = node;

                if (isFirst && isLast) {
                    ln.next = null;
                    if (adjacent) rn.next = ln;
                    else rn.next = prev;

                    return rn;
                }

                prn = rn.next;

                if (adjacent) {
                    ln.next = null;
                    rn.next = ln;
                } else {
                    rn.next = prev;
                }

                if (!isFirst) {
                    pln.next = rn;
                }
                if (!isLast) {
                    ln.next = prn;
                } else {
                    ln.next = null;
                }
                
                if (isFirst) return rn;
                
                return head;
            }

            index++;
            prev = node;
            node = node.next;
        }

        return head;
    }
}
