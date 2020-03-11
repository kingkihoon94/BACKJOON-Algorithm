import java.io.*;
import java.util.*;

public class SWEA_5656_벽돌깨기 {
	static class Pos{
		int x;
		int y;
		int weight;
		public Pos(int x, int y, int weight) {
			this.x = x;
			this.y = y;
			this.weight = weight;
		}
		
	}//class Pos.
	static int N;
	static int W;
	static int H;
	static int answer;
	static int[][] map;
	static int[][] copy_map;
	static int[] num_list;
	static int[][] direction = {{-1,0},{1,0},{0,-1},{0,1}};
	static int[][][][] memo;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());
		for(int test=1; test<=TC; test++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			map = new int[H][W];
			copy_map = new int[H][W];
			num_list = new int[N];
			memo = new int[W][W][W][W];
			for(int i=0; i<H; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}//end input.
			answer = Integer.MAX_VALUE;
			comb(0);
			
			sb.append("#").append(test).append(" ").append(answer).append("\n");
		}//end TestCase.
		System.out.print(sb); //출력.
	}//end main.
	public static void comb(int cnt) {
		if(answer == 0) return ;
		if(cnt == N) {
			int temp = start();
			if(temp < answer) answer = temp;
			return ;
		}
		for(int i=0; i<W; i++) {
			num_list[cnt] = i;
			comb(cnt+1);
		}
	}//end comb;
	public static int start() {
		int temp_answer = 0;
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				copy_map[i][j] = map[i][j];
			}
		}//end copy.
		for(int i=0; i<N; i++) {
			int now_row = 0;
			int now_col = num_list[i];
			Queue<Pos> q = new LinkedList<>();
			while(now_row < H) {
				if(copy_map[now_row][now_col] != 0) {
					q.add(new Pos(now_row, now_col, copy_map[now_row][now_col]));
					break;
				}
				now_row++;
			}//처음 지워지는 곳 선정.
			while(!q.isEmpty()) {
				Pos p = q.poll();
				int dx = p.x;
				int dy = p.y;
				int size = p.weight;
				copy_map[dx][dy] = 0;
				for(int k=0; k<4; k++) {
					int power=0;
					int new_x = dx;
					int new_y = dy;
					while(power<size-1) {
						new_x += direction[k][0];
						new_y += direction[k][1];
						if(new_x<0 || new_x>=H || new_y<0 || new_y>=W) break;
						//System.out.println(new_x + " , " + new_y);
						if(copy_map[new_x][new_y]!=0) q.add(new Pos(new_x,new_y,copy_map[new_x][new_y]));
						power++;
					}
				}//4방향 확인.
			}//터질거 다 터트리기.		
			for(int t1=0; t1<W; t1++) {
				ArrayList<Integer> list = new ArrayList<Integer>();
				for(int t2=0; t2<H; t2++) {
					if(copy_map[t2][t1]!=0) {
						list.add(copy_map[t2][t1]);
						copy_map[t2][t1] = 0;
					}
				}
				int size = list.size();
				for(int t2=0; t2<size; t2++) {
					copy_map[H-size+t2][t1] = list.get(t2);
				}
			}
			//중력작용.
		}//N번 진행.
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				if(copy_map[i][j]!=0) temp_answer++;
			}
		}//test_answer 구하기.
		return temp_answer;
	}//end start.
}//end class.
