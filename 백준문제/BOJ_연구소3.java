import java.io.*;
import java.util.*;

public class BOJ_연구소3 {
	static int N; //크기.
	static int M; //카운트.
	static int[][] map; //맵.
	static int[][] direction = {{-1,0},{1,0},{0,-1},{0,1}}; //BFS방향.
	static boolean[] select; //선택.
	static ArrayList<Pos> walls = new ArrayList<>();
	static ArrayList<Pos> virus = new ArrayList<>();
	static Pos[] list;
	static int top = -1;
	static int[][] new_map;
	static boolean[][] visited;
	static boolean except;
	static int answer = Integer.MAX_VALUE;
	static class Pos{
		int x;
		int y;
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}//POS class.
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] ==1) walls.add(new Pos(i,j));
				else if(map[i][j] ==2) virus.add(new Pos(i,j));
			}
		}//맵 그리기.
		select = new boolean[virus.size()+1];
		list = new Pos[M];
		dfs(0,0);
		if(answer == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(answer);
	}//end main.
	
	public static void dfs(int idx, int cnt) {
		if(cnt == M) {
			int temp_cnt = bfs();
			if(temp_cnt != -1) {
				if(answer > temp_cnt) answer = temp_cnt;
			}
			return;
		}
		if(idx == virus.size())  return ;
		
		for(int i=idx; i<virus.size(); i++) {
			list[++top] = virus.get(i);
			dfs(i+1,cnt+1);
			list[top--] = null;
		}
	}//end DFS.
	public static int bfs() {
		new_map = new int[N][N];
		visited = new boolean[N][N];
		int cnt = 0;
		Queue<Pos> q = new LinkedList<>();
		for(int i=0; i<walls.size(); i++) {
			new_map[walls.get(i).x][walls.get(i).y] = 1;
			visited[walls.get(i).x][walls.get(i).y] = true;
		}
		for(int i=0; i<M; i++) {
			q.add(list[i]);
			visited[list[i].x][list[i].y] = true;
		}//새로운 맵 그리기.
		except = false;
		while(true) {
			if(all_visited()) break;
			int temp_size = q.size();
			if(temp_size ==0) {
				except = true;
				break;
			}
			for(int i=0; i<temp_size; i++) {
				Pos p = q.poll();
				for(int k=0; k<4; k++) {
					int new_x = p.x + direction[k][0];
					int new_y = p.y + direction[k][1];
					if(new_x>=0 && new_x <N && new_y>=0 && new_y<N && !visited[new_x][new_y]) {
						q.add(new Pos(new_x,new_y));
						new_map[new_x][new_y] = cnt+1;
						visited[new_x][new_y] = true;
					}
				}//방향 검사.
			}//한 타임 q 검사.
			cnt++;
		}//end while.
		if(except) return -1;
		else return cnt;
	}//end BFS.
	public static boolean all_visited() {
		boolean end = true;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j]) {
					end = false;
					for(int k=0; k<virus.size(); k++) {
						if(virus.get(k).x == i && virus.get(k).y == j) { 
							end = true; 
							break;
						}
					}
					if(!end) return false;
				}
			}
		}
		return true;
	}//end all_visited.
}//end class.
