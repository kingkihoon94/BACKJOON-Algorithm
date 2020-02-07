import java.util.Scanner;

public class BOJ_달팽이올라가기 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A =sc.nextInt();
        int B =sc.nextInt();
		int L =sc.nextInt();
		if((L-A)%(A-B) == 0) System.out.println((L-A)/(A-B) + 1);
		else System.out.println((L-A)/(A-B) + 2);
	}
}
