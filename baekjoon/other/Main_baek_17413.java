package ssafy0211;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_baek_17413 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine().trim();
		char[] list = input.toCharArray();
		StringBuilder sb = new StringBuilder();
		StringBuilder tmp = new StringBuilder();
		for (int i = 0; i < list.length; i++) {
			if(list[i] == '<') {
				tmp.reverse();
				sb.append(tmp);
				tmp.delete(0, tmp.length());
				while(list[i] != '>') {
					sb.append(list[i]);
					i++;
				}
				sb.append(list[i]);
			}else if(list[i] == ' ') {
				tmp.reverse();
				sb.append(tmp);
				tmp.delete(0, tmp.length());
				sb.append(' ');
			}else {
				tmp.append(list[i]);
			}
		}
		tmp.reverse();
		sb.append(tmp);
		System.out.println(sb.toString());
		
	}

}
