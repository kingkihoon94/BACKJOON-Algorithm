import java.io.*;
import java.util.*;

public class SWEA_1868_파핑파핑지뢰찾기 {
	static char[][] map;
	static boolean[][] visited;
	static int[][] direction = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
	
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
		int TC = Integer.parseInt(br.readLine());
		for(int test=1; test<=TC; test++) {
			int answer = 0;
			int N = Integer.parseInt(br.readLine());
			map = new char[N][N];
			visited = new boolean[N][N];
			ArrayList<Pos> list_dot = new ArrayList<Pos>();
			ArrayList<Pos> list_zero = new ArrayList<Pos>();
			for(int i=0; i<N; i++) {
				String temp = br.readLine();
				for(int j=0; j<N; j++) {
					map[i][j] = temp.charAt(j);
					if(map[i][j] == '.') list_dot.add(new Pos(i,j));
				}
			}//end input.
			for(int i=0; i<list_dot.size(); i++) {
				boolean flag = true;
				int dx = list_dot.get(i).x;
				int dy = list_dot.get(i).y;
				for(int k=0; k<8; k++) {
					int new_x = dx + direction[k][0];
					int new_y = dy + direction[k][1];
					if(new_x>=0 && new_x<N && new_y>=0 && new_y<N && map[new_x][new_y] == '*') {
						flag = false;
						break;
					}
				}
				if(flag) list_zero.add(new Pos(dx,dy));
			}//.인것들 0들어가는거 확인.
			for(int i=0; i<list_zero.size(); i++) {
				int dx = list_zero.get(i).x;
				int dy = list_zero.get(i).y;
				if(!visited[dx][dy]) {
					answer++; //클릭 횟수 증가.
					Queue<Pos> q = new LinkedList<Pos>();
					visited[dx][dy] = true;
					q.add(new Pos(dx,dy));
					while(!q.isEmpty()) {
						Pos p = q.poll();
						boolean flag = true;
						ArrayList<Pos> temp_list = new ArrayList<Pos>();
						for(int k=0; k<8; k++) {
							int new_x = p.x + direction[k][0];
							int new_y = p.y + direction[k][1];
							if(new_x>=0 && new_x<N && new_y>=0 && new_y<N) {
								if(map[new_x][new_y] == '*') {
									flag = false;
									break;
								}
								else temp_list.add(new Pos(new_x, new_y));
							}
						}
						if(flag) {
							for(int k=0; k<temp_list.size(); k++) {
								if(!visited[temp_list.get(k).x][temp_list.get(k).y]) {
									visited[temp_list.get(k).x][temp_list.get(k).y] = true;
									q.add(temp_list.get(k));
								}
							}
						}
					}//범위 확장.
				}//시뮬 안돌아간 0일때 시뮬 돌리기.
			}//0인것들 뽑아서 시뮬돌리기.
			for(int i=0; i<list_dot.size(); i++) {
				Pos p = list_dot.get(i);
				if(!visited[p.x][p.y]) answer++;
			}
			sb.append("#").append(test).append(" " ).append(answer).append("\n");
		}//end testCase.
		System.out.print(sb);
	}//end main.
}//end class.
