package algorithm;

import java.io.*;
import java.util.*;

public class NEW_BOJ_1261_�˰���_Deque {
	
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
		boolean[][] map = new boolean[row][col]; //Map �迭.
		boolean[][] visited = new boolean[row][col]; //�湮 �迭.
		int answer = 0; //����.
		
		for(int i=0; i<row; i++) {
			String input = br.readLine();
			for(int j=0; j<col; j++) {
				map[i][j] = input.charAt(j) == '0' ? true : false;
			}
		}//Draw Map.
	
		Deque<Pos> dq = new ArrayDeque<Pos>(); //Deque ���.
		dq.add(new Pos(0,0,0)); //0,0��ǥ���� �ڽ�Ʈ 0���� ����.
		visited[0][0] = true; //�湮 üũ.
		
		while(!dq.isEmpty()) {
			Pos p = dq.poll();
			if(p.x == row-1 && p.y == col-1) {
				answer = p.cost;
				break;
			}//��������.
			for(int k=0; k<4; k++) {
				int nx = p.x + direction[k][0];
				int ny = p.y + direction[k][1];
				if(nx>=0 && nx<row && ny>=0 && ny<col && !visited[nx][ny]) {
					visited[nx][ny] = true;
					if(map[nx][ny]) dq.addFirst(new Pos(nx,ny,p.cost));
					else dq.addLast(new Pos(nx,ny,p.cost+1));
				}//�� ���� �� ����ó��.
			}//end ���Ž��.
		}//End BFS.	
		
		System.out.println(answer);
	}//End Main.
}//End Class.
