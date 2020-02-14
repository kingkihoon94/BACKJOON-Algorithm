import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_≈‰∏∂≈‰ {
	
	static class Pos{
		int x;
		int y;
		int cnt;
		public Pos(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	
	static int[][] direction = {{-1,0},{1,0},{0,-1},{0,1}};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int col = Integer.parseInt(st.nextToken());
		int row = Integer.parseInt(st.nextToken());
		int[][] map = new int[row][col];
		Queue<Pos> q = new LinkedList();
		for(int i=0; i<row; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<col; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) q.add(new Pos(i,j,0));
			}
		}//draw map.
		int answer = 0;
		while(!q.isEmpty()) {
			Pos p = q.poll();
			answer = p.cnt;
			for(int i=0; i<4; i++) {
				int new_x = p.x + direction[i][0];
				int new_y = p.y + direction[i][1];
				if(new_x >= 0 && new_x < row && new_y >= 0 && new_y < col && map[new_x][new_y] == 0) {
					map[new_x][new_y] = 1;
					q.add(new Pos(new_x,new_y, p.cnt+1));
				}
			}
		}//end bfs.
		
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				if(map[i][j] == 0) {
					answer = -1;
					break;
				}
			}
		}
		System.out.println(answer);
	}//end main.
}
