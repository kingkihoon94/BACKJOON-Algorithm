import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class JO_119구급대 {
	
	static int end_x;
	static int end_y;
	static int row;
	static int col;
	static int[][] map;
	static boolean[][] visited;
	static int min = Integer.MAX_VALUE;
	static int[][] direction = {{0,1}, {0,-1},{1,0},{-1,0}};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		row = sc.nextInt();
		col = sc.nextInt();
		map = new int[row][col];
		visited = new boolean[row][col];
		end_x = sc.nextInt();
		end_y = sc.nextInt();
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		//////////////////////입력 끝//////////////////////
		visited[0][0] = true; //시작점 방문 체크.
		dfs(0,0,-1,-1);
		System.out.println(min);
	}//end main.
	public static void dfs(int x, int y, int dir, int corner) {
		if(x == end_x && y == end_y) {
			if(corner < min) min = corner;
			return ;
		}
		if(corner >= min) return ;
		for(int i=0; i<4; i++) {
			int dx = x + direction[i][0];
			int dy = y + direction[i][1];
			if(dx>=0 && dx<row && dy>=0 && dy<col && !visited[dx][dy] && map[dx][dy] == 1) {
				visited[dx][dy] = true;
				if(i == dir) dfs(dx,dy,i,corner);
				else dfs(dx,dy,i,corner+1);
				visited[dx][dy] = false;
			}
		}
		
	}
}
