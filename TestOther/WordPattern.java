package cn.edu.cust.TestOther;

import java.util.HashMap;
import java.util.Scanner;

public class WordPattern {
	public static void main(String[] args) {
		/*
		 * String pattern = "abba"; String str = "dog cat cat dog";
		 */
		String pattern = null;// 格式
		String str = null;
		System.out.println("请输入pattern:");
		Scanner pattern_reader = new Scanner(System.in);
		pattern = pattern_reader.next();
		System.out.println("请输入str:");
		Scanner str_reader = new Scanner(System.in);
		str = str_reader.nextLine();
		System.out.print("I am coming");
		boolean flag = wordPattern(pattern, str);
		System.out.println(flag);
		System.out.println("I am back!");
		WordPattern w1 = new WordPattern();
		w1.showThis();
	}
	public void showThis(){
		System.out.println(this.toString());
	}
	static boolean wordPattern(String pattern, String str) {
		String[] arr = str.split(" ");
		char[] patternarr = pattern.toCharArray();
		if (arr.length != patternarr.length) {
			System.out.print("you are wrong_1!");
			return false;
		}
		HashMap<Character, String> hm = new HashMap<Character, String>();
		for (int i = 0; i < patternarr.length; i++) {
			char c = patternarr[i];
			String temp = arr[i];
			if (!hm.containsKey(c)) {
				if (hm.containsValue(temp)) {
					System.out.print("you are wrong_2!");
					return false;
				} else
					hm.put(c, temp);
			} else {
				if (hm.get(c).equals(temp))
					continue;
				else {
					System.out.print("you are wrong_3!");
					return false;
				}
			}

		}
		for (Character key : hm.keySet()) {
			System.out.print(key + "--->");
			System.out.println(hm.get(key));
		}
		return true;
	}
}
