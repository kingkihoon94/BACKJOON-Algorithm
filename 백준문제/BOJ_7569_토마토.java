package algorithm;

import java.io.*;
import java.util.*;

public class BOJ_7569_토마토 {
	static int N;
	static int M;
	static int H;
	static int[][] direction = {{-1,0,0},{1,0,0},{0,-1,0},{0,1,0},{0,0,1},{0,0,-1}};//6방향 direciton.
	static int[][][] map;
	
	static class Pos{
		int x;
		int y;
		int z;
		public Pos(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;			
		}
	}//class Pos.
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //행.
		M = Integer.parseInt(st.nextToken()); //열.
		H = Integer.parseInt(st.nextToken()); //높이.
		map = new int[H][M][N];
		Queue<Pos> q = new LinkedList();
		boolean flag  = true;
		for(int i=0; i<H; i++) {
			for(int j=0; j<M; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k=0; k<N; k++) {
					map[i][j][k] = Integer.parseInt(st.nextToken());
					if(map[i][j][k] == 1) q.add(new Pos(i,j,k));
					else if(map[i][j][k] == 0) flag = false;
				}
			}
		}
		if(flag) {//0인 구간이 입력칸에 하나라도 없을 경우 예외처리.
			System.out.println(0);
			return ;
		}
		int cnt = 1;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0; i<size; i++) {
				Pos p = q.poll();
				int dx = p.x;
				int dy = p.y;
				int dz = p.z;
				for(int k=0; k<6; k++) {
					int nx = dx + direction[k][0];
					int ny = dy + direction[k][1];
					int nz = dz + direction[k][2];
					if(nx>=0 && nx<H && ny>=0 && ny<M && nz>=0 && nz<N && map[nx][ny][nz] == 0) {
						map[nx][ny][nz] = 1;
						q.add(new Pos(nx,ny,nz));
					}//사이에있고
				}//방향성 검사.
			}//한 사이클.
			
			boolean can_end = true;
ex:			for(int i=0; i<H; i++) {
				for(int j=0; j<M; j++) {
					for(int k=0; k<N; k++) {
						if(map[i][j][k] == 0) {
							can_end = false;
							break ex;
						}
					}
				}
			}//3중 for문.
			
			if(can_end) {
				System.out.println(cnt);
				return;
			}
			cnt++;
		}//end while.
		
		System.out.println(-1);
		
	}//end main.
}//end class.
