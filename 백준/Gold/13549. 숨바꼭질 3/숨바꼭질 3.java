import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, K;
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		K = sc.nextInt();
		arr = new int[100001];
		arr[N] = 1;
		int res = bfs(N);
		System.out.println(res);
	}

	private static int bfs(int n) {
		Queue<Integer> q = new LinkedList<>();
		q.add(n);
		while (!q.isEmpty()) {
//			System.out.println(q.toString());
			n = q.poll();
			//for (int i = 0; i < 20; i++) {
			//	System.out.print(arr[i] + " ");
			//}
			//System.out.println();
			//System.out.println(n);
			int minus = n - 1;
			int plus = n + 1;
			int cross = n * 2;

			if (n == K) {
				return arr[n] - 1;
			}
			
			if (minus >= 0) {
				if (arr[minus] == 0 || arr[n] + 1 < arr[minus]) {
					arr[minus] = arr[n] + 1;
					q.add(minus);
				}
			}

			if (plus <= 100000) {
				if (arr[plus] == 0 || arr[n] + 1 < arr[plus]) {
					arr[plus] = arr[n] + 1;
					q.add(plus);
				}
			}
			
			if (cross <= 100000) {
				if (arr[cross] == 0 || arr[n] < arr[cross]) {
					arr[cross] = arr[n];
					q.add(cross);
				}
			}
		}
		return arr[N] - 1;
	}
}
