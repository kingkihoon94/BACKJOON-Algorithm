import java.util.Scanner;

public class BOJ_색종이붙이기 {
	static int[][] original = new int[12][12];
	static boolean[][] visited = new boolean[12][12];
	static int[] paper_list = {0,5,5,5,5,5};
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i=1; i<=10; i++) {
			for (int j=1; j<=10; j++) {
				original[i][j] = sc.nextInt();
			}
		}//draw original.
		dfs(0);
		if(min == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(min);
	}//end main.
	public static int max_check(int x, int y) {
		int cnt = 1;
		while(cnt <= 5) {
			for(int i=0; i<cnt; i++) {
				for (int j=0; j<cnt; j++) {
					//System.out.println((x+i) + " , " +(y+j));
					if(original[x+i][y+j] != 1) return cnt-1;
				}
			}
			//System.out.println("");
			cnt++;
		}
		return cnt-1;
	}//end max_check.
	public static void dfs(int cnt) {
		if(cnt > min)  return ;
		for(int i=1; i<=10; i++) {
			for (int j=1; j<=10; j++) {
				if(original[i][j] == 1 && !visited[i][j]) {
					visited[i][j] = true;
					int max_length = max_check(i,j);
					//System.out.println(max_length);
					for(int k=max_length; k>=1; k--) {
						if(paper_list[k] > 0) {
							make(i,j,k);
							dfs(cnt+1);
							clear(i,j,k);
						}
					}
					visited[i][j] = false;
					return ;
				}
			}
		}
		if(cnt < min) min = cnt;
	}//end dfs.
	public static void make(int start_x, int start_y, int length) {
		paper_list[length]--;
		for(int i=0;i<length; i++) {
			for (int j=0; j<length; j++) {
				original[start_x+i][start_y+j] = length;
			}
		}
//		for(int i=0; i<10; i++) {
//			for(int j=0; j<10; j++) {
//				System.out.print(original[i][j] + " ");
//			}
//			System.out.println(" ");
//		}
//		System.out.println("*******************");
	}
	public static void clear(int start_x, int start_y, int length) {
		paper_list[length]++;
		for(int i=0;i<length; i++) {
			for (int j=0; j<length; j++) {
				original[start_x+i][start_y+j] = 1;
			}
		}
//		for(int i=0; i<10; i++) {
//			for(int j=0; j<10; j++) {
//				System.out.print(original[i][j] + " ");
//			}
//			System.out.println(" ");
//		}
//		System.out.println("*******************");
	}
}
