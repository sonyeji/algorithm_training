package baek0211;

import java.util.Scanner;

public class baek_8958_oxQuiz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			String input = sc.next();
			char[] list = input.toCharArray();
			int sum = 0;
			int now = 0;
			for (int j = 0; j < list.length; j++) {
				if(list[j] == 'O') {
					now++;
					sum += now;
				}else {
					now = 0;
				}
			}
			System.out.println(sum);
		}
	}

}
