package string;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 
 * 如果不存在公共前缀，返回空字符串 ""。
 * 
 * 思路：以第一个字符串为基准，获取字符串的第一个字符，比较剩下的字符串的第一个字符是否与第一个字符串的第一个字符相等，
 * 	如果都相等则继续以第一个字符串的第二个字符作为标准，继续比较。
 * 	当某一时刻出现与基准的字符不相等时，就完成公共前缀的查找。或者找到字符数组中最短的字符串时也结束查找
 * 
 * @author luqijia
 *
 */
public class LongestCommonPrefix {
	public static String longestCommonPrefix(String[] strs) {
		if (strs.length == 0 || strs == null) {
			return "";
		}
		for (int j = 0; j < strs[0].length(); j++) {  
			char c = strs[0].charAt(j);
			for (int i = 1; i < strs.length; i++) {
				if (j == strs[i].length() || strs[i].charAt(j) != c) { //找到最短的字符串时或者当前字符不在相等
					return strs[0].substring(0, j);
				}
			}
		}
		return strs[0];
	}

	public static void main(String[] args) {
		String[] strs = { "a", "b" };
		System.out.println(longestCommonPrefix(strs));
	}
}
