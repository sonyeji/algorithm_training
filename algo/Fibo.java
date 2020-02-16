package com.ssafy.edu;

public class Fibo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fibo(8));
		System.out.println(1.0*fibo(25)/fibo(26));
	}
	
	public static int fibo(int n) {
		if(n == 1) {
			return 1;
		}else if(n == 2) {
			return 1;
		}else {
			return (fibo(n-1) + fibo(n-2));
		}
	}

}
