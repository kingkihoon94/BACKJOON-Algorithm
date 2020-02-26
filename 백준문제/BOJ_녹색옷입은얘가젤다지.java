import java.io.*;
import java.util.*;

public class BOJ_³ì»ö¿ÊÀÔÀº¾ê°¡Á©´ÙÁö {
	
	static class Pos {
		int x;
		int y;
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}//end Pos.
	
	static int[][] direction = {{-1,0},{1,0},{0,-1},{0,1}};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int cnt = 0;
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			if(N == 0) break;
			int[][] map = new int[N][N];	
			int[][] dijkstra = new int[N][N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N;  j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					dijkstra[i][j] = Integer.MAX_VALUE;
				}
			}//draw map.
			dijkstra[0][0] = map[0][0];
			Queue<Pos> q = new LinkedList<>();
			q.add(new Pos(0,0));
			while(!q.isEmpty()) {
				Pos p = q.poll();
				for(int k=0; k<4; k++) {
					int new_x = p.x + direction[k][0];
					int new_y = p.y + direction[k][1];
					if(new_x >=0 && new_x < N && new_y >=0 && new_y <N) { //ÀÏ´Ü ¹üÀ§³».
						if(dijkstra[new_x][new_y] > dijkstra[p.x][p.y]+ map[new_x][new_y]) {
							dijkstra[new_x][new_y] = dijkstra[p.x][p.y]+ map[new_x][new_y];
							q.add(new Pos(new_x,new_y));
						}
					}
				}
			}//end while.
			sb.append("Problem ").append(++cnt).append(": ").append(dijkstra[N-1][N-1]).append("\n");
		}
		System.out.print(sb);
	}//end main.
}//end class.
