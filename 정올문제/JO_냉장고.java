import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class JO_냉장고 {
	static class Pos{
		int x;
		int y;
		public Pos(int x,int y) {
			this.x = x;
			this.y =y;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] list = new int[N][2]; 
		for(int i=0; i<N; i++) {
			list[i][0] =  sc.nextInt();
			list[i][1] =  sc.nextInt();
		}//end input.
		for(int i=0; i<N-1; i++) {
			int min = list[i][0];
			int idx = i;
			for(int j=i+1;j<N;j++) {
				if(min > list[j][0]) {
					min = list[j][0];
					idx = j;
				}
			}
			int temp_x = list[i][0];
			int temp_y = list[i][1];
			list[i][0] = list[idx][0];
			list[i][1] = list[idx][1];
			list[idx][0] = temp_x;
			list[idx][1] = temp_y;
		}//오름차순 정렬.
		
//		for(int i=0; i<N; i++) {
//			System.out.println(list[i][0] + " , " + list[i][1]);
//		}
		
		int top = 0;
		int cnt = 1;
		for(int i=1; i<N; i++) {
			int start = list[top][0];
			int end = list[top][1];
			if(list[i][0] <= end) {
				if(list[i][1] <= end) {
					list[top][1] = list[i][1];
				}
			}
			else {
				cnt++;
				top = i;
			}
		}
		System.out.println(cnt);
		
	}
}
