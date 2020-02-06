import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BOJ_연구소 {
	static int row;
	static int col;
	static int[][] map;
	static int answer = 0;
	static int[] x_list = new int[64];
	static int[] y_list = new int[64];
	static int top = -1;
	static int[][] direction = {{-1,0},{1,0},{0,-1},{0,1}};
	static class Pos{
		int x;
		int y;
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		row = sc.nextInt(); //행
		col = sc.nextInt();	//열
		map = new int[row][col]; //맵.
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 0) {
					x_list[++top] = i;
					y_list[top] = j;
				}
			}
		}//draw map.
		
		for(int i=0; i<=top-2; i++) {
			map[x_list[i]][y_list[i]] = 5;
			dfs(i,1);
			map[x_list[i]][y_list[i]] = 0;
		}//start dfs.
		System.out.println(answer);
	}
	public static void dfs(int idx, int cnt) {
		if(cnt == 3) {
			int[][] game_map = new int[row][col];
			for(int i=0; i<row; i++) {
				for(int j=0; j<col; j++) {
					game_map[i][j] = map[i][j];
				}
			}
			int temp = bfs(game_map);
			if(temp > answer) answer = temp;
			return ;
		}
		for(int i=idx+1; i<= top-2+cnt; i++) {
			map[x_list[i]][y_list[i]] = 5;
			dfs(i,cnt+1);
			map[x_list[i]][y_list[i]] = 0;
		}
	}//end dfs(조합을 위한 재귀)
	public static int bfs(int[][] game_map) {
		int sum = 0;
		Queue<Pos> q = new LinkedList();
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				if(game_map[i][j] == 2) q.add(new Pos(i,j));
				else if(game_map[i][j] == 0) sum++;
			}
		}//바이러스 시작점 큐에 넣기랑 지금 빈공간 카운트.
		while(!q.isEmpty()) {
			int dx = q.peek().x;
			int dy = q.peek().y;
			q.poll();
			for(int i=0; i<4; i++) {
				int new_x = dx + direction[i][0];
				int new_y = dy + direction[i][1];
				if(new_x >=0 && new_x < row && new_y >=0 && new_y < col && game_map[new_x][new_y] == 0) {
					game_map[new_x][new_y] = 2;
					sum--;//2로 바뀌면서 카운트 감소.
					q.add(new Pos(new_x,new_y));
				}
			}
		}
		return sum;
	}//end bfs
}
