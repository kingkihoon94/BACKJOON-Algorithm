import java.io.*;
import java.util.*;

public class BOJ_알고스팟 {
	static class Pos{
		int x;
		int y;
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}//class Pos.
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =  new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[][] direction = {{-1,0},{1,0},{0,-1},{0,1}};
		int[][] map = new int[N+1][M+1];
		int[][] dijkstra = new int[N+1][M+1];
		for(int i=1; i<=N; i++) {
			String temp = br.readLine();
			for(int j=1; j<=M; j++) {
				map[i][j] = temp.charAt(j-1) - '0';
				dijkstra[i][j] = Integer.MAX_VALUE;
			}
		}//draw map and dijkstra.
		dijkstra[1][1] = 0; //스타트 지점 값.
		Queue<Pos> q = new LinkedList();
		q.add(new Pos(1,1));
		while(!q.isEmpty()) {
			Pos p = q.poll();
			int dx = p.x;
			int dy = p.y;
			for(int k=0; k<4; k++) {
				int new_x = dx + direction[k][0];
				int new_y = dy + direction[k][1];
				if(new_x>0 && new_x<=N && new_y>0 && new_y<=M) {
					if(map[new_x][new_y] == 0) {
						if(dijkstra[new_x][new_y] > dijkstra[dx][dy]) {
							dijkstra[new_x][new_y] = dijkstra[dx][dy];
							q.add(new Pos(new_x,new_y));
						}
					}
					else {
						if(dijkstra[new_x][new_y] > dijkstra[dx][dy] + 1) {
							dijkstra[new_x][new_y] = dijkstra[dx][dy] + 1;
							q.add(new Pos(new_x,new_y));
						}
					}
				}
			}
		}//end bfs.
		
		System.out.println(dijkstra[N][M]);
		
	}//end main.
}//end class.
