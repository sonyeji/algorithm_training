package swea0228;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
 
public class Solution_swtest_1952_수영장2 {
     
    static int month, threeMonth, result;
    static int[] days;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
         
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            month = Integer.parseInt(st.nextToken());
            threeMonth = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());
             
            days = new int[13];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= 12; i++) {
                days[i] = Integer.parseInt(st.nextToken()) * day;
            }
             
            result = year;
            getTotalFee(0, 1);
            bw.write("#" + test_case + " " + result + "\n");
        }
        bw.close();
    }
     
    public static void getTotalFee(int fee, int count) {
        if(count >= 13) {
            result = Math.min(result, fee);
            return;
        }
         
        //1일
        getTotalFee(fee + days[count], count + 1);
         
        //1달
        getTotalFee(fee + month , count + 1);
         
        //3달
        getTotalFee(fee + threeMonth, count + 3);
    }
}