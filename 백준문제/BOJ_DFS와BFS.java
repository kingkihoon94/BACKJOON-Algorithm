import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_DFS와BFS {
	static ArrayList<Integer>[] list;
	static boolean[] visited;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		int vertex = Integer.parseInt(st.nextToken());
		int node = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		list = new ArrayList[vertex+1];
		for(int i=1; i<=vertex; i++) {
			list[i] = new ArrayList<>();
		}//ArrayList 만들기.
		for(int i=0; i<node; i++) {
			st = new StringTokenizer(br.readLine());
			int s1 = Integer.parseInt(st.nextToken());
			int s2 = Integer.parseInt(st.nextToken());
			list[s1].add(s2);
			list[s2].add(s1);
		}//간선 저장.
		for(int i=1; i<=vertex; i++) {
			Collections.sort(list[i]); //무조건 알고가기.
		}
		visited = new boolean[vertex+1];
		visited[start] = true;
		dfs(start);
		sb.append("\n");
		visited = new boolean[vertex+1];
		visited[start] = true;
		bfs(start);
		System.out.println(sb);
	}
	public static void dfs(int v) {
		sb.append(v).append(" ");
		for(int i=0; i<list[v].size(); i++) {
			int new_v = list[v].get(i);
			if(!visited[new_v]) {
				visited[new_v] = true ;
				dfs(new_v);
			}
		}
	}//end dfs.
	
	public static void bfs(int v) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(v);
		while(!q.isEmpty()) {
			int v2 = q.poll();
			sb.append(v2).append(" ");
			for(int i=0; i<list[v2].size(); i++) {
				int new_v = list[v2].get(i);
				if(!visited[new_v]) {
					visited[new_v] = true ;
					q.add(new_v);
				}
			}
		}//end while.
	}//end bfs.
}
