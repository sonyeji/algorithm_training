package baek0210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baek_2804_크로스워드 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		String first = st.nextToken();
		String second = st.nextToken();
		char[][] result = new char[second.length()][first.length()];
		for (int i = 0; i < result.length; i++) {
			Arrays.fill(result[i], '.');
		}
		boolean isok = false;
		for (int i = 0; i < first.length(); i++) {
			for (int j = 0; j < second.length(); j++) {
				if(first.charAt(i) == second.charAt(j)) {
					result[j] = first.toCharArray();
					for (int j2 = 0; j2 < second.length(); j2++) {
						result[j2][i] = second.charAt(j2);
					}
					isok = true;
					break;
				}
			}
			if(isok)	break;
		}
		
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				System.out.print(result[i][j]);
			}
			System.out.println();
		}
	}

}
