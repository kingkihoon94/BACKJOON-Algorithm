import java.util.Scanner;

public class BOJ_영화감독숌 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		int start = 660;
		int cnt = 0;
		while(true) {
			if(number == cnt) break;
			start++;
			
			int temp_num = start;
			String temp = "";
			while(temp_num  != 0) {
				temp += temp_num % 10;
				temp_num /= 10; 
			} //거꾸로 받아버리기.
			//System.out.println(temp);
			int six_cnt = 0;
			for(int i=0; i<temp.length(); i++) {
				if(temp.charAt(i) == '6') {
					six_cnt++;
					if(six_cnt == 3) cnt++;
				}
				else six_cnt = 0;
			}
		}//end while.
		System.out.println(start);
	}
}
