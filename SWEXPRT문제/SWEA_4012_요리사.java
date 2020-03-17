import java.io.*;
import java.util.*;

public class SWEA_4012_요리사 {
	static int[][] score;
	static boolean[] visited;
	static int N;
	static int answer;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());
		for(int test=1; test<=TC; test++) {
			N = Integer.parseInt(br.readLine());
			score = new int[N][N];
			visited = new boolean[N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					score[i][j] = Integer.parseInt(st.nextToken());
				}
			}//end input.
			answer = Integer.MAX_VALUE;
			comb(0,0);
			sb.append("#").append(test).append(" ").append(answer).append("\n");
		}//end testCase.
		System.out.print(sb);
	}//end main.
	public static void comb(int idx, int cnt) {
		if(cnt == N/2) {
			int[] team_a = new int[N/2];
			int[] team_b = new int[N/2];
			int top_a = -1;
			int top_b = -1;
			for(int i=0; i<N; i++) {
				if(visited[i]) {
					team_a[++top_a] = i;
				}
				else team_b[++top_b] = i;
			}//팀 짜여져있는거.
			int sum_a = 0;
			int sum_b = 0;
			for(int i=0; i<N/2; i++) {
				for(int j=0; j<N/2; j++) {
					sum_a += score[team_a[i]][team_a[j]]; //같은얘들 비교는 어짜피 0 이라 괜찮다.
					sum_b += score[team_b[i]][team_b[j]]; //같은얘들 비교는 어짜피 0 이라 괜찮다.
				}
			}
			if(Math.abs(sum_a-sum_b) < answer) answer = Math.abs(sum_a-sum_b);
			return ;
		}
		for(int i=idx; i<N; i++) {
			visited[i] = true;
			comb(i+1,cnt+1);
			visited[i] = false;
		}
	}//end comb.
}//end class.
