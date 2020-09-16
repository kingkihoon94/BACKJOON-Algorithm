package algorithm;

import java.io.*;
import java.util.*;

public class NEW_BOJ_14500_테트로미노 {
	static int N;
	static int M;
	static int[][] map;
	static boolean[][] visited;
	static int[][] direction = {{-1,0},{1,0},{0,-1},{0,1}};
	static int max_price = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}//end input.
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				visited[i][j] = true;
				dfs(i,j,1,map[i][j]);
				visited[i][j] = false;
				//여기까지는 dfs로 그려지는 그래프들.
				if(i>0 && i<N-1) {
					int tmp = map[i][j] + map[i-1][j] + map[i+1][j];
					if(j>0) max_price = max_price < tmp+map[i][j-1] ? tmp+map[i][j-1] : max_price;
					// ㅓ 방향 탐색.
					if(j<M-1) max_price = max_price < tmp+map[i][j+1] ? tmp+map[i][j+1] : max_price;
					// ㅏ 방향 탐색.
				}//ㅏ ㅓ 탐색.
				if(j>0 && j<M-1) {
					int tmp = map[i][j] + map[i][j-1] + map[i][j+1];
					if(i>0) max_price = max_price < tmp+map[i-1][j] ? tmp+map[i-1][j] : max_price;
					// ㅗ 방향 탐색.
					if(i<N-1) max_price = max_price < tmp+map[i+1][j] ? tmp+map[i+1][j] : max_price;
					// ㅜ 방향 탐색.
				}// ㅗ ㅜ 탐색.
			}//end for2.
		}//end for1.
		System.out.println(max_price);
	}//end main.
	public static void dfs(int dx, int dy, int cnt , int price) {
		if(cnt == 4) {
			max_price = max_price < price ? price : max_price;
			return ;
		}
		for(int k=0; k<4; k++) {
			int nx = dx + direction[k][0];
			int ny = dy + direction[k][1];
			if(nx>=0 & nx<N && ny>=0 && ny<M && !visited[nx][ny]) {
				visited[nx][ny] = true;
				dfs(nx,ny,cnt+1,price+map[nx][ny]);
				visited[nx][ny] = false;
			}
		}//4방향 탐색.
	}//end dfs.
}//end class.
