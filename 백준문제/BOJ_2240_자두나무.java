import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2240_자두나무 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int[][][] dp = new int[3][T+1][W+2];
		for(int i=1; i<=T; i++) {
			int tree = Integer.parseInt(br.readLine());
			if(tree == 1) {
				for(int j=1; j<=W+1; j++) {
					dp[1][i][j] = Math.max(dp[1][i - 1][j] + 1, dp[2][i - 1][j - 1] + 1); 
					dp[2][i][j] = Math.max(dp[1][i - 1][j - 1], dp[2][i - 1][j]);
				}
			}
			else {
				for(int j=1; j<=W+1; j++) {
					if(i==1 && j==1) continue; //이경우 불가.
					dp[2][i][j] = Math.max(dp[2][i - 1][j] + 1, dp[1][i - 1][j - 1] + 1); 
					dp[1][i][j] = Math.max(dp[2][i - 1][j - 1], dp[1][i - 1][j]);
				}
			}
		}//end Input.
		int max = 0;
		for(int i=1; i<=W+1; i++) {
			max = max < Math.max(dp[1][T][i], dp[2][T][i]) ? Math.max(dp[1][T][i], dp[2][T][i]) : max;
		}
		System.out.println(max);
	}//end main.
}//end class.
