package stringChangeInteger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串转换成整数
 * @author luqijia
 *
 */

public class Solution {
	public int myAtoi(String str) {
		int result = 0;
		String trim = str.trim();
		if (trim.equals("")) {
			return result;
		}
		Pattern pattern = Pattern.compile("\\d+");
		Matcher matcher = pattern.matcher(trim);
		char charAt = trim.charAt(0);
		if (matcher.lookingAt()) { // 开头就为数字的情况
			trim = trim.substring(0, matcher.end());
		} else if (charAt == '+' || charAt == '-') { // 开头为+或-的情况
			if (matcher.find()) {
				if (matcher.start() == 1) {
					trim = trim.substring(matcher.start(), matcher.end());
				} else {
					trim = "0";
				}
			} else {
				trim = "0";
			}
			trim = charAt + trim;
		} else {
			trim = "0";
		}
		if (Pattern.matches("[+]+", trim) || Pattern.matches("[-]+", trim)) {
			result = 0;
		} else {
			if (Double.parseDouble(trim) > Integer.MAX_VALUE) {
				result = Integer.MAX_VALUE;
			} else if (Double.parseDouble(trim) < Integer.MIN_VALUE) {
				result = Integer.MIN_VALUE;
			} else {
				result = Integer.parseInt(trim);
			}
		}
		System.out.println("result:" + result);
		return result;
	}
}