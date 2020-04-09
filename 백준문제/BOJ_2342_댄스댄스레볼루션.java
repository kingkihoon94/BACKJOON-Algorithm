import java.io.*;
import java.util.*;

public class BOJ_2342_����������� { //�׸����ϰ� �����ع���... dp�� �ؾ��ҵ�.
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<Integer>list = new ArrayList<Integer>();
		while(true) {
			int tmp = Integer.parseInt(st.nextToken());
			if(tmp == 0) break;
			list.add(tmp);
		}
		int N = list.size();
		int[][][] dp = new int[N+1][5][5];
		for(int i=0; i<=N; i++) {
			for(int j=0; j<5; j++) {
				for(int k=0; k<5; k++) {
					dp[i][j][k] = 400001;
				}
			}
		}
		dp[0][0][0] = 0; //0��° ������ ����0 ������0
		int score[][] = new int[5][5];
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				if(i==0) {
					if(j==0) score[i][j] = 0;
					else score[i][j] = 2;
				}
				else if(i==j) score[i][j] = 1;
				else if(Math.abs(i-j) == 1 || Math.abs(i-j) == 3) score[i][j] = 3;
				else score[i][j] = 4;
				//System.out.print(score[i][j] + " ");
			}
			//System.out.println("");
		}
		int now = 0;
		for(int i=1; i<=N; i++) {
			now = list.get(i-1);
			for(int j=0; j<5; j++) {
				for(int k=0; k<5; k++) {
					dp[i][now][j] = Math.min(dp[i][now][j], dp[i-1][k][j] + score[k][now]);
				}
			}//�޹��� now��.
			for(int j=0; j<5; j++) {
				for(int k=0; k<5; k++) {
					dp[i][j][now] = Math.min(dp[i][j][now], dp[i-1][j][k] + score[k][now]);
				}
			}//�������� now��.
		}
		int answer = 400001;
		for(int i=0; i<5; i++) {
			answer = Math.min(answer, dp[N][now][i]);
			answer = Math.min(answer, dp[N][i][now]);
		}
		System.out.println(answer);
	}//end main.
}//end class.

