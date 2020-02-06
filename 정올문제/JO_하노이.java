import java.util.Scanner;

public class JO_�ϳ��� {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int Plate = sc.nextInt();
		hanoi(Plate,1,3,2);
	}
	public static void hanoi(int num, int start, int end, int middle) {//start:���� ó���ִ� ��� , end:�� ������ ���� �ִ� ���,  middle:������ ���.
		if(num == 1) {
			System.out.println(num+ " : "+  start + " -> " + end);
			return;
		}
		hanoi(num-1, start, middle, end);
		System.out.println(num+ " : "+  start + " -> " + end);
		hanoi(num-1, middle, end, start);
		//n-1���� 1������ 2������ ���ߵǰ�
		//����ū 1���� 1������ 3������ ���ߵǰ�
		//n-1���� 2������ 3������ ���ߵǰ�.
	}
}
