package algorithm;

import java.io.*;
import java.util.*;

public class NEW_BOJ_14890_경사로 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}//End Input.
		int answer = 0; //가능한 경사로 갯수.
		for(int i=0; i<N; i++) {
			if(Solve(map[i], M)) answer++;
		}//가로 브릿지.
		for(int j=0; j<N; j++) {
			int[] bridge = new int[N];
			for(int i=0; i<N; i++) {
				bridge[i] = map[i][j];
			}
			if(Solve(bridge , M)) answer++;
		}//세로 브릿지.
		System.out.println(answer);
	}//End Main.
	static boolean Solve(int[] bridge , int len) {
		boolean[] selected = new boolean[bridge.length];
		for(int i=1; i<bridge.length; i++) {
			if(bridge[i] == bridge[i-1]) continue;
			else {
				if(bridge[i] > bridge[i-1]) {
					if(bridge[i] - bridge[i-1] > 1) return false;
					if(i-len<0) return false;
					for(int k=1; k<len; k++) {
						if(bridge[i-1-k] != bridge[i-1]) return false;
					}//경사로를 놓을곳이 다 같은 높이인지 판별한다.
					for(int k=0; k<len; k++) {
						if(selected[i-1-k]) return false;
						else selected[i-1-k] = true;
					}
				}//높아지는 경사로.
				else {
					if(bridge[i-1] - bridge[i] > 1) return false;
					if(i+(len-1) >= bridge.length) return false;
					for(int k=1; k<len; k++) {
						if(bridge[i+k] != bridge[i]) return false;
					}//경사로를 놓을곳이 다 같은 높이인지 판별한다.
					for(int k=0; k<len; k++) {
						if(selected[i+k]) return false;
						else selected[i+k] = true;
					}
				}//낮아지는 경사로.
			}//경사로를 놓아야 하는 경우.
		}//End For.
		return true;
	}//End Solve.
}//End Class.
