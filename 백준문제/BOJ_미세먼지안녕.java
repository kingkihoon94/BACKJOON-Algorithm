import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_미세먼지안녕 {
	static int[][] map;
	static int[] air_pos = new int[2];
	static int row;
	static int col;
	static int[][] direction = {{-1,0},{1,0},{0,-1},{0,1}};
	static class Dust{
		int x;
		int y;
		int size;
		public Dust(int x, int y, int size) {
			this.x = x;
			this.y = y;
			this.size = size;
		}
	}//먼지 객체 생성.
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int time = 0;
		map = new int[row + 1][col + 1];
		int top = -1;
		for (int i = 1; i <= row; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= col; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == -1) {
					air_pos[++top] = i;
				} // 공기 청정기 위치.
			}
		} // draw map.
		Queue<Dust> q = new LinkedList<Dust>();
		while (time != T) {
			for(int i=1; i<=row; i++) {
				for(int j=1; j<=col; j++) {
					if(map[i][j] > 0) q.add(new Dust(i,j,map[i][j]));
				}
			}//q에 먼지 객체 넣기.
			while(!q.isEmpty()) {
				Dust d = q.poll();
				int divide = d.size / 5;
				for(int i=0; i<4; i++) {
					int new_x = d.x + direction[i][0];
					int new_y = d.y + direction[i][1];
					if(new_x>0 && new_x<=row && new_y>0 && new_y<=col && map[new_x][new_y] != -1) {
						map[new_x][new_y] += divide;
						map[d.x][d.y] -= divide;
					}//먼지 나눠지는 중.
				}
			}//먼지 퍼지기.
			for (int i = 0; i < 2; i++) {
				refresh(air_pos[i], i); 
			}//공기 청정기 가동.
//			for(int i=1; i<=row; i++) {
//				for(int j=1; j<=col; j++) {
//					System.out.print(map[i][j] + " ");
//				}
//				System.out.println("");
//			}
//			System.out.println("");
			time++;
		} // 시뮬레이션 스타트.
		int answer = 0;
		for(int i=1; i<=row; i++) {
			for(int j=1; j<=col; j++) {
				answer += map[i][j];
			}
		}
		System.out.println(answer + 2); //-1 2번 더해진거 더해서 값 맞춰주기.
	}// end main.

	public static void refresh(int x, int type) {
		if (type == 0) {// 반시계 방향.
			for (int i = x - 1; i > 1; i--) { // 맨 왼쪽줄 움직이기.
				map[i][1] = map[i - 1][1];
			}
			for (int i = 1; i < col; i++) { // 맨 윗줄 움직이기.
				map[1][i] = map[1][i + 1];
			}
			for (int i = 1; i < x; i++) { // 맨 오른쪽줄 움직이기.
				map[i][col] = map[i + 1][col];
			}
			for (int i = col; i > 2; i--) { // 맨 밑줄 움직이기.
				map[x][i] = map[x][i - 1];
			}
			map[x][2] = 0; // 빈 공간 0으로 초기화.
		} else {// 시계 방향.
			for(int i=x+1; i<row; i++) {//맨 왼쪽줄 움직이기.
				map[i][1] = map[i+1][1];
			}
			for(int i=1; i<col; i++) {//맨 밑줄 움직이기.
				map[row][i] = map[row][i+1];
			}
			for(int i=row; i>x; i--) {//맨 오른쪽줄 움직이기.
				map[i][col] = map[i-1][col];
			}
			for(int i=col; i>2; i--) {//맨 윗줄 움직이기.
				map[x][i] = map[x][i-1];
			}
			map[x][2] = 0;
		}
	}// end refresh.
}// end class.
