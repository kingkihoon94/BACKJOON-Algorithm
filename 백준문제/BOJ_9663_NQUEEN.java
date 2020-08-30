package algorithm;

import java.io.*;
import java.util.*;

public class BOJ_9663_NQUEEN {
	static int N;
	static int count = 0;
	static int[] list;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list = new int[N+1];
		
		dfs(1);
		System.out.println(count);
	}//end main.
	
	public static void dfs(int row) {
		if(row == N+1) {
			count++;
			return;
		}
		for(int i=1; i<=N; i++) {
			list[row] = i;
			if(can_make(row)) {
				dfs(row+1);
			}
		}
	}//end dfs.
	
	public static boolean can_make(int row) {
		for(int i=1; i<row; i++) {
			if(list[i] == list[row]) return false;
			if(Math.abs(i-row) == Math.abs(list[i] - list[row])) return false;
		}
		return true;	
	}//end can_make.
}//end class.
