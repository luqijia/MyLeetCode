package link;

import java.util.Arrays;

/**
 * 合并链表
 * @author luqijia
 *
 */
public class MergeLink {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	/**
	 * 合并两个两个链表
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode result;

		if (l1 == null) {
			return l2;
		} else if (l2 == null) {
			return l1;
		}

		if (l1.val <= l2.val) {
			result = l1;
			l1 = l1.next;
		} else {
			result = l2;
			l2 = l2.next;
		}
		result.next = mergeTwoLists(l1, l2);
		return result;
	}

	/**
	 * 合并多个链表
	 * @param lists
	 * @return
	 */
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists.length == 0) {
			return null;
		} else if (lists.length == 1) {
			return lists[0];
		} else if (lists.length == 2) {
			return mergeTwoLists(lists[0], lists[1]);
		}
		return mergeTwoLists(lists[0], mergeKLists(Arrays.copyOfRange(lists, 1, lists.length)));
	}

}
