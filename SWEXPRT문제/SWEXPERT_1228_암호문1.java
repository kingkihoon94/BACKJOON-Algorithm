import java.util.LinkedList;
import java.util.Scanner;


public class SWEXPERT_1228_¾ÏÈ£¹®1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int testcase=1; testcase<=10; testcase++) {
			LinkedList<Integer> list = new LinkedList();
			int L = sc.nextInt();
			for(int i=0; i<L; i++) {
				list.add(sc.nextInt());
			}
			int inst = sc.nextInt();
			for(int i=0; i<inst; i++) {
				String name = sc.next();
				int start = sc.nextInt();
				int many =  sc.nextInt();
				for(int j=0; j<many; j++) {
					list.add(start, sc.nextInt());
					start++;
				}
			}
			System.out.print("#" + testcase + " ");
			for(int i=0; i<10; i++) {
				System.out.print(list.poll() + " ");
			}
			System.out.println("");
		}
	}
}
