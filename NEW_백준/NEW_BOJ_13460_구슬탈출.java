package algorithm;

import java.io.*;
import java.util.*;

public class NEW_BOJ_13460_구슬탈출 {
	static int[][] direction = {{-1,0},{1,0},{0,-1},{0,1}};
	static char[][] map;
	static int answer = 11;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int red_x=0, red_y=0, blue_x=0, blue_y= 0;
		map = new char[N][M];
		for(int i=0; i<N; i++) {
			String tmp =  br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = tmp.charAt(j);
				if(map[i][j] == 'R') {
					red_x = i;
					red_y = j;
					map[i][j] = '.';
				}//red일 경우.
				else if(map[i][j] == 'B') {
					blue_x = i;
					blue_y = j;
					map[i][j] = '.';
				}//blue일 경우.
			}
		}//end input.
		for(int i=0; i<4; i++) {
			move(red_x,red_y,blue_x,blue_y,i,1);
		}//start move.
		if(answer == 11) System.out.println(-1);
		else System.out.println(answer);
	}//end main.
	static void move(int red_x, int red_y, int blue_x, int blue_y, int dir, int cnt) {
		if(cnt>=answer) return;
		boolean blue_end = false;
		int blue_cnt = 0;
		int red_cnt = 0;
		while(true) {
			int new_x = blue_x + direction[dir][0];
			int new_y = blue_y + direction[dir][1];
			if(map[new_x][new_y] == '#') break;
			else if(map[new_x][new_y] == 'O') {
				blue_end = true;
				break;
			}
			blue_x = new_x;
			blue_y = new_y;
			blue_cnt++;
		}//move the blue.
		if(blue_end) return;
		boolean red_end = false;
		while(true) {
			int new_x = red_x + direction[dir][0];
			int new_y = red_y + direction[dir][1];
			if(map[new_x][new_y] == '#') break;
			else if(map[new_x][new_y] == 'O') {
				red_end = true;
				break;
			}
			red_x = new_x;
			red_y = new_y;
			red_cnt++;
		}//move the blue.
		if(red_end) {
			answer = answer > cnt ? cnt : answer;
			return;
		}
		if(red_x == blue_x && red_y == blue_y) {
			if(red_cnt > blue_cnt) {
				red_x -= direction[dir][0];
				red_y -= direction[dir][1];
			}
			else {
				blue_x -= direction[dir][0];
				blue_y -= direction[dir][1];
			}
		}//같은곳에 도달할 경우에는 거리가 가까운쪽이 먼저 자리를 가져간다.
		int inverse_dir = inverse(dir);
		for(int i=0; i<4; i++) {
			if(i == dir || i == inverse_dir) continue;
			move(red_x,red_y,blue_x,blue_y,i,cnt+1);
		}//remove.
	}//end move.
	static int inverse(int x) {
		if(x==0) return 1;
		else if(x==1) return 0;
		else if(x==2) return 3;
		else return 2;
	}//end inverse.
}//end class.
