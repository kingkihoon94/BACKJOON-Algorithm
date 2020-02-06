import java.util.Scanner;

public class JO_ÆÑÅä¸®¾ó {
	static long sum = 1L;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int start_num = sc.nextInt();
		factorial(start_num);
		System.out.println(sum);
	}
	public static void factorial(int num) {
		if(num <=1) {
			System.out.println(num+"! = "+num);
			return;
		}
		System.out.println(num+"! = "+num+" * "+(num-1)+"!");
		sum *= num;
		//System.out.println(sum);
		factorial(num-1);
	}
}
