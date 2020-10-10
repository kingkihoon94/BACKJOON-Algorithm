package algorithm;

import java.io.*;
import java.util.*;

public class NEW_BOJ_14503_로봇청소기 {
	
	static class Cleaner{
		int x; //청소기 x좌표.
		int y; //청소기 y좌표.
		int dir; //청소기 방향.
		public Cleaner(int x, int y, int dir) {
			this.x=x;
			this.y=y;
			this.dir=dir;
		}//생성자.
	}//Class Cleaner.
	
	static int[][] direction = {{-1,0},{0,1},{1,0},{0,-1}};//4방 탐색.
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //가로
		int M = Integer.parseInt(st.nextToken()); //세로
		
		int[][] map = new int[N+2][M+2]; //1 패딩넣어주려고 배열 크기 가로 세로 위 아래 +1 씩 증가.
		
		for(int i=0;i<N+2;i++) {
			for(int j=0;j<M+2; j++) {
				map[i][j]=1;
			}
		}//일단 다 벽으로 만들어버려. 바운드 처리 해주려고 그냥 이렇게 했음.
		
		int answer = 0; //정답 변수.
		int cnt=0; //4방향 탐색해서 뒤로 돌아가는 것 처리해주기 위한 변수.
		st = new StringTokenizer(br.readLine());
		Cleaner cl = new Cleaner(Integer.parseInt(st.nextToken())+1,Integer.parseInt(st.nextToken())+1,Integer.parseInt(st.nextToken()));
		//청소기 생성.
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}//End Input.
		
		map[cl.x][cl.y] = 2;
		answer++; //처음 좌표를 청소한 상태로 바꾸면서 정답 증가.
		
ex:		while(true) {
			int temp_dir = (cl.dir+3)%4; //현재 바라보는 방향에서 왼쪽 보게 처리.
			int new_x = cl.x + direction[temp_dir][0];
			int new_y = cl.y + direction[temp_dir][1];
			if(map[new_x][new_y]==0) {
				cnt=0;
				cl.x = new_x;
				cl.y = new_y;
				map[cl.x][cl.y] = 2; //청소했다.
				answer++;
			}
			else cnt++; //바라본 방향에 청소할 곳이 없는경우 카운트 증가.
			
			cl.dir = temp_dir; //방향바뀐거 넣어주기.
			
			if(cnt==4) { //4방향에서 청소할 곳 못찾은경우.
				int new_dir = (temp_dir+2)%4;
				new_x = cl.x + direction[new_dir][0];
				new_y = cl.y + direction[new_dir][1];
				if(map[new_x][new_y]==1) break ex; //벽부딪히면서 끝!
				else {
					cl.x = new_x;
					cl.y = new_y;
					cnt = 0;
				}
			}//카운트 4 처리 --> 이전에 온 곳으로 돌아가기.
			
		}//end simulation.
		System.out.println(answer);
	}//end main.
}//end class.
