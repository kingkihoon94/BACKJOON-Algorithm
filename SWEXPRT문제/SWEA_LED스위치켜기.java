import java.util.Scanner;

public class SWEA_LED스위치켜기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int testcase=1; testcase<=T; testcase++) {
			int length = sc.nextInt();
			int original[] = new int[length+1];
			int map[] = new int[length+1];
			int cnt = 0;
			for(int i=1; i<=length; i++) {
				original[i] = sc.nextInt();
			}
			for(int i=1; i<=length; i++) {
				if(map[i] != original[i]) {
					int temp = i;
					while(temp<=length) {
						switch(map[temp]) {
						case 0: map[temp] = 1; break;
						case 1: map[temp] = 0; break;
						}
						temp += i;
					}//end while.
					cnt++;
				}
			}
			System.out.println("#" + testcase + " " + cnt);
		}//end testCase.
	}//end main.
}//end class.
