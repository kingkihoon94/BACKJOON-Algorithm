package algorithm;

import java.awt.*;
import java.io.*;
import java.util.*;

public class NEW_BOJ_3190_�� {
	public static void main(String[] args) throws IOException{
		int[][] direction = {{-1,0},{0,1},{1,0},{0,-1}}; //����.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N+1][N+1];
		int x = 1;
		int y = 1;
		int dir = 1;
		//ó�� 1,1 ��ġ // ���� ������.
		int tmp = Integer.parseInt(br.readLine());
		for(int i=0; i<tmp; i++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 2; //��� 2.
		}
		tmp = Integer.parseInt(br.readLine());
		int[][] turn_list = new int[tmp][2];
		for(int i=0; i<tmp; i++) {
			st = new StringTokenizer(br.readLine());
			turn_list[i][0] = Integer.parseInt(st.nextToken());
			char tmp_dir = st.nextToken().charAt(0);
			if(tmp_dir == 'L') turn_list[i][1] = -1;
			else turn_list[i][1] = 1;
		}
		int time = 0;
		Queue<Point> q = new LinkedList<Point>();
		map[1][1] = 1; //���� 1.
		q.add(new Point(1,1));
		int flag = 0;
		while(true) {
			x += direction[dir][0];
			y += direction[dir][1];
			time++;
			if(x==0 | x==N+1 || y==0 || y==N+1 || map[x][y] == 1) break;
			q.add(new Point(x,y));
			if(map[x][y] != 2) {
				Point p = q.poll();
				map[p.x][p.y]= 0; 
			}//���� �ϳ� ����.
			map[x][y] = 1;
			if(time == turn_list[flag][0]) {
				dir += turn_list[flag++][1];
				if(dir == -1) dir = 3;
				else if(dir == 4) dir = 0;
				if(flag == tmp) flag = 0;
			}//�ϵ��� ����Ʈ�� ���� ����ٲٱ�.
		}
		System.out.println(time);
	}//end main.
}//end class.
