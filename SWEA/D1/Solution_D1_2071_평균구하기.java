package com.ssafy.edu;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_D1_2071_평균구하기{

	static int iT;
	static int n = 10;
	static int[] num;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//string : ����Ÿ��(�޼ҵ� ����)�ε� copy by value ��
		Scanner sc = new Scanner(System.in);
		iT = sc.nextInt();
	
		for(int i = 1; i <= iT; i++) {
			num = new int[n];
			
			int sum = 0;
			
			for(int j = 0; j < n; j++) {
				num[j] = sc.nextInt();
				sum += num[j];
			}
			Arrays.sort(num);
			
			System.out.println("#"+i+" " + Math.round(sum/10.0));
		}
	}

}
