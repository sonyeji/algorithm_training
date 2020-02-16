package com.ssafy.edu;

import java.util.Scanner;
import java.util.Stack;

public class Solution_D3_8931_제로 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			Stack<Integer> stack = new Stack<>();
			int K = sc.nextInt();
			for (int i = 0; i < K; i++) {
				int n = sc.nextInt();
				
				if(n == 0) {
					stack.pop();
				}else {
					stack.push(n);
				}
			}
			
			int sum = 0;
			
			while(!stack.isEmpty()) {
				sum += stack.pop();
			}
			
			System.out.println("#" + test_case +" " + sum);
		}
	}

}
