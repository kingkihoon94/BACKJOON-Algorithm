package algorithm;

import java.io.*;
import java.util.*;

public class NEW_BOJ_14499_주사위굴리기 {
	static class Dice{
		int ceil,floor,north,south,west,east;
		public Dice() {
			this.ceil = 0;
			this.floor = 0;
			this.north = 0;
			this.south = 0;
			this.west = 0;
			this.east = 0;
		}//기본 생성자.
		public void MoveUp() {
			int temp = ceil;
			ceil = south;
			south = floor;
			floor = north;
			north = temp;
		}//위쪽 움직이기.
		public void MoveDown() {
			int temp = ceil;
			ceil = north;
			north = floor;
			floor = south;
			south = temp;
		}//아래쪽 움직이기.
		public void MoveLeft() {
			int temp = ceil;
			ceil = east;
			east = floor;
			floor = west;
			west = temp;
		}//왼쪽 움직이기.
		public void MoveRight() {
			int temp = ceil;
			ceil = west;
			west = floor;
			floor = east;
			east = temp;
		}//오른쪽 움직이기.
	}//Class Dice.
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int[][] direction = {{0,0},{0,1},{0,-1},{-1,0},{1,0}}; //빈칸 , 동 , 서 , 북 , 남.
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int sx = Integer.parseInt(st.nextToken());
		int sy = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M]; //맵 선언.
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}//Draw Map.
		
		Dice dice = new Dice(); //주사위 생성.
		
		st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) {
			int command = Integer.parseInt(st.nextToken());
			int nx = sx + direction[command][0];
			int ny = sy + direction[command][1];
			if(nx<0 || nx>=N || ny<0 || ny>=M) continue;
			if(command == 1) dice.MoveRight();
			else if(command == 2) dice.MoveLeft();
			else if(command == 3) dice.MoveUp();
			else if(command == 4) dice.MoveDown();
			//방향에 따른 주사위 변수 값 바꾸기.
			if(map[nx][ny] == 0) {
				map[nx][ny] = dice.floor;
			}//맵이 0일경우 주사위 밑바닥 숫자 복사.
			else {
				dice.floor = map[nx][ny]; 
				map[nx][ny] = 0;
			}//맵이 0이 아닐경우 주사위에 그 숫자 복사 후 맵 0처리.
			sx = nx;
			sy = ny;
			sb.append(dice.ceil).append("\n");
		}//End Command.
		System.out.println(sb);
	}//End Main.
}//End Class.
