import java.util.Scanner;

public class BOJ_피보나치 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] sum_0 = new int[41];
		int[] sum_1 = new int[41];
		sum_0[0] = 1;
		sum_1[1] = 1;
		int TC = sc.nextInt();
		for(int testcase=1; testcase<=TC; testcase++) {
			int number = sc.nextInt();
			for(int i=2;i<=number;i++){
				sum_0[i] = sum_0[i-1] + sum_0[i-2];
				sum_1[i] = sum_1[i-1] + sum_1[i-2];
	        }
			System.out.println(sum_0[number] + " " + sum_1[number]);
		}
	}
	
}
