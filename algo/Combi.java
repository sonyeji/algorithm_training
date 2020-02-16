package com.ssafy.edu;

import java.util.Arrays;

public class Combi {

	static int[] num;
	static int it = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//5C3
		num = new int[3];
		it = 0;
		combi(4, 3, 0, 0);
		System.out.println(it);
	}

	public static void combi(int n, int r, int start, int count) {
		if(count == r) {
			it++;
			System.out.println(Arrays.toString(num));
			return;
		}
		for (int i = start; i < n; i++) {
			num[count] = i+1;
			combi(n, r, i+1, count+1);
		}
	}
}
