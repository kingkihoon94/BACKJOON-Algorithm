import java.io.*;
import java.util.*;

public class SWEA_5604_구간합_점화식 {
	static long A;
	static long B;
	static long answer;
	static HashMap<Long, Long> memo = new HashMap<Long, Long>();
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());
		for(int test=1; test<=TC; test++) {
			st = new StringTokenizer(br.readLine());
			A = Long.parseLong(st.nextToken());
			B = Long.parseLong(st.nextToken());
			answer = cal(B,A);
			sb.append("#").append(test).append(" ").append(answer).append("\n");
		}//end testCase.
		System.out.print(sb);//출력.
	}//end main.
	private static long cal(long B, long A) {
		if(A<=1) return f(B);
		else return f(B) - f(A-1);
	}
	private static long f(long num) {
		
		return 0;
	}
	
}//end class.
