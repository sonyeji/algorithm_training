package baek0210;

import java.util.Scanner;

public class baek_2567_»öÁ¾ÀÌ2{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[][] map = new int[102][102];
		int N = sc.nextInt();
		
		for (int i = 0; i < N; i++) {
			int y = sc.nextInt();
			int x = sc.nextInt();
			
			for (int j = y+1; j < y+11; j++) {
				for (int k = x+1; k < x+11; k++) {
					map[j][k] = 1;
				}
			}
		}
		
		int sum = 0;
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if(i+1 < 102 && map[i][j] != map[i+1][j]) {
					sum += 1;
				}
				if(j+1 < 102 && map[i][j] != map[i][j+1]) {
					sum += 1;
				}
			}
		}
		
		System.out.println(sum);
		
		
	}

}