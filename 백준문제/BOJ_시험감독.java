import java.util.Scanner;

public class BOJ_시험감독 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] map = new int[N];
		for(int i=0; i<N; i++) {
			map[i] = sc.nextInt();
		}
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		int sum  = 0;
		for(int i=0; i<N; i++) {
			sum++;
			if(map[i] - B <= 0) continue;
			if((map[i]-B) % C ==0) sum += (map[i]-B) / C;
			else sum += (map[i]-B) / C + 1;
		}
		System.out.println(sum);
	}
}