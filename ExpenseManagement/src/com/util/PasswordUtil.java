package com.util;

import java.util.Random;

public class PasswordUtil {
	private static char[] specialCharArray = null;
	private static char[] lowerCaseAlphabatesArray = new char['z' - 'a' + 1];
	private static char[] upperCaseAlphabatesArray = new char['Z' - 'A' + 1];

	static {
		specialCharArray = new char[] { '!', '@', '#', '$', '%', '^', '&', '*', '_' };
		int index = 0;
		for (char lowerCh = 'a', upperCh = 'A'; lowerCh <= 'z'; lowerCh++, upperCh++) {
			lowerCaseAlphabatesArray[index] = lowerCh;
			upperCaseAlphabatesArray[index++] = upperCh;
		}
	}

	public static void main(String a[]) {
		PasswordUtil util = new PasswordUtil();
		for (int i = 0; i < 10; i++) {
			System.out.println(util.generatePassword());
		}
	}

	public String generatePassword() {
		boolean foundLower = false, foundUpper = false, foundSpecial = false;
		int size = 0;
		Random random = new Random();
		StringBuffer pwd = new StringBuffer();
		while (true) {
			int charDecider = random.nextInt(3);
			switch (charDecider) {
			case 0:
				if (!foundSpecial) {
					pwd.append(specialCharArray[random.nextInt(specialCharArray.length - 1)]);
					foundSpecial = true;
					size++;
				} else {
					continue;
				}
				// Special Character;
				break;
			case 1:
				if (!foundLower) {
					foundLower = true;
				}
				if (size <= 9) {
					pwd.append(lowerCaseAlphabatesArray[random.nextInt(lowerCaseAlphabatesArray.length - 1)]);
					size++;
				}
				break;
			case 2:
				// Upper alphabate
				if (!foundUpper) {
					foundUpper = true;
					pwd.append(upperCaseAlphabatesArray[random.nextInt(upperCaseAlphabatesArray.length - 1)]);
					size++;
				}
				break;
			}

			if (foundLower && foundUpper && foundSpecial && size >= 6) {
				break;
			}
		}
		return pwd.toString();
	}
}
