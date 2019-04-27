package string;

/**
 * 实现 strStr() 函数。
 * 
 * 给定一个 haystack 字符串和一个 needle 字符串， 在 haystack 字符串中找出 needle 字符串出现的第一个位置
 * (从0开始)。如果不存在，则返回 -1。 (找子串的位置)
 * 
 * @author luqijia
 *
 */
public class Str {
	public static int strStr(String haystack, String needle) {

		if (haystack.trim().equals("")&&needle.trim() .equals("")) {
			return 0;
		}
		if (haystack.trim().equals("")) {
			return -1;
		}
		if (needle.trim() .equals("")) {
			return 0;
		}
		int index = 0;
		boolean contains = haystack.contains(needle);
		if (contains) {
			for (int i = 0; i < haystack.length(); i++) {
				if (haystack.charAt(i) == needle.charAt(0)) {
					String substring = haystack.substring(i, i + needle.length());
					if (substring.equals(needle)) {
						index = i;
						break;
					}
				}
			}
			return index;
		} else {
			return -1;
		}
	}
	public static void main(String[] args) {
		System.out.println(strStr("aaa", "aa"));
	}
}
