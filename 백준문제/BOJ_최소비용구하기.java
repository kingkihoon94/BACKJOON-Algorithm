import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.concurrent.PriorityBlockingQueue;

public class BOJ_최소비용구하기 {
	static class Node implements Comparable<Node>{
		int end;
		int weight;
		public Node(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}
		public int compareTo(Node n) {
			return this.weight > n.weight ? 1:-1;
		}
	}//end Node.
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<Node>[] list =  new ArrayList[V+1];
		for(int i=1; i<=V; i++) {
			list[i] = new ArrayList<>();
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list[start].add(new Node(end,weight));
		}//리스트에 저장.
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		int[] distance = new int[V+1];
		for(int i=1; i<=V; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		distance[start] = 0;
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.add(new Node(start,0));
		while(!q.isEmpty()) {
			Node n = q.poll();
			if(n.end == end) break;
			for(Node node : list[n.end]) {
				if(distance[node.end] > distance[n.end] + node.weight) {
					distance[node.end] = distance[n.end] + node.weight;
					q.add(new Node(node.end, distance[node.end]));
				}
			}
		}//end while.
		System.out.println(distance[end]);//출력.
	}//end main.
}//end class.
