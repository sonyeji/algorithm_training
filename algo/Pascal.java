package com.ssafy.edu;

public class Pascal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(pascal(15, 3));
	}

	public static int pascal(int n, int r) {
		if(r == 0) {
			return 1;
		}else if(n == r) {
			return 1;
		}else {
			return (pascal(n-1, r-1) + pascal(n-1, r));
		}
	}
}
