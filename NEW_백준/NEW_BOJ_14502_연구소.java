package algorithm;

import java.awt.Point;
import java.io.*;
import java.util.*;

public class NEW_BOJ_14502_������ {
	
	static int N,M; //�� �� ��.
	static int[][] map; //�� ����.
	static int[][] direction = {{-1,0},{1,0},{0,-1},{0,1}}; //BFS�� 4�� Ž��.
	static ArrayList<Point> virus_list = new ArrayList<Point>(); //���̷��� ����Ʈ �־�α�.
	static int zero_size; //ù �������� ũ��.
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		ArrayList<Point> zero_list = new ArrayList<Point>(); 
		int answer = 0; //�ּڰ� 0.
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0) zero_list.add(new Point(i,j)); //zero_List�� 0�� �� ��ǥ�� ����.
				else if(map[i][j] == 2) virus_list.add(new Point(i,j)); //virus_list�� ���̷��� ��ǥ ����.
			}
		}
		zero_size = zero_list.size(); //�������� ������.
		for(int i=0; i<zero_size; i++) {
			map[zero_list.get(i).x][zero_list.get(i).y] = 1;
			for(int j=i+1; j<zero_size; j++) {
				map[zero_list.get(j).x][zero_list.get(j).y] = 1;
				for(int k=j+1; k<zero_size; k++) {
					map[zero_list.get(k).x][zero_list.get(k).y] = 1;
					int zero_block = bfs();
					answer = answer < zero_block ? zero_block : answer;
					map[zero_list.get(k).x][zero_list.get(k).y] = 0;
				}
				map[zero_list.get(j).x][zero_list.get(j).y] = 0;
			}
			map[zero_list.get(i).x][zero_list.get(i).y] = 0;
		}//3�� For��.
		System.out.println(answer);
	}//End Main.
	static int bfs() {
		int zero_block = zero_size-3; //3ĭ �پ����̴� ù ��������� -3��.
		Queue<Point> q = new LinkedList<Point>(); //ť ����.
		for(int i=0; i<virus_list.size(); i++) {
			q.add(virus_list.get(i));
		}//virus_list Queue�� �� �ֱ�.
		int nx;
		int ny;
		while(!q.isEmpty()) {
			Point p = q.poll();
			for(int k=0; k<4; k++) {
				nx = p.x + direction[k][0]; 
				ny = p.y + direction[k][1];
				if(nx>=0 && nx<N && ny>=0 && ny<M && map[nx][ny] == 0) {
					map[nx][ny] = 3;
					q.add(new Point(nx,ny));
					zero_block--;
				}
			}
		}//End BFS.
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 3) map[i][j] = 0;
			}
		}
		return zero_block;
	}//End bfs.
}//End Class.
