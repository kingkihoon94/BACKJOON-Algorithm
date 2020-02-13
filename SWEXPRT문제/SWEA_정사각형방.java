import java.util.Scanner;

public class SWEA_정사각형방 {
	static int answer_cnt;
	static int answer_num;
	static int[][] map;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for(int test = 1; test<=TC; test++) {
			int N = sc.nextInt();
			answer_cnt = 0;
			answer_num = 0;
			map = new int[N*N+1][2];
			visited = new boolean[N*N+1];
			for(int i=1;i<=N; i++) {
				for(int j=1; j<=N; j++) {
					int number = sc.nextInt();
					map[number][0] = i;
					map[number][1] = j;
				}
			}//end input.
			for(int i=1; i<=N*N; i++) {
				if(!visited[i]) dfs(i,1);
			}
			System.out.println("#" + test + " " + answer_num + " " + answer_cnt);
		}//end testcase.
	}//end main.
	public static void dfs(int num, int cnt) {
		visited[num] = true;
		if(num == map.length-1) {
			if(answer_cnt < cnt) {
				answer_cnt = cnt;
				answer_num = num-cnt+1;
			}
			return;
		}
		int distance = Math.abs(map[num+1][0] - map[num][0]) +  Math.abs(map[num+1][1] - map[num][1]);
		if(distance == 1) dfs(num+1, cnt+1);
		else {
			if(answer_cnt < cnt) {
				answer_cnt = cnt;
				answer_num = num-cnt+1;
			}
		}
	}
}
