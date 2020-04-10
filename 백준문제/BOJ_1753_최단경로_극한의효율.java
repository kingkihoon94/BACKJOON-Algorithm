import java.io.*;
import java.util.*;

public class BOJ_1753_최단경로_극한의효율 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());
		HashMap<Integer, Integer>[] list = new HashMap[V+1];
		boolean[] visited = new boolean[V+1];
		for(int i=1; i<=V; i++) {
			list[i] = new HashMap<Integer, Integer>();
		}//인접행렬만들기.
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			if(list[s].containsKey(e)) {
				if(list[s].get(e) > w) list[s].put(e, w);
			}
			else list[s].put(e, w);
		}//간선 저장.
		int[] dijkstra = new int[V+1];
		Arrays.fill(dijkstra, Integer.MAX_VALUE);
		dijkstra[start] = 0;
		for(int i=0; i<V-1; i++) {
			int min = Integer.MAX_VALUE;
			int idx = -1;
			for(int j=1; j<=V; j++) {
				if(!visited[j] && min > dijkstra[j]) {
					min = dijkstra[j];
					idx = j;
				}
			}//제일 최솟값 찾기.
			if(idx == -1) break;
			for(int key : list[idx].keySet()){
				if(!visited[key] && dijkstra[idx] + list[idx].get(key) < dijkstra[key]) {
					dijkstra[key] = dijkstra[idx] + list[idx].get(key);
				}
			}
			visited[idx] = true;
		}//V-1만큼 돌기.
		for(int i=1; i<=V; i++) {
			if(dijkstra[i] == Integer.MAX_VALUE) sb.append("INF").append("\n");
			else sb.append(dijkstra[i]).append("\n");
		}
		System.out.print(sb);
	}//end main.
}//end class.
