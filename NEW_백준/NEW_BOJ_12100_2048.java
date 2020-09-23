package algorithm;

import java.io.*;
import java.util.*;

public class NEW_BOJ_12100_2048 {
	static int answer = 0;
	static int N;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		int [][] map = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}//end input.
		start(map,0);
		System.out.println(answer);
	}//end main.
	static void start(int[][] map, int cnt) {
//		System.out.println(cnt);
//		for(int i=0; i<N; i++) {
//			for(int j=0; j<N; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println("");
//		}
		if(cnt == 5) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					answer = answer < map[i][j] ? map[i][j] : answer;
				}
			}
			return;
		}//5번다하고나서 최댓값 구하기.
		start(Up(map) , cnt+1);
		start(Down(map) , cnt+1);
		start(Left(map) , cnt+1);
		start(Right(map) , cnt+1);
	}//end start.
	
	static int[][] Up(int[][] map2){
		int[][] map = new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = map2[i][j];
			}
		}
		boolean[][] visited = new boolean[N][N];	
		for(int j=0; j<N; j++) {
			for(int i=1; i<N; i++) {
				if(map[i][j] == 0) continue;
				int tmp = map[i][j];
				for(int k=i-1; k>=0; k--) {
					if(map[k][j] == 0) continue;
					if(map[k][j] != tmp || visited[k][j]) break;
					map[k][j] *= 2;
					visited[k][j] = true;
					map[i][j] = 0;
					break;
				}
			}//행별로.
		}//열별로 .
		for(int j=0; j<N; j++) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			for(int i=0; i<N; i++) {
				if(map[i][j] == 0) continue;
				list.add(map[i][j]);
				map[i][j] = 0;
			}
			int cnt = 0;
			for(int k=0; k<list.size(); k++) {
				map[cnt++][j] = list.get(k);
			}
		}//위로 떙기기.
		return map;
	}//end up.
	static int[][] Down(int[][] map2){
		int[][] map = new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = map2[i][j];
			}
		}
		boolean[][] visited = new boolean[N][N];
		for(int j=0; j<N; j++) {
			for(int i=N-2; i>=0; i--) {
				if(map[i][j] == 0) continue;
				int tmp = map[i][j];
				for(int k=i+1; k<N; k++) {
					if(map[k][j] == 0) continue;
					if(map[k][j] != tmp || visited[k][j]) break;
					map[k][j] *= 2;
					visited[k][j] = true;
					map[i][j] = 0;
					break;
				}
			}//행별로.
		}//열별로 .
		for(int j=0; j<N; j++) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			for(int i=N-1; i>=0; i--) {
				if(map[i][j] == 0) continue;
				list.add(map[i][j]);
				map[i][j] = 0;
			}
			int cnt = N-1;
			for(int k=0; k<list.size(); k++) {
				map[cnt--][j] = list.get(k);
			}
		}//아래로 떙기기.
		return map;
	}//end down.
	static int[][] Left(int[][] map2){
		int[][] map = new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = map2[i][j];
			}
		}
		boolean[][] visited = new boolean[N][N];
		for(int i=0; i<N; i++) {
			for(int j=1; j<N; j++) {
				if(map[i][j] == 0) continue;
				int tmp = map[i][j];
				for(int k=j-1; k>=0; k--) {
					if(map[i][k] == 0) continue;
					if(map[i][k] != tmp || visited[i][k]) break;
					map[i][k] *= 2;
					visited[i][k] = true;
					map[i][j] = 0;
					break;
				}
			}//행별로.
		}//열별로 .
		for(int i=0; i<N; i++) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			for(int j=0; j<N; j++) {
				if(map[i][j] == 0) continue;
				list.add(map[i][j]);
				map[i][j] = 0;
			}
			int cnt = 0;
			for(int k=0; k<list.size(); k++) {
				map[i][cnt++] = list.get(k);
			}
		}//왼쪽으로 떙기기.
		return map;
	}//end left.
	static int[][] Right(int[][] map2){
		int[][] map = new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = map2[i][j];
			}
		}
		boolean[][] visited = new boolean[N][N];
		for(int i=0; i<N; i++) {
			for(int j=N-2; j>=0; j--) {
				if(map[i][j] == 0) continue;
				int tmp = map[i][j];
				for(int k=j+1; k<N; k++) {
					if(map[i][k] == 0) continue;
					if(map[i][k] != tmp || visited[i][k]) break;
					map[i][k] *= 2;
					visited[i][k] = true;
					map[i][j] = 0;
					break;
				}
			}//행별로.
		}//열별로 .
		for(int i=0; i<N; i++) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			for(int j=N-1; j>=0; j--) {
				if(map[i][j] == 0) continue;
				list.add(map[i][j]);
				map[i][j] = 0;
			}
			int cnt = N-1;
			for(int k=0; k<list.size(); k++) {
				map[i][cnt--] = list.get(k);
			}
		}//오른쪽으로 떙기기.
		return map;
	}//end right.
}//end class.
