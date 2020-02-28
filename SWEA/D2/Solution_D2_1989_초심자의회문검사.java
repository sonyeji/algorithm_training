package swea0228;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_D2_1989_초심자의회문검사{
	public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        for(int i = 0; i < num; i++){
            String input = br.readLine();
            String[] m = input.split("");
            Boolean ok = true;
            for(int k = 0; k < m.length ; k++){
                String s = m[k];
                String e = m[m.length-1-k];
                if(s.equals(e)){
                    continue;
                }else{
                	ok = false;
                }
            }
            if(ok)
            	System.out.println("#" + (i+1) + " 1");
            else
            	System.out.println("#" + (i+1) + " 0");
        }
    }
}