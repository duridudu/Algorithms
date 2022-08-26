import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
//		ArrayList<Integer>[] arr = new ArrayList[6];
		int arr[][];
		int room = sc.nextInt();
		arr = new int[6][2];

		for (int i = 0; i < N; i++) {
			int s = sc.nextInt(); // 성별
			int g = sc.nextInt(); // 학년
//			arr[g - 1].add(s); // {g,s} 안됨!!
			// 성별 입력 받고, 해당 학년 인덱스의 성별 자리를 추가해줌
			if (s == 0) {
				arr[g - 1][0] += 1;
			} else {
				arr[g - 1][1] += 1;
			}
		} // 입력 받음

		int ans = 0;
		for (int i = 0; i < 6; i++) {
			// 한 학년별로
			int cnt = 0;
			for (int j = 0; j < 2; j++) {
				ans += arr[i][j] / room;
				if (arr[i][j] % room >= 1) {
					ans += 1;
				}
			}
		}
		System.out.print(ans);

	}// main
}
