import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_이차원배열과연산 {
	static int[][] map = new int[101][101];
	static int max_row;
	static int max_col;
	
	static class Pos implements Comparable<Pos>{
		int value;
		int cnt;
		public Pos(int value, int cnt) {
			this.value = value;
			this.cnt = cnt;
		}
		@Override
		public int compareTo(Pos T) {
			if(T.cnt < this.cnt) return 1;
			else if(T.cnt == this.cnt && T.value < this.value) return 1;
			else return -1;
		}
	}//Pos class.
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		for(int i=1; i<=3; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}//initialize map.
		int time = 0;
		max_row = 3;
		max_col = 3;
		while(time <= 100) {
			if(map[r][c] == k) break;
			if(max_row >= max_col) {
				check_row();
			}
			else {
				check_col();
			}
//			for(int i=1; i<=max_row; i++) {
//				for(int j=1; j<=max_col; j++) {
//					System.out.print(map[i][j] + " ");
//				}
//				System.out.println("");
//			}
//			System.out.println("");
			time++;
		}//end while.
		
		if(time > 100) System.out.println(-1);
		else System.out.println(time);
	}//end main.
	
	public static void check_row() {
		PriorityQueue<Pos> q = new PriorityQueue<>();
		for(int i=1; i<=max_row; i++) {
			int[] cnt_list = new int[200];
			int length = 0;
			int top = 0;
			for(int j=1; j<=max_col; j++) {
				cnt_list[map[i][j]]++;
				map[i][j] = 0;
			}//카운트 세기.
			for(int j=1; j<200; j++) {
				if(cnt_list[j] != 0) {
					q.offer(new Pos(j,cnt_list[j]));
					length+=2;
					if(length >= 100) break;
				}
			}//카운트 별 q에 넣기.
			while(!q.isEmpty()) {
				Pos p = q.poll();
				map[i][++top] = p.value;
				map[i][++top] = p.cnt;
			}//q에서 다 뽑아내기.
			if(max_col < length) max_col = length; //max_col 값 바꿔주기.
		}//각 행별로.
	}//end check_row.
	
	public static void check_col() {
		PriorityQueue<Pos> q = new PriorityQueue<>();
		for(int i=1; i<=max_col; i++) {
			int[] cnt_list = new int[200];
			int length = 0;
			int top = 0;
			for(int j=1; j<=max_row; j++) {
				cnt_list[map[j][i]]++;
				map[j][i] = 0;
			}//카운트 세기.
			for(int j=1; j<200; j++) {
				if(cnt_list[j] != 0) {
					q.offer(new Pos(j,cnt_list[j]));
					length+=2;
					if(length >= 100) break;
				}
			}//카운트 별 q에 넣기.
			while(!q.isEmpty()) {
				Pos p = q.poll();
				map[++top][i] = p.value;
				map[++top][i] = p.cnt;
			}//q에서 다 뽑아내기.
			if(max_row < length) max_row = length; //max_col 값 바꿔주기.
		}//각 행별로.
	}//end check_row.
	
}//end class.

