package algorithm;

import java.io.*;
import java.util.*;

public class NEW_BOJ_1261_알고스팟_Deque {
	
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
		boolean[][] map = new boolean[row][col]; //Map 배열.
		boolean[][] visited = new boolean[row][col]; //방문 배열.
		int answer = 0; //정답.
		
		for(int i=0; i<row; i++) {
			String input = br.readLine();
			for(int j=0; j<col; j++) {
				map[i][j] = input.charAt(j) == '0' ? true : false;
			}
		}//Draw Map.
	
		Deque<Pos> dq = new ArrayDeque<Pos>(); //Deque 사용.
		dq.add(new Pos(0,0,0)); //0,0좌표에서 코스트 0으로 시작.
		visited[0][0] = true; //방문 체크.
		
		while(!dq.isEmpty()) {
			Pos p = dq.poll();
			if(p.x == row-1 && p.y == col-1) {
				answer = p.cost;
				break;
			}//종료조건.
			for(int k=0; k<4; k++) {
				int nx = p.x + direction[k][0];
				int ny = p.y + direction[k][1];
				if(nx>=0 && nx<row && ny>=0 && ny<col && !visited[nx][ny]) {
					visited[nx][ny] = true;
					if(map[nx][ny]) dq.addFirst(new Pos(nx,ny,p.cost));
					else dq.addLast(new Pos(nx,ny,p.cost+1));
				}//맵 범위 내 조건처리.
			}//end 사방탐색.
		}//End BFS.	
		
		System.out.println(answer);
	}//End Main.
}//End Class.
