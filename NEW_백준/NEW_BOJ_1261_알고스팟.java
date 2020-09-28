package algorithm;

import java.io.*;
import java.util.*;

public class NEW_BOJ_1261_알고스팟 {
	
	static class Pos {
		int x;
		int y;
		int cost;
		public Pos(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
	}//Class Position.
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[][] direction = {{-1,0},{1,0},{0,-1},{0,1}}; //사방탐색.
		int col = Integer.parseInt(st.nextToken()); //ROW.
		int row = Integer.parseInt(st.nextToken()); //COL.
		int[][] map = new int[row][col]; //Map 배열.
		int[][] dijkstra = new int[row][col]; //다익스트라 배열.
		int answer = 0; //정답.
		for(int i=0; i<row; i++) {
			String input = br.readLine();
			for(int j=0; j<col; j++) {
				map[i][j] = input.charAt(j) - '0';
				dijkstra[i][j] = Integer.MAX_VALUE; //max 값으로 초기화.
			}
		}//Draw Map.
		
		PriorityQueue<Pos> pq = new PriorityQueue<>(new Comparator<Pos>() {
			@Override
			public int compare(Pos p1, Pos p2) {
				return p1.cost < p2.cost ? -1 : 1;
			}
		});//새로운 Comparator 가진 우선순위 큐 생성.
		pq.add(new Pos(0,0,0)); //0,0좌표에서 코스트 0으로 시작.
		while(!pq.isEmpty()) {
			Pos p = pq.poll();
			int x = p.x;
			int y = p.y;
			int cost = p.cost;
			if(x == row-1 && y == col-1) {
				answer = cost;
				break;
			}//도착하면 그때의 cost가 정답.
			for(int k=0; k<4; k++) {
				int nx = x + direction[k][0];
				int ny = y + direction[k][1];
				if(nx>=0 && nx<row && ny>=0 && ny<col) {
					if(map[nx][ny] == 0) {
						if(dijkstra[nx][ny] > cost) {
							dijkstra[nx][ny] = cost; //최솟값으로 갱신.
							pq.add(new Pos(nx,ny,cost));
						}
					}//그냥 갈 수 있는 경우.
					else {
						if(dijkstra[nx][ny] > cost + 1) {
							dijkstra[nx][ny] = cost + 1; //최솟값으로 갱신.
							pq.add(new Pos(nx,ny,cost+1));
						}
					}//벽 뚫어야 하는 경우.
				}
			}
		}//End BFS.
		System.out.println(answer);
	}//End Main.
}//End Class.
