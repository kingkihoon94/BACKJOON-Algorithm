import java.util.Scanner;

public class SWEXPERT_1233_사칙연산유효성검사 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int testcase = 1; testcase<=10; testcase++) {
			char[] tree = new char[201];
			int V = sc.nextInt();
			int left = 0;
			int right = 0;
			for(int i=1; i<=V; i++) {
				int start = sc.nextInt();
				char value = sc.next().charAt(0);
				if((V%2 == 0 && i < V/2) || (V%2 == 1 && i <= V/2)) {//171 면 85, 172도 85.
					left = sc.nextInt();
					right = sc.nextInt();
				}
				else if(V%2 == 0 && i == V/2) {
					left = sc.nextInt();
				}
				tree[start] = value;
			}//input.
			if(V%2 == 0) System.out.println("#" + testcase + " " + 0);
			else {
				boolean check = true;
				for(int i=1; i<=V; i++) {
					if(i<= V/2) {
						if(tree[i] == '+' || tree[i] == '-' || tree[i] == '*' || tree[i] == '/' ) continue;
						else {
							System.out.println("#" + testcase + " " + 0);
							check = false;
							break;
						}
					}
					else {
						if(tree[i] == '+' && tree[i] == '-' && tree[i] == '*' && tree[i] == '/' ) {
							System.out.println("#" + testcase + " " + 0);
							check = false;
							break;
						}
					}
				}//end for.
				if(check) System.out.println("#" + testcase + " " + 1);
			}
		}//end testcase.
	}//end main.
}
