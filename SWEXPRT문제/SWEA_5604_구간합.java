import java.io.*;
import java.util.*;

public class SWEA_5604_구간합 {
	static long A;
	static long B;
	static long answer;
	public static void main(String[] args) throws IOException{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());
		for(int test=1; test<=TC; test++) {
			answer = 0;
			st = new StringTokenizer(br.readLine());
			A = Long.parseLong(st.nextToken());
			B = Long.parseLong(st.nextToken());
			long[] num = new long[10];
			long point = 1;
			while(A<=B) {
				while(B%10 !=9  && A<=B) {
					calculate(B,num,point);
					B--;
				}
				if(B<=A) break;
				while(A%10 !=0 && A<=B) {
					calculate(A,num,point);
					A++;
				}//직사각형이 되는 순간.
				A/=10;
				B/=10; //자릿수 떨어뜨리기.
				for(int i=0; i<10; i++) {//직사각형 계산.
					num[i] +=(B-A+1)*point;
				}
				point *= 10;//포인트 자릿수 올리기.
			}//end while.
			for(int i=0; i<10; i++) {
				answer+=(num[i]*i);
			}
			sb.append("#").append(test).append(" ").append(answer).append("\n");
		}//end testCase.
		System.out.print(sb);//출력.
	}//end main.
	private static void calculate(long x, long[] num, long point) {
		while(x>0) {
			String s = String.valueOf(x);
			int xx = s.charAt(s.length()-1)-'0';
			num[xx] += point;
			x /= 10;
		}
	}//end calculate.
}//end class.
