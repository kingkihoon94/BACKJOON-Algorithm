import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class JO_종교  {
	static int[] parent;
	static int[] length;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int start = 0;
		int end = 0;
		parent = new int[N+1];
		length = new int[N+1];
		for(int i=1; i<=N; i++) {
			parent[i] = i;
		}//부모 초기화.
		
		for(int i=0; i<M; i++) {
			s = br.readLine();
			st = new StringTokenizer(s);
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			union(start, end);
		}//end input.
		
		int answer = 0;
		for(int i=1; i<=N; i++) {
			if(i == parent[i]) answer++;
		}//같은종교인 판별.
		System.out.println(answer); //출력.
	}//end main.
	
	public static int find(int x) {
        if(x == parent[x]) {
            return x;
        }
        parent[x] = find(parent[x]);
        return parent[x];
    }//end find.
	public static void union(int x , int y) {
        int parent_x = find(x);
        int parent_y = find(y);
        if(length[parent_x] < length[parent_y]) {
        	parent[parent_x] = parent[parent_y]; //x를 y에 붙이는 행위.
        	length[parent_y]++;
        }
        else {
        	parent[parent_y] = parent_x; //y를 x에 붙이는 행위.
        	length[parent_x]++;
        }
    }//end union.
}//end class.
