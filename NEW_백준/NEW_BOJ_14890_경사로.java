package algorithm;

import java.io.*;
import java.util.*;

public class NEW_BOJ_14890_���� {
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
		int answer = 0; //������ ���� ����.
		for(int i=0; i<N; i++) {
			if(Solve(map[i], M)) answer++;
		}//���� �긴��.
		for(int j=0; j<N; j++) {
			int[] bridge = new int[N];
			for(int i=0; i<N; i++) {
				bridge[i] = map[i][j];
			}
			if(Solve(bridge , M)) answer++;
		}//���� �긴��.
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
					}//���θ� �������� �� ���� �������� �Ǻ��Ѵ�.
					for(int k=0; k<len; k++) {
						if(selected[i-1-k]) return false;
						else selected[i-1-k] = true;
					}
				}//�������� ����.
				else {
					if(bridge[i-1] - bridge[i] > 1) return false;
					if(i+(len-1) >= bridge.length) return false;
					for(int k=1; k<len; k++) {
						if(bridge[i+k] != bridge[i]) return false;
					}//���θ� �������� �� ���� �������� �Ǻ��Ѵ�.
					for(int k=0; k<len; k++) {
						if(selected[i+k]) return false;
						else selected[i+k] = true;
					}
				}//�������� ����.
			}//���θ� ���ƾ� �ϴ� ���.
		}//End For.
		return true;
	}//End Solve.
}//End Class.
