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
    //dunno if this is the prettiest way of doing this but oh well
    public boolean isAllNull(ListNode[] lists) {
        boolean isAllNull = true;

        if (lists == null) return true;

        for (ListNode temp : lists) {
            if (temp != null) {
                isAllNull = false;
            } else {
                continue;
            }
        }

        return isAllNull;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0 || isAllNull(lists)) {
            return null;
        }

        List<ListNode> nodeList = new ArrayList<>();
        ListNode head;

        // Add non-null lists to nodeList
        for (ListNode temp : lists) {
            if (temp != null) {
                nodeList.add(temp);
            }
        }

        // Concatenate lists
        ListNode tempHead = nodeList.get(0);
        head = tempHead;

        for (ListNode temp : nodeList) {
            if (tempHead == temp) {
                continue;
            } else {
                // Iterate tempHead to the end of its list
                if (tempHead.next != null) {
                    while (tempHead.next != null) {
                        tempHead = tempHead.next;
                    }
                }

                tempHead.next = temp;
                tempHead = tempHead.next;
            }
        }

        // Insert all values into list
        List<Integer> intList = new ArrayList<>();
        ListNode tempNode = head;
        boolean isNextNull = false;

        while (isNextNull == false) {
            intList.add(tempNode.val);

            if (tempNode.next == null) {
                isNextNull = true;
            }

            tempNode = tempNode.next;
        }

        // Sort list
        Collections.sort(intList);

        // Insert back into linked list
        tempNode = head;

        for (int i : intList) {
            tempNode.val = i;

            if (tempNode.next == null) {
                break;
            }

            tempNode = tempNode.next;
        }

        return head;
    }
}