package algorithm;

import java.io.*;
import java.util.*;

public class BOJ_2573_빙산 {
	
	static class Pos{
		int x;
		int y;
		int score;
		public Pos(int x, int y, int score) {
			this.x = x;
			this.y = y;
			this.score = score;
		}
	}//class Pos.
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		int[][] direction = {{-1,0},{1,0},{0,1},{0,-1}};
		
		Queue<Pos> q = new LinkedList();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] != 0) q.add(new Pos(i,j,map[i][j]));
			}
		}//end input.
		int cnt = 1;
		while(!q.isEmpty()) {
			int size = q.size();
			ArrayList<Pos> list = new ArrayList<>();
			for(int i=0; i<size; i++) {
				Pos p = q.poll();
				int dx = p.x;
				int dy = p.y;
				int score = p.score;
				int tmp_cnt = 0;
				for(int k=0; k<4; k++) {
					int nx = dx + direction[k][0];
					int ny = dy + direction[k][1];
					if(nx>=0 && nx<N && ny>=0 && ny<M && map[nx][ny] ==0)tmp_cnt++;
				}//4방향검사.
				score -= tmp_cnt;
				if(score <= 0) list.add(new Pos(dx,dy,0));
				else {
					list.add(new Pos(dx,dy,score)); //지우는역할.
					q.add(new Pos(dx,dy,score)); //다음 시뮬 역할.
				}
			}//한 싸이클.
			for(int i=0; i<list.size(); i++) {
				Pos p = list.get(i);
				map[p.x][p.y]= p.score; 
			}
			
			
			boolean can_end = false;
			int island = 1;
			boolean[][] visited = new boolean[N][M];
ex:			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j] != 0 && !visited[i][j]) {
						if(island==1) {
							Queue<Pos> q2 = new LinkedList();
							visited[i][j] = true;
							q2.add(new Pos(i,j,0));
							while(!q2.isEmpty()){
								Pos p = q2.poll();
								for(int k=0; k<4; k++) {
									int nx = p.x + direction[k][0];
									int ny = p.y + direction[k][1];
									if(nx>=0 && nx<N && ny>=0 && ny<M && map[nx][ny] != 0 && !visited[nx][ny]) {
										visited[nx][ny] = true;
										q2.add(new Pos(nx,ny,0));
									}
								}
							}//end while.
							island++;
						}
						else {
							can_end = true;
							break ex;
						}
					}
				}
			}//이중for문.
			if(can_end) {
				System.out.println(cnt);
				return ;
			}
			cnt++;
		}//end while.
		System.out.println(0);
	}//end main.
}//end class.
