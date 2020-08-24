package algorithm;

import java.io.*;
import java.util.*;

public class BOJ_2606_바이러스 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		ArrayList<Integer>[] list = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<>();
		}
		boolean[] visited = new boolean[N+1];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int now = Integer.parseInt(st.nextToken());
			int next = Integer.parseInt(st.nextToken());
			list[now].add(next);
			list[next].add(now);
		}
		Queue<Integer> q = new LinkedList<>();
		int cnt = 0;
		q.add(1);
		visited[1] = true;
		while(!q.isEmpty()) {
			int now = q.poll();
			for(int i=0; i<list[now].size(); i++) {
				int next = list[now].get(i);
				if(!visited[next]) {
					visited[next] = true;
					q.add(next);
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}//end main.
}//end class.
