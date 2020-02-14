import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_경사로 {
	static int[][] map;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}//end input.
		int[] road = new int[N];
		boolean can = false;
		int cnt = 0;
		for(int i=0; i<N; i++) {
			can = true;
			boolean[] use = new boolean[N];
			for(int j=1; j<N; j++) {
				if(!can) break;
				if(map[i][j] == map[i][j-1]) continue;
				else {
					if(Math.abs(map[i][j] - map[i][j-1]) > 1) {
						can = false; 
						break;
					}
					else {
						if(map[i][j] < map[i][j-1]) {
							for(int k=0; k<L; k++) {
								if(j+k >= N || map[i][j+k] != map[i][j] || use[j+k]) {
									can = false;
									break;
								}
								use[j+k] = true;
							}
						}//end if.
						else {
							for(int k=0; k<L; k++) {
								if((j-1-k) < 0 || map[i][j-1-k] != map[i][j-1] || use[j-1-k]) {
									can = false;
									break;
								}
								use[j-1-k] = true;
							}
						}//end else.
					}//end else.
				}
			}//row줄 체크.
			if(can) cnt++;
			can = true;
			use = new boolean[N];
			for(int j=1; j<N; j++) {
				if(!can) break;
				if(map[j][i] == map[j-1][i]) continue;
				else {
					if(Math.abs(map[j][i] - map[j-1][i]) > 1) {
						can = false; 
						break;
					}
					else {
						if(map[j][i] < map[j-1][i]) {
							for(int k=0; k<L; k++) {
								if(j+k >= N || map[j+k][i] != map[j][i] || use[j+k]) {
									can = false;
									break;
								}
								use[j+k] = true;
							}
						}//end if.
						else {
							for(int k=0; k<L; k++) {
								if((j-1-k) < 0 || map[j-1-k][i] != map[j-1][i] || use[j-1-k]) {
									can = false;
									break;
								}
								use[j-1-k] = true;
							}
						}
					}	
				}
			}//col줄 체크.
			if(can) cnt++;
		}//check.
		System.out.println(cnt);
	}//end main.
}//end class.
