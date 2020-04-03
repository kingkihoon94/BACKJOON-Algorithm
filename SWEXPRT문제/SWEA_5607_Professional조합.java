import java.io.*;
import java.util.*;

public class SWEA_5607_Professional¡∂«’ {
	static long P = 1234567891;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());
		for(int test=1; test<=TC; test++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			long[] fact = new long[N+1];
			fact[0] = 1;
			fact[1] = 1;
			for(int i=2; i<=N; i++) {
				fact[i] = (i * fact[i-1]) % P;
			}
			long num1 = invert(fact[N-R] , P-2);
			long num2 = invert(fact[R] , P-2);
			long answer = (((fact[N] * num1) % P) * num2) % P;
			sb.append("#").append(test).append(" ").append(answer).append("\n");
		}//end testCase.
		System.out.print(sb);
	}//end main.
	public static long invert(long x , long p) {
		if(p==1) {
			return x % P;
		}
		if(p%2 == 0) {
			long answer = invert(x,p/2);
			return (answer * answer) % P;
		}
		else {
			long answer = invert(x,p/2);
			return ((answer * answer % P) * x) % P;
		}
	}//end invert.
}//end class.
