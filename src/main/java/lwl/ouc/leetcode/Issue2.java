package lwl.ouc.leetcode;

public class Issue2 {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(2);
        listNode1.next = new ListNode(4);
        listNode1.next.next = new ListNode(3);
        
        ListNode listNode2 = new ListNode(5);
        listNode2.next = new ListNode(6);
        listNode2.next.next = new ListNode(4);

        addTwoListNode(listNode1, listNode2);
    }

    public static ListNode addTwoListNode(ListNode listNode1, ListNode listNode2) {
        StringBuilder sc = new StringBuilder();
        sc.append("Input: (").append(listNode1).append(") + (").append(listNode2).append(")");
        System.out.println(sc.toString());
        ListNode res = new ListNode(0);
        ListNode current = res;
        int carry = 0;
        while (listNode1 != null || listNode2 != null) {
            int val1 = listNode1 == null ? 0 : listNode1.val;
            int val2 = listNode2 == null ? 0 : listNode2.val;
            int sum = val1 + val2 + carry;
            carry = sum >= 10 ? 1 : 0;
            current.next = new ListNode(sum % 10);
            current = current.next;
            listNode1 = listNode1.next;
            listNode2 = listNode2.next;
        }
        if (carry == 1) {
            current.next = new ListNode(1);
        }
        System.out.println(String.format("OutPut:%s", res.next));
        return res.next;
    }
}

class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        StringBuilder sbBuilder = new StringBuilder();
        ListNode cListNode = this;
        while (null != cListNode) {
            sbBuilder.append(cListNode.val);
            cListNode = cListNode.next;
            if (null != cListNode) {
                sbBuilder.append(" -> ");
            }
        }
        return sbBuilder.toString();
    }
}
