package link;


/**
 * 给出一个链表，每 k 个节点一组进行翻转，并返回翻转后的链表。
 * 
 * k 是一个正整数，它的值小于或等于链表的长度。 如果节点总数不是 k 的整数倍，那么将最后剩余节点保持原有顺序。
 * 
 * @author luqijia
 *
 */
public class FilpLink {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode reverseKGroup(ListNode head, int k) {
		
		ListNode prev = null;
        ListNode cur = head;
        ListNode next = null;
        ListNode check = head;
        int canProceed = 0;
        int count = 0;
        // 检查链表长度是否满足翻转
        while (canProceed < k && check != null) {
            check = check.next;
            canProceed++;
        }
        // 满足条件，进行翻转
        if (canProceed == k) {
            while (count < k && cur != null) {   //翻转方式为头节点插入法
                next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
                count++;
            }
            if (next != null) {
                // head 为链表翻转后的尾节点
                head.next = reverseKGroup(next, k);
            }
            // prev 为链表翻转后的头结点
            return prev;
        } else {
            // 不满住翻转条件，直接返回 head 即可
            return head;
        }
	}

	/**
	 * 阿里模拟题
	 * 
	 * public static String measureDistance(List<Double> xList, List<Double> yList,
	 * double x, double y) { boolean xboo = false; boolean yboo = false; int length
	 * = 0; for (Double double1 : xList) { if (x <= double1) { xboo = true; } } for
	 * (Double double1 : yList) { if (y <= double1) { yboo = true; } } if (xboo &&
	 * yboo) { return "yes,0"; } else if (xboo) { int min = (int) (y -
	 * yList.get(0)); for (Double double1 : yList) { int tmp = (int) (y - double1);
	 * if (min >= tmp) { min = tmp; } } return "no," + String.valueOf(min); } else
	 * if (yboo) { int min = (int) (x - xList.get(0)); for (Double double1 : xList)
	 * { int tmp = (int) (x - double1); if (min >= tmp) { min = tmp; } } return
	 * "no," + String.valueOf(min); } else { for (int i = 0; i < xList.size(); i++)
	 * { Double x1 = xList.get(i); Double y1 = yList.get(i); double d =
	 * Math.sqrt(Math.pow(x - x1, 2) + Math.pow(y - y1, 2)); if (length > d) {
	 * length = (int) d; } } return "no," + String.valueOf(length); } }
	 * 
	 * public static void main(String[] args) { Scanner in = new Scanner(System.in);
	 * String line = in.nextLine(); // (x,y)为小广所在的位置 double x =
	 * Double.parseDouble(line.split(",")[0]); double y =
	 * Double.parseDouble(line.split(",")[1]);
	 * 
	 * line = in.nextLine(); // xList记录了多边形n个点的x坐标,yList记录了多边形n个点的y坐标 List<Double>
	 * xList = new ArrayList<>(); List<Double> yList = new ArrayList<>(); String[]
	 * array = line.split(","); for (int i = 0; i < array.length; i++) {
	 * xList.add(Double.parseDouble(array[i])); yList.add(Double.parseDouble(array[i
	 * + 1])); i++; } in.close(); System.out.println(measureDistance(xList, yList,
	 * x, y)); }
	 */
}
