package baek0210;

import java.util.Scanner;

public class baek_1592_¿µ½ÄÀÌ {

	static int n,m,l;
    static int[] map;
    static int cur, next;
    static int res;
    
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        n = sc.nextInt();
        m = sc.nextInt();
        l = sc.nextInt();
        
        map = new int[n];
        
        while(true) {
            if(++map[cur] == m) break;
            
            if(map[cur] % 2 == 0) {
            	if(cur + l >= n)
            		next = l - (n - cur);
            	else
            		next = cur + l;
            }
            else {
            	if(cur - l < 0)
            		next = n - (l - cur);
            	else
            		next = cur - l; 
            }
            cur = next;
            res++;
        }
        System.out.println(res);
    }

}
