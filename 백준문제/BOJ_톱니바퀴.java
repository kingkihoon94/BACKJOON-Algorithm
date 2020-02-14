import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_톱니바퀴 {
	static char[][] wheels = new char[5][8];
	static boolean[] visited;
	static int[] direction;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int i=1; i<=4; i++) {
			st = new StringTokenizer(br.readLine());
			String temp = st.nextToken();
			for(int j=0; j<8; j++) {
				wheels[i][j] = temp.charAt(j); //톱니바퀴정보 넣어놓기.
			}
		}//input wheels.
		st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken()); //명령어 갯수.
		for(int i = 0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int direct = Integer.parseInt(st.nextToken());
			visited = new boolean[5];
			direction =  new int[5];
			check(num,direct);
			rotate();
		}//end for.
		int answer = 0;
		for(int i=1; i<=4; i++) {
			if(wheels[i][0] == '1') answer += Math.pow(2, (i-1));
		}
		System.out.println(answer);
	}//end main.
	public static void check(int num, int direct) {
		visited[num] = true;
		direction[num] = direct;
		int left = num - 1;
		if(left >=1 && !visited[left] && wheels[num][6] != wheels[left][2]) check(left,(direct*-1));
		int right = num + 1;
		if(right <=4 && !visited[right] && wheels[num][2] != wheels[right][6]) check(right,(direct*-1));
	}//end check.
	public static void rotate() {
		for(int i=1; i<=4 ; i++) {
			switch(direction[i]) {
			case 0: break;
			case 1: {//시계방향
				char temp = wheels[i][7];
				for(int j=7; j>0; j--) {
					wheels[i][j] = wheels[i][j-1];
				}
				wheels[i][0] = temp;
				break;
			}
			case -1: {//반시계방향.
				char temp = wheels[i][0];
				for(int j=0; j<7; j++) {
					wheels[i][j] = wheels[i][j+1];
				}
				wheels[i][7] = temp;
				break;
			}
			}
		}
	}//end rotate.
}//end class.
