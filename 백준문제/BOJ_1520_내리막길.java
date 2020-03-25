import java.io.*;
import java.util.*;

public class BOJ_1520_내리막길 {
	static int[][] map;
	static int[][] memo;
	static int[][] direction = {{-1,0},{1,0},{0,-1},{0,1}};
	static int N;
	static int M;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		memo = new int[N][M];
		for(int i=0; i<N; i++) {
			Arrays.fill(memo[i], -1);
		}//필요없는 값으로 초기화.
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}//end input.
		System.out.println(dp(N-1,M-1));
	}//end main.
	public static int dp(int x, int y) {
	    if (x == 0 && y == 0) return 1;
	    if (memo[x][y] != -1) return memo[x][y];
	    int num = 0; //그전에 저장된 값이 아니면 0으로 초기화해서 다시 값 받을 준비.
	    for (int k = 0; k < 4; k++) {
	        int new_x = x + direction[k][0];
	        int new_y = y + direction[k][1];
	        if (new_x >=0 && new_x < N && new_y >=0 && new_y <M && map[x][y] < map[new_x][new_y])
	            num += dp(new_x, new_y);
	    }
	    memo[x][y] = num;
	    return num;
	}
}//end class.
