import java.util.Scanner;

public class SWEXPERT_1231_중위순회 {
	static char[] tree;
	static int[] tree2;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int testcase = 1; testcase<=10; testcase++) {
			tree = new char[101];
			tree2 = new int[101];
			int V = sc.nextInt();
			int left = 0;
			int right = 0;
			tree2[1] = 1;
			for(int i=1; i<=V; i++) {
				int start = sc.nextInt();
				char value = sc.next().charAt(0);
				if((V%2 == 0 && i < V/2) || (V%2 == 1 && i <= V/2)) {//171 면 85, 172도 85.
					left = sc.nextInt();
					right = sc.nextInt();
					
					tree2[2*start] = left;
					tree2[2*start +1] = right;
				}
				else if(V%2 == 0 && i == V/2) {
					left = sc.nextInt();
					tree2[2*start] = left;
				}
				tree[start] = value;
			}//input.
			System.out.print("#" + testcase + " ");
			inOrder(1);
			System.out.println("");
		}//end testcase.
	}//end main.
	public static void inOrder(int index) {
		if(index >= tree.length || tree[index] == 0) {// 배열 범위를 벗어나거나, 자식이 없으면.
			return ;
		}
		inOrder(index*2);
		System.out.print(tree[index]);
		inOrder(index*2+1);
	}
}
