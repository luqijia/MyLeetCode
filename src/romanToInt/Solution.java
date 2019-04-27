package romanToInt;

public class Solution {
	public int romanToInt(String s) {
		int num = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == 'I') {
				if ((i + 1) <= s.length() - 1) {
					if (s.charAt(i + 1) == 'V') {
						num += 4;
						i ++;
						continue;
					} else if (s.charAt(i + 1) == 'X') {
						num += 9;
						i ++;
						continue;
					} else {
						num += 1;
					}
				} else {
					num += 1;
				}
			}
			if (c == 'V') {
				num += 5;
			}
			if (c == 'X') {
				if ((i + 1) <= s.length() - 1) {
					if (s.charAt(i + 1) == 'L') {
						num += 40;
						i ++;
						continue;
					} else if (s.charAt(i + 1) == 'C') {
						num += 90;
						i ++;
						continue;
					} else {
						num += 10;
					}
				} else {
					num += 10;
				}
			}
			if (c == 'L') {
				num += 50;
			}
			if (c == 'C') {
				if ((i + 1) <= s.length() - 1) {
					if (s.charAt(i + 1) == 'D') {
						num += 400;
						i ++;
						continue;
					} else if (s.charAt(i + 1) == 'M') {
						num += 900;
						i ++;
						continue;
					} else {
						num += 100;
					}
				} else {
					num += 100;
				}
			}
			if (c == 'D') {
				num += 500;
			}
			if (c == 'M') {
				num += 1000;
			}
		}

		return num;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.romanToInt("MCMXCIV"));
	}
}