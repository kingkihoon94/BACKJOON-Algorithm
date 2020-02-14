import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] map;
	static boolean[] visited;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		visited = new boolean[N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}//end input.
		dfs(0,0);
		System.out.println(min);
		
	}//end main.
	public static void dfs(int idx, int cnt) {
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
			}
			int sum_a = 0;
			int sum_b = 0;
			for(int i=0; i<N/2; i++) {
				for(int j=0; j<N/2; j++) {
					sum_a += map[team_a[i]][team_a[j]];
					sum_b += map[team_b[i]][team_b[j]];
				}
			}
			if(Math.abs(sum_a-sum_b) < min) min = Math.abs(sum_a-sum_b);
			return ;
		}
		if(idx==N) return;
		for(int i=idx;i<N;i++) {
			visited[i] = true;
			dfs(i+1,cnt+1);
			visited[i] = false;
		}
	}
}//end class.
