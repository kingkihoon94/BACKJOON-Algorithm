package algorithm;

import java.io.*;
import java.util.*;

public class NEW_BOJ_19236_û�ҳ��� {
	static int answer = 0; //����.
	static int[][] direct = {{-1,1},{-1,0},{-1,-1},{0,-1},{1,-1},{1,0},{1,1},{0,1}}; //8�� Ž��.
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[][] map = new int[4][4];
		int[][] dir = new int[4][4];
		for(int i=0; i<4; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<4; j++) {
				int number = Integer.parseInt(st.nextToken());
				int direction = Integer.parseInt(st.nextToken());
				map[i][j] = number;
				dir[i][j] = direction;
			}
		}//end input;
		dfs(0,0,0,map,dir); //�Ķ����: �� �� x��ǥ / y��ǥ / ���� ���� / ���� �� ����  / ���� ������ ��� ��ǥ.
		System.out.println(answer);
	}//end main.
	
	public static void dfs(int sx, int sy, int weight, int[][] map, int[][] dir) {
		int now_weight = weight + map[sx][sy];
		answer = answer < now_weight ? now_weight : answer;
		
		int[][] copy_map = new int[4][4];
		int[][] copy_dir = new int[4][4];
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++) {
				copy_map[i][j] = map[i][j];
				copy_dir[i][j] = dir[i][j];
			}
		}//Copy Map and Direction.
		copy_map[sx][sy] = -1; //�����ġ ǥ��.
		
		for(int num=1; num<=16; num++) {
ex:			for(int i=0; i<4; i++) {
				for(int j=0; j<4; j++) {
					if(copy_map[i][j] == num) {
						for(int k=0; k<8; k++) {
							int new_dir = (copy_dir[i][j] + k) % 8;
							int new_x = i + direct[new_dir][0];
							int new_y = j + direct[new_dir][1];
							if(new_x>=0 && new_x<4 && new_y>=0 && new_y<4 && copy_map[new_x][new_y] != -1){
								int tmp_num = copy_map[new_x][new_y];
								int tmp_dir = copy_dir[new_x][new_y];
								copy_map[new_x][new_y] = num;
								copy_dir[new_x][new_y] = new_dir;
								copy_map[i][j] = tmp_num;
								copy_dir[i][j] = tmp_dir;
								break ex;
							}//�����ϼ� ������ �������ֱ�.
						}//8�� Ž��.
					}//���������� ��� ã�� ���.
				}//End j.
			}//End i.
		}//End Move Fish.
		
		for(int k=1;k<=3;k++) {
			int new_x= sx + k*direct[copy_dir[sx][sy]][0];
			int new_y= sy + k*direct[copy_dir[sx][sy]][1];
			if(new_x>=0 && new_x<4 && new_y>=0 && new_y<4) {
				int tmp = copy_map[new_x][new_y];
				if(tmp != 0) {
					copy_map[sx][sy] = 0;
					dfs(new_x,new_y,now_weight,copy_map,copy_dir);
				}
			}
		}//���� �ܰ��.
		
	}//End DFS.
}//End Class.
