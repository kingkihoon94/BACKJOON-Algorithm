import java.util.Scanner;

public class BOJ_신기한소수 {
	static int N;
	static String temp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		dfs("2",1);
		dfs("3",1);
		dfs("5",1);
		dfs("7",1);
	}//end main.
	
	public static void dfs(String s , int cnt) {
		if(cnt == N) {
			System.out.println(s);
			return ;
		}
		temp = s + 1;
		if(prime(Integer.parseInt(temp))) dfs(temp, cnt+1);
		temp = s + 3;
		if(prime(Integer.parseInt(temp))) dfs(temp, cnt+1);
		temp = s + 7;
		if(prime(Integer.parseInt(temp))) dfs(temp, cnt+1);
		temp = s + 9;
		if(prime(Integer.parseInt(temp))) dfs(temp, cnt+1);
	}//end dfs.
	
	public static boolean prime(int temp) {
		int sqrt = (int)Math.sqrt(temp);
		for(int i=2; i<=sqrt; i++) {
			if(temp%i == 0) return false;
		}
		return true;
	}//end prime.
}//end class.
