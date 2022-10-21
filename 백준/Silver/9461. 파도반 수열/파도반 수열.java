
import java.util.Scanner;

public class Main {
	static long[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int N = sc.nextInt();
			arr = new long[N];
			for (int i = 0; i < N; i++) {
				if (i == 0) {
					arr[i] = 1;
				} else if (i == 1) {
					arr[i] = 1;
				} else if (i == 2) {
					arr[i] = 1;
				} else if (i == 3) {
					arr[i] = 2;
				} else if (i == 4) {
					arr[i] = 2;
				} else if (i == 5) {
					arr[i] = 3;
				} else if (i == 6) {
					arr[i] = 4;
				} else if (i == 7) {
					arr[i] = 5;
				} else {
					arr[i] = arr[i - 1] + arr[i - 5];
				}
			}
			System.out.println(arr[N - 1]);
		} // tc
	}
}
