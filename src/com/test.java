package com;

import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		
		test test = new test();
		test.main();
	}

	public void main() {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		String string = scanner.next();
		for (int i = 0; i < n; i++) {
			string = name(string);
		}
		System.out.println(string.length());
	}

	public String name(String string) {
		for (int i = 0; i < string.length(); i++) {
			char c = string.charAt(i);
			if (c == '0') {
				if ((i + 1) <= string.length() - 1) {
					if (string.charAt(i + 1) == '1') {
						string = string.substring(0, i) + string.substring(i + 2);
						break;
					}
				}
			}
			if (c == '1') {
				if ((i + 1) <= string.length() - 1) {
					if (string.charAt(i + 1) == '0') {
						string = string.substring(0, i) + string.substring(i + 2);
						break;
					}
				}
			}
		}

		return string;
	}

}
