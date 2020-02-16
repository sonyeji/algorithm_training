package com.ssafy.edu;

import java.util.Arrays;

public class Perm {

	static int[] num;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		num = new int[3];
		perm(5, 3, 0, 0);
	}

	public static void perm(int n, int r, int flag, int count) {
		if(count == r) {
			System.out.println(Arrays.toString(num));
			return;
		}
		
		for (int i = 0; i < n; i++) {
//			if( (flag & 1 << i) != 0 ) {
//				continue;
//			}
			
			if( (flag & 1 << i) == 0 ) {
				num[count] = i+1;
				perm(n, r, flag| 1<<i, count+1);
			}
			
		}
	}
}
