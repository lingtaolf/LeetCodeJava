package No2_woNumberSum;

import common.ListNode;

/**
 * @Description TODO
 * @Author tao.ling
 * @Date 2024/4/24
 **/
public class Main {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        ListNode header = null;
        ListNode nextNode = null;
        ListNode preNode = null;
        int carry = 0;

        while (true) {
            if (l1 == null && l2 == null && carry == 0)
                break;

            if (nextNode == null)
                nextNode = new ListNode(0);

            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;

            int nodeRes = val1 + val2 + carry;
            carry = nodeRes / 10 ;
            int nodeVal = nodeRes % 10;

            nextNode.val = nodeVal;

            if (header == null)
                header = nextNode;

            nextNode.next = new ListNode(0);
            preNode = nextNode;
            nextNode = nextNode.next;

            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        if (nextNode.val == 0) {
            preNode.next = null;
        }
        return header;
    }

    public static void main(String[] args) {
        // 123
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        l1.next.next.next = new ListNode(9);
        l1.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next = new ListNode(9);
        // 34
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        l2.next.next.next = new ListNode(9);
        System.out.println("l1:");
        ListNode tmp_l1 = l1;
        while(true)
        {
            if (tmp_l1 != null) {
                System.out.print(tmp_l1.val);
                tmp_l1 = tmp_l1.next;
            }
            else
                break;
        }
        System.out.println();
        ListNode tmp_l2 = l2;
        System.out.println("l2:");
        while(true)
        {
            if (tmp_l2 != null) {
                System.out.print(tmp_l2.val);
                tmp_l2 = tmp_l2.next;
            }
            else
                break;
        }
        System.out.println();
        ListNode res = addTwoNumbers(l1, l2);
        ListNode tmp_res = res;
        System.out.println("res:");
        while(true)
        {
            if (tmp_res != null) {
                System.out.print(tmp_res.val);
                tmp_res = tmp_res.next;
            }
            else
                break;
        }
    }
}


