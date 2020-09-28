package algorithm;

import java.io.*;
import java.util.*;

public class Naver_3번 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		int[] num_list = {0,0,1,1,1,3,3,1};
		long[] dp = new long[51];
		for(int n=2; n<=K; n++) {
			for(int i=2; i<=7; i++) {
				if(n<i+2) break;
				dp[n] += dp[n-i] * num_list[i];
			}
			if(n>=2 && n<=7) dp[n] += num_list[n];//현재 성냥개비로 만들 수 있는 한자리 숫자 더하기.
			System.out.println(n + " , " + dp[n]);
			if(n==6) dp[n] -= 1; //0뒤에 붙이는 경우는 만들 수 있는 숫자가 아니다.
		}//end dp.
		if(K == 6) System.out.println(dp[K]+1);
		else System.out.println(dp[K]);
	}//end main.
}//end class.
