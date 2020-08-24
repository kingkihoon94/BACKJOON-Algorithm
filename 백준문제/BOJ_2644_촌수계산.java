package algorithm;

import java.io.*;
import java.util.*;

public class BOJ_2644_ÃÌ¼ö°è»ê {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(br.readLine());
		
		ArrayList<Integer>[] list = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<>();
		}
		boolean[] visited = new boolean[N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int child = Integer.parseInt(st.nextToken());
			int parent = Integer.parseInt(st.nextToken());
			list[child].add(parent);
			list[parent].add(child);
		}
		
		Queue<Integer> q = new LinkedList();
		q.add(start);
		visited[start] = true;
		int cnt = 1;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0; i<size; i++) {
				int now = q.poll();
				for(int j=0; j<list[now].size(); j++) {
					int next = list[now].get(j);
					if(next == end) {
						System.out.println(cnt);
						return ;
					}
					if(!visited[next]) {
						visited[next] = true;
						q.add(next);
					}
				}
			}
			cnt++;
		}
		System.out.println(-1);
	}//end main.
}//end class.
