import java.io.*;
import java.util.*;

public class BOJ_6987_월드컵 {
	
	static int[][] match = {{0,1},{0,2},{0,3},{0,4},{0,5},{1,2},{1,3},{1,4},{1,5},{2,3},{2,4},{2,5},{3,4},{3,5},{4,5}};
	static int[][] result= new int[6][3];
	static boolean can_make;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int test=0; test<4; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int total_win = 0;
			int total_draw = 0;
			int total_lose = 0;
			for(int i=0; i<6; i++) {
				total_win += result[i][0] = Integer.parseInt(st.nextToken());
				total_draw += result[i][1] = Integer.parseInt(st.nextToken());
				total_lose += result[i][2] = Integer.parseInt(st.nextToken());
			}//end input.
			can_make = false;
			if(total_win + total_draw + total_lose == 30) {
				start(0);
			}
			sb.append(can_make ? 1:0).append(" ");
		}//end testCase.
		System.out.print(sb);
	}//end main.
	public static void start(int game) {
		if(can_make) return ;
		if(game == 15) {
			can_make = true;
			return ;
		}
		int team1 = match[game][0];
		int team2 = match[game][1];
		if(result[team1][0] > 0 && result[team2][2] > 0) { //1이 이기고 2가 지는경우로 계산할때.
			result[team1][0]--;
			result[team2][2]--;
			start(game+1);
			result[team1][0]++;
			result[team2][2]++;
		}
		if(result[team1][1] > 0 && result[team2][1] > 0) {
			result[team1][1]--;
			result[team2][1]--;
			start(game+1);
			result[team1][1]++;
			result[team2][1]++;
		}
		if(result[team1][2] > 0 && result[team2][0] > 0) {
			result[team1][2]--;
			result[team2][0]--;
			start(game+1);
			result[team1][2]++;
			result[team2][0]++;
		}
	}//end start.
}//end class.
