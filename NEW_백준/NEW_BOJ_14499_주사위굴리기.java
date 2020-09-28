package algorithm;

import java.io.*;
import java.util.*;

public class NEW_BOJ_14499_�ֻ��������� {
	static class Dice{
		int ceil,floor,north,south,west,east;
		public Dice() {
			this.ceil = 0;
			this.floor = 0;
			this.north = 0;
			this.south = 0;
			this.west = 0;
			this.east = 0;
		}//�⺻ ������.
		public void MoveUp() {
			int temp = ceil;
			ceil = south;
			south = floor;
			floor = north;
			north = temp;
		}//���� �����̱�.
		public void MoveDown() {
			int temp = ceil;
			ceil = north;
			north = floor;
			floor = south;
			south = temp;
		}//�Ʒ��� �����̱�.
		public void MoveLeft() {
			int temp = ceil;
			ceil = east;
			east = floor;
			floor = west;
			west = temp;
		}//���� �����̱�.
		public void MoveRight() {
			int temp = ceil;
			ceil = west;
			west = floor;
			floor = east;
			east = temp;
		}//������ �����̱�.
	}//Class Dice.
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int[][] direction = {{0,0},{0,1},{0,-1},{-1,0},{1,0}}; //��ĭ , �� , �� , �� , ��.
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int sx = Integer.parseInt(st.nextToken());
		int sy = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M]; //�� ����.
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}//Draw Map.
		
		Dice dice = new Dice(); //�ֻ��� ����.
		
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
			//���⿡ ���� �ֻ��� ���� �� �ٲٱ�.
			if(map[nx][ny] == 0) {
				map[nx][ny] = dice.floor;
			}//���� 0�ϰ�� �ֻ��� �عٴ� ���� ����.
			else {
				dice.floor = map[nx][ny]; 
				map[nx][ny] = 0;
			}//���� 0�� �ƴҰ�� �ֻ����� �� ���� ���� �� �� 0ó��.
			sx = nx;
			sy = ny;
			sb.append(dice.ceil).append("\n");
		}//End Command.
		System.out.println(sb);
	}//End Main.
}//End Class.
