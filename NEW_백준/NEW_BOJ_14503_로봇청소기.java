package algorithm;

import java.io.*;
import java.util.*;

public class NEW_BOJ_14503_�κ�û�ұ� {
	
	static class Cleaner{
		int x; //û�ұ� x��ǥ.
		int y; //û�ұ� y��ǥ.
		int dir; //û�ұ� ����.
		public Cleaner(int x, int y, int dir) {
			this.x=x;
			this.y=y;
			this.dir=dir;
		}//������.
	}//Class Cleaner.
	
	static int[][] direction = {{-1,0},{0,1},{1,0},{0,-1}};//4�� Ž��.
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //����
		int M = Integer.parseInt(st.nextToken()); //����
		
		int[][] map = new int[N+2][M+2]; //1 �е��־��ַ��� �迭 ũ�� ���� ���� �� �Ʒ� +1 �� ����.
		
		for(int i=0;i<N+2;i++) {
			for(int j=0;j<M+2; j++) {
				map[i][j]=1;
			}
		}//�ϴ� �� ������ ��������. �ٿ�� ó�� ���ַ��� �׳� �̷��� ����.
		
		int answer = 0; //���� ����.
		int cnt=0; //4���� Ž���ؼ� �ڷ� ���ư��� �� ó�����ֱ� ���� ����.
		st = new StringTokenizer(br.readLine());
		Cleaner cl = new Cleaner(Integer.parseInt(st.nextToken())+1,Integer.parseInt(st.nextToken())+1,Integer.parseInt(st.nextToken()));
		//û�ұ� ����.
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}//End Input.
		
		map[cl.x][cl.y] = 2;
		answer++; //ó�� ��ǥ�� û���� ���·� �ٲٸ鼭 ���� ����.
		
ex:		while(true) {
			int temp_dir = (cl.dir+3)%4; //���� �ٶ󺸴� ���⿡�� ���� ���� ó��.
			int new_x = cl.x + direction[temp_dir][0];
			int new_y = cl.y + direction[temp_dir][1];
			if(map[new_x][new_y]==0) {
				cnt=0;
				cl.x = new_x;
				cl.y = new_y;
				map[cl.x][cl.y] = 2; //û���ߴ�.
				answer++;
			}
			else cnt++; //�ٶ� ���⿡ û���� ���� ���°�� ī��Ʈ ����.
			
			cl.dir = temp_dir; //����ٲ�� �־��ֱ�.
			
			if(cnt==4) { //4���⿡�� û���� �� ��ã�����.
				int new_dir = (temp_dir+2)%4;
				new_x = cl.x + direction[new_dir][0];
				new_y = cl.y + direction[new_dir][1];
				if(map[new_x][new_y]==1) break ex; //���ε����鼭 ��!
				else {
					cl.x = new_x;
					cl.y = new_y;
					cnt = 0;
				}
			}//ī��Ʈ 4 ó�� --> ������ �� ������ ���ư���.
			
		}//end simulation.
		System.out.println(answer);
	}//end main.
}//end class.
