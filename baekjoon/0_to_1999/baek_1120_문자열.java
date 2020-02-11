package baek0211;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class baek_1120_¹®ÀÚ¿­ {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		
		String first = st.nextToken();
		String second = st.nextToken();
		int dis = second.length() - first.length();
		int max = 0;
		int maxidx = 0;
		for (int i = 0; i <= dis; i++) {
			int sum = 0;
			for (int j = 0; j < first.length(); j++) {
				if(first.charAt(j) == second.charAt(i+j)) {
					sum++;
				}
			}
			if(max < sum) {
				max = sum;
				maxidx = i;
			}
		}
		System.out.println(first.length() - max);
	}

}
