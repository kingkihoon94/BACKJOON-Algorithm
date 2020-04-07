import java.io.*;
import java.util.*;

public class BOJ_1937_욕심쟁이판다 {
	static int N;
	static int[][] map;
	static int[][] memo;
	static int[][] direction = {{-1,0},{1,0},{0,-1},{0,1}};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		memo = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}//end input.
		int answer = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				answer = Math.max(answer, start(i,j));
			}
		}
		System.out.println(answer);
	}//end main.
	public static int start(int x, int y) {
		if(memo[x][y] != 0) return memo[x][y];
		memo[x][y] = 1; //1일차스타트!
		for(int k=0; k<4; k++) {
			int new_x = x + direction[k][0];
			int new_y = y + direction[k][1];
			if(new_x>=0 && new_x<N && new_y>=0 && new_y<N && map[x][y] < map[new_x][new_y]) {
				memo[x][y] = Math.max(memo[x][y], start(new_x,new_y) + 1);
			}
		}
		return memo[x][y];
	}
}//end class.
