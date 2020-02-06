import java.util.Scanner;

public class BOJ_베이스볼 {
	static int[][] list;
	static int[][] game_list;
	static boolean[] visited = new boolean[9];
	static int[] time = new int[9];
	static int inning;
	static int max = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		inning = sc.nextInt();
		list = new int [inning][10];
		game_list = new int [inning][9];
		for(int i=0; i<inning; i++) {
			for(int j=0; j<9; j++) {
				list[i][j] = sc.nextInt();
			}
		}
		time[0] = 3;
		visited[3] =true;
		dfs(1);
		System.out.println(max);
	}
	public static void dfs(int cnt) {
		if(cnt == 9) {
			for(int i=0; i<inning; i++) {
				for(int j=0; j<9; j++) {
					game_list[i][time[j]] = list[i][j];
				}
			}
//			for(int i=0; i<inning; i++) {
//				for(int j=0; j<9; j++) {
//					System.out.print(game_list[i][j] + " ");
//				}
//				System.out.println("");
//			}
//			System.out.println("");
			int temp_score = start();
			if(max < temp_score) {
				max = temp_score;
			}
			return ;
		}
		for(int i=0; i<9;i++) {
			if(visited[i]) continue;
			visited[i] = true;
			time[cnt] = i;
			dfs(cnt+1);
			visited[i] = false;
		}
	}
	public static int start() {
		int time = 0;
		int flag = -1;
		int out = 0;
		int sum = 0;
		int[] field = new int[4];
		while(time != inning) {
			int temp = game_list[time][(++flag)%9];
			switch(temp) {
			case 0: out++; break;
			case 1:{
				if(field[3] == 1) sum++;
				field[3] = field[2];
				field[2] = field[1];
				field[1] = 1;
				break;
 			}
			case 2:{
				if(field[3] == 1) sum++;
				if(field[2] == 1) sum++;
				field[3] = field[1];
				field[2] = 1;
				field[1] = 0;
				break;
 			}
			case 3:{
				for(int i=1; i<=3; i++) {
					if(field[i] == 1) {
						sum++;
						field[i] = 0;
					}
				}
				field[3] = 1;
				break;
 			}
			case 4:{
				for(int i=1; i<=3; i++) {
					if(field[i] == 1) {
						sum++;
						field[i] = 0;
					}
				}
				sum++;
				break;
 			}
			}
			if(out == 3) {
				out =0;
				for(int i=1; i<=3; i++) {
					field[i] = 0;
				}
				time++;
			}
		}
		return sum;
	}//end game;
}
