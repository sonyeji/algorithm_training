package swea0228;

import java.util.Scanner;

public class Solution_swtest_1952_수영장 {
	
	static int[] price;
	static int[] month;
	static int[] prices;
	static int[] minPrice;
	public static void main(String[] args) {
		Scanner	sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			price = new int[4];
			month = new int[13];
			minPrice = new int[13];
			prices = new int[13];
			for (int i = 0; i < 4; i++) {
				price[i] = sc.nextInt();
			}
			for (int i = 1; i <= 12; i++) {
				month[i] = sc.nextInt();
			}
			
			for (int i = 1; i <= 12; i++) {
				prices[i] = Math.min(month[i] * price[0], price[1]);
			}
			
			for (int i = 1; i <= 12; i++) {
				minPrice[i] = minPrice[i-1] + prices[i];
				if(i >= 3) {
					minPrice[i] = Math.min(minPrice[i], minPrice[i-3] + price[2]);
				}
			}
			
			minPrice[12] = Math.min(minPrice[12], price[3]);
			
			System.out.println("#" + tc + " " + minPrice[12]);
		}
		sc.close();
	}
}
