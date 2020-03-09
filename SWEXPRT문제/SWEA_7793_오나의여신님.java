import java.io.*;
import java.util.*;

public class SWEA_7793_오나의여신님 {
	static int[][] direction = {{-1,0},{1,0},{0,-1},{0,1}}; //4방탐색!
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
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());
		for(int test=1; test<=TC; test++) {
			int answer = Integer.MAX_VALUE;
			int time = 0;
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			char[][] map = new char[N][M];
			boolean[][] visited = new boolean[N][M];
			boolean[][] visited2 = new boolean[N][M];
			Queue<Pos> q = new LinkedList<>();
			Queue<Pos> devil = new LinkedList<>();
			for(int i=0; i<N; i++) {
				String temp = br.readLine();
				for(int j=0; j<M; j++) {
					map[i][j] = temp.charAt(j);
					if(map[i][j] == 'S') {
						q.add(new Pos(i,j));
						visited[i][j] = true;
						map[i][j] = '.'; //수연이의 위치 정보만 받아오고 .으로 바꾼다.
					}
					else if(map[i][j] == '*') {
						devil.add(new Pos(i,j));
						visited2[i][j] = true;
					}
				}
			}//end input.
			boolean end = false;
			while(!end) {
				int size = q.size();
				if(size == 0) break;
				for(int i=0; i<size; i++) {
					Pos p = q.poll();
					if(map[p.x][p.y] == 'D') {
						answer = time;
						end = true;
						break;
					}
					else if(map[p.x][p.y] == '*') continue;
					for(int k=0; k<4; k++) {
						int new_x = p.x + direction[k][0];
						int new_y = p.y + direction[k][1];
						if(new_x>=0 && new_x<N && new_y>=0 && new_y<M && !visited[new_x][new_y]) {
							if(map[new_x][new_y] == '.' || map[new_x][new_y] == 'D') {
								q.add(new Pos(new_x,new_y));
								visited[new_x][new_y] = true;
							}
						}
					}
				}//수연이 차례.
				int size2 = devil.size();
				for(int i=0; i<size2; i++) {
					Pos p = devil.poll();
					for(int k=0; k<4; k++) {
						int new_x = p.x + direction[k][0];
						int new_y = p.y + direction[k][1];
						if(new_x>=0 && new_x<N && new_y>=0 && new_y<M && !visited2[new_x][new_y]) {
							if(map[new_x][new_y] == '.') {
								devil.add(new Pos(new_x,new_y));
								visited2[new_x][new_y] = true;
								map[new_x][new_y] = '*';
							}
						}
					}
				}
				time++;
			}//end 시뮬레이션.
			
			if(answer == Integer.MAX_VALUE) sb.append("#").append(test).append(" GAME OVER").append("\n");
			else sb.append("#").append(test).append(" ").append(answer).append("\n");
		}//end TestCase.
		System.out.print(sb);
	}//end main.
}//end class.
