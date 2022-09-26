
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, K;
	static int arr[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		arr = new int[100001];
		arr[N] = 1;
		int res = bfs(N);
		System.out.println(res);
	}

	public static int bfs(int n) {
		Queue<Integer> q = new LinkedList<>();
		q.add(n);
		int tmp = 0;
		while (!q.isEmpty()) {
//			System.out.println(q.toString());
//			System.out.println(Arrays.toString(arr));
			tmp = q.poll();
			int minus = tmp - 1;
			int plus = tmp + 1;
			int cross = tmp * 2;
			if (tmp == K) {
				return arr[tmp]-1;
			}
			if (minus >= 0 && arr[minus] == 0) {
				arr[minus] = arr[tmp] + 1;
				q.add(minus);
//				System.out.println(q.toString());
			}
			if (plus <= 100000 && arr[plus] == 0) {
				arr[plus] = arr[tmp] + 1;
				q.add(plus);
			}
			if (cross <= 100000 && arr[cross] == 0) {
				arr[cross] = arr[tmp] + 1;
				q.add(cross);
			}
		}
		return -1;
	}
}
