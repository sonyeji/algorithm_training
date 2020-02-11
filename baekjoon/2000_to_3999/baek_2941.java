package baek0210;

import java.util.Scanner;

public class baek_2941 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		input = input.replace("c=", "k");
		input = input.replace("c-", "k");
		input = input.replace("dz=", "k");
		input = input.replace("d-", "k");
		input = input.replace("lj", "k");
		input = input.replace("nj", "k");
		input = input.replace("s=", "k");
		input = input.replace("z=", "k");
		
		System.out.println(input.length());
	}

}
