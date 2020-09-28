package algorithm;

import java.io.*;
import java.util.*;

public class Naver_3�� {
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
			if(n>=2 && n<=7) dp[n] += num_list[n];//���� ���ɰ���� ���� �� �ִ� ���ڸ� ���� ���ϱ�.
			System.out.println(n + " , " + dp[n]);
			if(n==6) dp[n] -= 1; //0�ڿ� ���̴� ���� ���� �� �ִ� ���ڰ� �ƴϴ�.
		}//end dp.
		if(K == 6) System.out.println(dp[K]+1);
		else System.out.println(dp[K]);
	}//end main.
}//end class.
