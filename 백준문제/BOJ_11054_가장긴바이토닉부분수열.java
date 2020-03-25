import java.io.*;
import java.util.*;

public class BOJ_11054_가장긴바이토닉부분수열 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] list = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}//end input.
		int[] dp_plus = new int[N];
		int[] dp_minus = new int[N];
		Arrays.fill(dp_plus, 1);
		Arrays.fill(dp_minus, 1); //1값으로 초기화.
		for(int i=0; i<N; i++) {
			for(int j=0; j<i; j++) {
				if(list[j] < list[i] && dp_plus[i] < dp_plus[j]+1) dp_plus[i] = dp_plus[j] + 1;
			}
		}//그 vertex에서 가장 큰 증가수열 길이 찾기 순서는 0부터.
		for(int i=N-1; i>=0; i--) {
			for(int j=N-1; j>i; j--) {
				if (list[j] < list[i] && dp_minus[i] < dp_minus[j] + 1) dp_minus[i] = dp_minus[j]+1;
			}
		}//그 vertex에서 가장 큰 감소수열 길이 찾기 순서는 n-1부터.
		int answer = 0 ;
		for(int i=0; i<N; i++) {
			if(answer < dp_plus[i] + dp_minus[i] -1) answer = dp_plus[i] + dp_minus[i] -1;
		}
		System.out.println(answer);
	}//end main.
}//end class.
