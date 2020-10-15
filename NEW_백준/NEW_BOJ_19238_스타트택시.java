package algorithm;

import java.awt.Point;
import java.io.*;
import java.util.*;

public class NEW_BOJ_19238_��ŸƮ�ý� {
	static int N;
	static int M;
	static int fuel;
	static int[][] map;
	static int[][] list;
	static Point taxi;
	static int[][] direction = {{-1,0},{0,-1},{0,1},{1,0}};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		fuel = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		list = new int[M+1][2];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				if(tmp==0) map[i][j] = 0;
				else map[i][j] = -1;
			}
		}//end draw map.
		st = new StringTokenizer(br.readLine());
		taxi = new Point(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1);
		for(int i=1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = i;
			list[i][0] = Integer.parseInt(st.nextToken())-1;
			list[i][1] = Integer.parseInt(st.nextToken())-1;
		}//end input.
		
		int time = 0;
		boolean flag = false;
		while(time<M) {
			if(simulation()) {
				flag = true;
				break;
			}
			time++;
		}
		if(flag) System.out.println(-1);
		else System.out.println(fuel);
	}//end main.
	public static boolean simulation() {
		//ó�� �ܰ�� bfs�� ���鼭? ���ǿ� �´� ����� ã��.
		Queue<Point> q = new LinkedList<Point>();
		boolean[][] visited = new boolean[N][N];
		visited[taxi.x][taxi.y] = true;
		q.add(taxi);
		int time = 0;
		int user_x = N;
		int user_y = N;
ex:		while(!q.isEmpty()) {
			if(time>fuel) break;
			int size = q.size();
			for(int i=0; i<size; i++) {
				Point p = q.poll();
				int dx = p.x;
				int dy = p.y;
				if(map[dx][dy] != 0) {
					user_x = dx;
					user_y = dy;
					break ex;
				}//ã�Ҵٸ�!
				for(int k=0; k<4; k++) {
					int new_x = dx + direction[k][0];
					int new_y = dy + direction[k][1];
					if(new_x>=0 && new_x<N && new_y>=0 && new_y<N && !visited[new_x][new_y] && map[new_x][new_y] != -1) {
						visited[new_x][new_y] = true;
						q.add(new Point(new_x,new_y));
					}
				}
			}//q ������ ��ŭ ������.
			time++;
		}
		if(user_x == N) return true; //���� ����� ����� ��ã���� ���.
		else {
			fuel -= time; //���� �Һ�.
			time = 0;
			taxi.x = user_x;
			taxi.y = user_y;
			int target_x = list[map[user_x][user_y]][0];
			int target_y = list[map[user_x][user_y]][1];
			map[user_x][user_y] = 0;
			q = new LinkedList<Point>();
			visited = new boolean[N][N];
			visited[taxi.x][taxi.y] = true;
			q.add(taxi);
			boolean can_go = false;
ex2:		while(!q.isEmpty()) {
				if(time>fuel) break;
				int size = q.size();
				for(int i=0; i<size; i++) {
					Point p = q.poll();
					int dx = p.x;
					int dy = p.y;
					if(dx == target_x && dy == target_y) {
						can_go = true;
						break ex2;
					}
					for(int k=0; k<4; k++) {
						int new_x = dx + direction[k][0];
						int new_y = dy + direction[k][1];
						if(new_x>=0 && new_x<N && new_y>=0 && new_y<N && !visited[new_x][new_y] && map[new_x][new_y] != -1) {
							visited[new_x][new_y] = true;
							q.add(new Point(new_x,new_y));
						}
					}
				}//q ������ ��ŭ ������.
				time++;
			}//�ٽ� bfs������.
			if(!can_go) return true; //�°��� �¿����� ���� ����� ������ �����������.
			else {
				taxi.x = target_x;
				taxi.y = target_y;
				fuel += time;
				return false;
			}
		}
	}//end simulation.
}//end class.
