package swea0217;


import java.util.Scanner;

public class Solution_D3_5515_요일맞추기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int m = sc.nextInt();
			int d = sc.nextInt();
			
			int now = 4;
			
			int pass = 0;
			switch(m) {
			case 12:pass+=30;
			case 11:pass+=31;
			case 10:pass+=30;
			case 9:pass+=31;
			case 8:pass+=31;
			case 7:pass+=30;
			case 6:pass+=31;
			case 5:pass+=30;
			case 4:pass+=31;
			case 3:pass+=29;
			case 2:pass+=31;
			default:break;
			}
			pass = pass + now + d - 1;
			pass %= 7;
			System.out.println("#" + tc + " " + pass);
		}
	}

}
