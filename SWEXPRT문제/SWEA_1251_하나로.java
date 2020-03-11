import java.io.*;
import java.util.*;

public class SWEA_1251_하나로 {
	static int island;
	static int[][] list; 
	static long[][] price;
	static boolean[] visited;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());
		for(int test=1; test<=TC; test++) {
			island = Integer.parseInt(br.readLine());
			list = new int[island][2];
			price = new long[island][island];
			visited = new boolean[island];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<island; i++) {
				list[i][0] = Integer.parseInt(st.nextToken());
			}//end x좌표.
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<island; i++) {
				list[i][1] = Integer.parseInt(st.nextToken());
			}//end y좌표.
			for(int i=0; i<island; i++) {
				for(int j=i+1; j<island; j++) {
					if(i==j) continue;
					price[j][i] = price[i][j] = get_price(i,j);
				}
			}
			double tax = Double.parseDouble(br.readLine());
			//start 지점을 그냥 0번째 섬으로 잡는다.
			long answer = 0;
			visited[0] = true;
			while(!all_visited()) {
				long min_price = Long.MAX_VALUE;
				int min_idx = 0;
				for(int i=1; i<island; i++) {
					if(!visited[i] && min_price > price[0][i]) {
						min_price = price[0][i];
						min_idx = i;
					}
				}//지금 연결할 수 있는 것 중에 가장 비용 작은 것 고르기.
				answer += min_price;
				visited[min_idx] = true;
				for(int i=0; i<island; i++) {
					if(price[0][i] > price[min_idx][i]) {
						price[0][i] = price[min_idx][i];
					}
				}//업데이트.
			}
			System.out.printf("#%d %.0f\n", test, answer*tax);
		}//end TestCase.
	}//end main.
	
	public static long get_price(int start, int end) {
		return (long)(Math.pow(list[start][0] - list[end][0] , 2) + Math.pow(list[start][1] - list[end][1] , 2));
	}//end get_price.
	
	public static boolean all_visited() {
		for(int i=0; i<island; i++) {
			if(!visited[i]) return false;
		}
		return true;
	}//end all_visited.
	
}//end class.
