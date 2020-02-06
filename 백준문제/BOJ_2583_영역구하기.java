import java.util.Scanner;

public class BOJ_2583_영역구하기 {
	static int[][] map;
	static boolean[][] visited;
	static int cnt = 0;
	static int sum = 0;
	static int[][] direction = {{-1,0} , {1,0} , {0,-1}, {0,1}};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		int col = sc.nextInt();
		int many = sc.nextInt();
		map = new int[row][col];
		visited = new boolean[row][col];
		int[] list = new int[100];
		int top = -1;
		for(int i=0; i<many; i++) {
			int start_y = sc.nextInt();
			int start_x = sc.nextInt();
			int end_y = sc.nextInt();
			int end_x = sc.nextInt();
			
			for(int dx = start_x; dx < end_x; dx++) {
				for(int dy = start_y; dy < end_y; dy++) {
					map[dx][dy] = 1;
				}
			}
		}
		
		for(int i=col-1; i>=0; i--) {
			for(int j=row-1; j>=0; j--) {
				if(map[j][i] == 0 && visited[j][i] == false) {
					cnt++;
					dfs(j,i);
					list[++top] = sum;
					sum = 0;	
				}
			}
		}
		System.out.println(cnt);
		while(top != -1) {
			System.out.print(list[top--] + " ");
		}
		
	}//end main.
	public static void dfs(int row, int col) {
		sum++;
		visited[row][col] = true;
		for(int i=0; i<4; i++) {
			int new_x = row + direction[i][0];
			int new_y = col + direction[i][1];
			if(new_x >= 0 && new_x < map.length && new_y >=0 && new_y < map[0].length) {
				if(map[new_x][new_y] == 0 && visited[new_x][new_y] == false) {
					dfs(new_x,new_y);
				}
			}
		}
		
	}//end dfs.

}
