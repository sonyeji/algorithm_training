package com.ssafy.edu;

import java.util.Scanner;
import java.util.Stack;
import java.util.HashMap;

public class Solution_D4_1218_괄호짝짓기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int T;
		T=10;
		HashMap<Character, Character> map = new HashMap<>();
		map.put(')', '(');
		map.put(']', '[');
		map.put('}', '{');
		map.put('>', '<');

		for(int test_case = 1; test_case <= T; test_case++)
		{
			Stack<Character> stack = new Stack<>();
			
			int inputLength = sc.nextInt();
			String input = sc.next();
			char[] data = input.toCharArray();
			char tmp;
			int bool = 1;
			
			for (int i = 0; i < inputLength; i++) {
				tmp = data[i];
				if(tmp == '(' || tmp == '{' || tmp == '[' || tmp == '<') {
					stack.push(tmp);
				}else {
					if(!stack.isEmpty() && map.get(tmp) == stack.peek()) {
						stack.pop();
					}else {
						bool = 0;
						break;
					}
				}
			}
			if(!stack.isEmpty()) {
				bool = 0;
			}
			
			System.out.println("#" + test_case + " " + bool);
		}
		sc.close();
	}

}
