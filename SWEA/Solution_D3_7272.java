import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_7272_안경이없어 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		StringTokenizer st;
		for (int test_case = 1; test_case <= T; test_case++) {
			String result = "SAME";
			st = new StringTokenizer(br.readLine().trim());
			char[] first = st.nextToken().toCharArray();
			char[] second = st.nextToken().toCharArray();
			
			if(first.length!=second.length) {
				result = "DIFF";
			}else {
				for (int i = 0; i < first.length; i++) {
					if(numO(first[i]) == numO(second[i])){
						continue;
					}else {
						result = "DIFF";
						break;
					}
				}				
			}
			
			
			System.out.println("#" + test_case + " " + result);
		}
	}

	public static int numO(char c) {
		int num = 0;
		if(c == 'A' || c == 'D' || c == 'O' || c == 'P' || c == 'Q' || c== 'R') {
			num = 1;
		}
		else if(c == 'B') {
			num = 2;
		}
		return num;
	}
}
