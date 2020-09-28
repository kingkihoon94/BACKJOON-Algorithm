package algorithm;

import java.io.*;
import java.util.*;

public class NEW_BOJ_1261_�˰��� {
	
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
		int[][] direction = {{-1,0},{1,0},{0,-1},{0,1}}; //���Ž��.
		int col = Integer.parseInt(st.nextToken()); //ROW.
		int row = Integer.parseInt(st.nextToken()); //COL.
		int[][] map = new int[row][col]; //Map �迭.
		int[][] dijkstra = new int[row][col]; //���ͽ�Ʈ�� �迭.
		int answer = 0; //����.
		for(int i=0; i<row; i++) {
			String input = br.readLine();
			for(int j=0; j<col; j++) {
				map[i][j] = input.charAt(j) - '0';
				dijkstra[i][j] = Integer.MAX_VALUE; //max ������ �ʱ�ȭ.
			}
		}//Draw Map.
		
		PriorityQueue<Pos> pq = new PriorityQueue<>(new Comparator<Pos>() {
			@Override
			public int compare(Pos p1, Pos p2) {
				return p1.cost < p2.cost ? -1 : 1;
			}
		});//���ο� Comparator ���� �켱���� ť ����.
		pq.add(new Pos(0,0,0)); //0,0��ǥ���� �ڽ�Ʈ 0���� ����.
		while(!pq.isEmpty()) {
			Pos p = pq.poll();
			int x = p.x;
			int y = p.y;
			int cost = p.cost;
			if(x == row-1 && y == col-1) {
				answer = cost;
				break;
			}//�����ϸ� �׶��� cost�� ����.
			for(int k=0; k<4; k++) {
				int nx = x + direction[k][0];
				int ny = y + direction[k][1];
				if(nx>=0 && nx<row && ny>=0 && ny<col) {
					if(map[nx][ny] == 0) {
						if(dijkstra[nx][ny] > cost) {
							dijkstra[nx][ny] = cost; //�ּڰ����� ����.
							pq.add(new Pos(nx,ny,cost));
						}
					}//�׳� �� �� �ִ� ���.
					else {
						if(dijkstra[nx][ny] > cost + 1) {
							dijkstra[nx][ny] = cost + 1; //�ּڰ����� ����.
							pq.add(new Pos(nx,ny,cost+1));
						}
					}//�� �վ�� �ϴ� ���.
				}
			}
		}//End BFS.
		System.out.println(answer);
	}//End Main.
}//End Class.
