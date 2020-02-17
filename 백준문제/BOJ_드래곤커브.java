import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_µå·¡°ïÄ¿ºê {
	static boolean[][] map = new boolean[101][101];
	static int[] stack;
	static int top;
	static int type;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		for(int i=0; i<N; i++) {
			stack = new int[1026];
			top = -1;
			st = new StringTokenizer(br.readLine());
			int dx = Integer.parseInt(st.nextToken());
			int dy = Integer.parseInt(st.nextToken());
			stack[++top] = Integer.parseInt(st.nextToken());
			type = Integer.parseInt(st.nextToken());
			dragon(0);
			
//			for(int t=0; t<=top; t++) {
//				System.out.print(stack[t] + " ");
//			}
//			System.out.println("");
			
			map[dx][dy] = true;
			draw(dx, dy);
		}//end input.
		int ans = 0;
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				if(map[i][j] && map[i+1][j] && map[i][j+1] && map[i+1][j+1]) ans++;
			}
		}
		System.out.println(ans);
	}//end main.
	public static void dragon(int cnt) {
		if(cnt == type) {
			return ;
		}
		int temp_top = top;
		int loop = (int)(Math.pow(2, cnt));
		for(int i=0; i<loop; i++) {
			switch(stack[temp_top--]) {
			case 0: stack[++top] = 1; break;
			case 1: stack[++top] = 2; break;
			case 2: stack[++top] = 3; break;
			case 3: stack[++top] = 0; break;
			}
		}
		dragon(cnt+1);
	}//end dragon.
	public static void draw(int dx, int dy) {
		for(int i=0; i<=top; i++) {
			switch(stack[i]) {
			case 0: map[++dx][dy] = true; break;
			case 1: map[dx][--dy] = true; break;
			case 2: map[--dx][dy] = true; break;
			case 3: map[dx][++dy] = true; break;
			}
		}
	}
}
