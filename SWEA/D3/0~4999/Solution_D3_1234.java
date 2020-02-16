import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution_D3_1234{
 
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int test_case = 1; test_case <= 10; test_case++) {
            st = new StringTokenizer(br.readLine().trim());
            int N = Integer.parseInt(st.nextToken());
            String input = st.nextToken();
            char[] list = input.toCharArray();
            StringBuilder sb = new StringBuilder(input);
             
            for (int i = 0; i < sb.length(); i++) {
                for (int j = 0; j < sb.length()-1; j++) {
                    if(sb.charAt(j) == sb.charAt(j+1)) {
                        sb.replace(j, j+2, "");
                    }
                }
            }
             
            System.out.println("#" + test_case + " " + sb.toString());
        }
    }
 
}