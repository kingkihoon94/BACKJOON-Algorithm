import java.util.Scanner;

public class JO_하노이 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int Plate = sc.nextInt();
		hanoi(Plate,1,3,2);
	}
	public static void hanoi(int num, int start, int end, int middle) {//start:원판 처음있는 기둥 , end:다 끝나고 원판 있는 기둥,  middle:나머지 기둥.
		if(num == 1) {
			System.out.println(num+ " : "+  start + " -> " + end);
			return;
		}
		hanoi(num-1, start, middle, end);
		System.out.println(num+ " : "+  start + " -> " + end);
		hanoi(num-1, middle, end, start);
		//n-1개가 1번에서 2번으로 가야되고
		//가장큰 1개가 1번에서 3번으로 가야되고
		//n-1개가 2번에서 3번으로 가야되고.
	}
}
