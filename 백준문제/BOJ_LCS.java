import java.io.*;
import java.util.*;

public class BOJ_LCS {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br.readLine();
		String str2 = br.readLine();
		int[][] dp = new int[str1.length()+1][str2.length()+1];
		for(int i=1;i <=str1.length(); i++) {
			for(int j=1; j<=str2.length(); j++) {
				if(str1.charAt(i-1) == str2.charAt(j-1)) dp[i][j] = dp[i-1][j-1] + 1; //지금 비교하는 문자끼리 같을 경우, 대각선 값 +1.
				else dp[i][j] = (dp[i-1][j] > dp[i][j-1] ? dp[i-1][j] : dp[i][j-1]);
			}
		}//end for.
		System.out.println(dp[str1.length()][str2.length()]);
	}//end main.
}//end class.
