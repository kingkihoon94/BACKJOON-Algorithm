import java.util.Scanner;

public class JO_1240_Á¦°ö±Ù {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String n = sc.next();
		int length = n.length();
		double N = Double.parseDouble(n);
		int pow;
		if(length%2 == 0) pow = length/2;
		else pow = length/2 + 1;
		long start = 1;
		for(int i=1; i<pow; i++) {
			start *= 10;
		}
		long end = start * 10;
		System.out.println(start);
		while(true) {
			if(start * start > N) {
				System.out.println(start-1);
				break;
			}
			start++;
		}
	}
}
