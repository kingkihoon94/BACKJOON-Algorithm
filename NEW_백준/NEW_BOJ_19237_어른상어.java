package algorithm;
import java.io.*;
import java.util.*;

public class NEW_BOJ_19237_어른상어 {
	static class Ocean{
		int num;
		int time;
		boolean shark;
		public Ocean (int num, int time, boolean shark){
			this.num = num;
			this.time = time;
			this.shark = shark;
		}
	}
	static int N;
	static int M;
	static int K;
	static int cnt;
	static int[][] shark_pos;
	static Ocean[][] map;
	static int[][] direction = {{0,0},{-1,0},{1,0},{0,-1},{0,1}};
	static int[][][] shark_db;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new Ocean[N][N];
		shark_pos = new int[M+1][4];
		shark_db = new int[M+1][5][4];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				if(tmp !=0) {
					map[i][j] = new Ocean(tmp,K,true);
					shark_pos[tmp][0] = i;
					shark_pos[tmp][1] = j;
				}
				else map[i][j] = new Ocean(tmp,0,false);
			}
		}//일단 위치정보 저장.
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=M; i++) {
			shark_pos[i][2] = Integer.parseInt(st.nextToken());
		}//처음 방향 저장.
		for(int i=1; i<=M; i++) {
			for(int j=1; j<=4; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k=0; k<4; k++) {
					shark_db[i][j][k] = Integer.parseInt(st.nextToken());
				}
			}
		}
		int time = 1;
		cnt = M;
		while(time<=1000) {
			simulation();
			if(cnt==1) break;
			time++;
		}
		if(time>1000) System.out.println(-1);
		else System.out.println(time);
	}//end main.
	public static void simulation() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j].num !=0 && !map[i][j].shark) {
					map[i][j].time--;
					if(map[i][j].time ==0) map[i][j].num = 0; //냄새 없는곳으로 바꿔주기.
				}
			}
		}//냄새 카운트 줄이기!
		
		for(int i=1; i<=M; i++) {
			if(shark_pos[i][3] != 1) { //죽은 상어 아니면 시뮬 돌리기.
				int sx = shark_pos[i][0];
				int sy = shark_pos[i][1];
				int sdir = shark_pos[i][2];
				boolean find_empty = false;
				for(int k=0; k<4; k++) {
					int nx = sx + direction[shark_db[i][sdir][k]][0];
					int ny = sy + direction[shark_db[i][sdir][k]][1];
					if(nx>=0 && nx<N && ny>=0 && ny<N && map[nx][ny].num == 0) {
						shark_pos[i][0] = nx;
						shark_pos[i][1] = ny;
						shark_pos[i][2] = shark_db[i][sdir][k];
						find_empty = true;
						break;
					}
				}//일단 빈공간 찾는 4번의 움직임.
				if(!find_empty) { //못찾았을경우 우선순위로 내 냄새 찾아가기.
					for(int k=0; k<4; k++) {
						int nx = sx + direction[shark_db[i][sdir][k]][0];
						int ny = sy + direction[shark_db[i][sdir][k]][1];
						if(nx>=0 && nx<N && ny>=0 && ny<N && map[nx][ny].num == i) {
							shark_pos[i][0] = nx;
							shark_pos[i][1] = ny;
							shark_pos[i][2] = shark_db[i][sdir][k];
							break;
						}
					}
				}//end if.
				map[sx][sy].shark = false;
			}//end if.
		}//상어 움직이기 끝!
		for(int i=1; i<=M; i++) {
			if(shark_pos[i][3] != 1) {
				int x = shark_pos[i][0];
				int y = shark_pos[i][1];
				if(!map[x][y].shark) {
					map[x][y].num = i;
					map[x][y].time = K;
					map[x][y].shark = true;
				}
				else {
					shark_pos[i][3] = 1;
					cnt--;
				}
			}
		}//상어 움직이기.
	}//end simulation.
}//end class.