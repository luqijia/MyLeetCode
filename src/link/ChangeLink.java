package link;

import link.MergeLink.ListNode;

/**
 * 两两交换链表相邻的两个节点
 * 
 * @author luqijia
 *
 */
public class ChangeLink {
	private static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
	
	/**
	 * 递归写法
	 * @param head
	 * @return
	 */
	public ListNode swapPairs1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs1(next.next);
        next.next = head;
        return next;
    }

	/**
	 * 非递归写法
	 * @param head
	 * @return
	 */
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode cur = head;
		head = head.next;
		ListNode curRight = null;
		ListNode nextCur = null;
		while (cur != null && cur.next != null) {
			curRight = cur.next;
			nextCur = curRight.next;
			curRight.next = cur;
			cur.next = nextCur;
			if (nextCur != null && nextCur.next != null) {
				cur.next = nextCur.next;
			}
			cur = nextCur;
		}
		return head;
	}

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = null;

		ChangeLink link = new ChangeLink();
		link.swapPairs1(node1);
		System.out.println("ok");
	}
}
