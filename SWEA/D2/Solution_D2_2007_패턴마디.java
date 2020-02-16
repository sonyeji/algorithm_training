package com.ssafy.edu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D2_2007_패턴마디 {

	static int T;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			String input = br.readLine();
			int result = Integer.MAX_VALUE;
			int index = 0;
			
			for(int i = 1; i <= 10; i++) {
				String madi = input.substring(0, i);
				String s1 = input.replace(madi, "");
				if(s1.length() < result) {
					result = s1.length();
					index = i;
					if(result == 0)	break;
				}
			}
			
			System.out.println("#" + test_case +" " + index);
		}
		
	}

}
