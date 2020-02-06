import java.util.Scanner;

public class SWEXPERT_최빈수구하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for (int testCase = 1; testCase <= TC; testCase++) {
			int Case = sc.nextInt();
			int[] numCount = new int[101];
			for(int i=0; i<1000; i++) {
				int temp = sc.nextInt();
				numCount[temp] ++;
			}
			int max = 0;
			for(int i=1; i<=100; i++) {
				if(numCount[i] >= numCount[max]) {
					max = i;
				}
			}
			System.out.println("#" + Case + " " + max);
		}
	}
}
