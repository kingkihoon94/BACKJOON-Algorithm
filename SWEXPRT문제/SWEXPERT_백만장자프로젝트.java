import java.util.Scanner;

public class SWEXPERT_백만장자프로젝트 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for(int testcase=1; testcase<=TC; testcase++) {
			int day = sc.nextInt();
			int[] price = new int[day];
			for(int i=0; i<day; i++){
				price[i] = sc.nextInt();
			}
			int flag = day-1;
			long sum = 0;
			int temp_price = price[day-1];
			for(int i = day-2; i>=0; i--) {
				if(price[i] >= temp_price) {
					flag = i;
					temp_price = price[flag];
				}
				//System.out.println(temp_price - price[i]);
				sum += (temp_price - price[i]);
			}
			System.out.println("#" + testcase + " " +sum);
		}
	}
}
