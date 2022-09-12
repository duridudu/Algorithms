
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long[][] arr = new long[N + 1][10];

		// 헷갈리니까 인덱스도 N=1부터 시작!!!
		// 여기서 J를 0부터 시작하니까 틀렸음. 0으로 시작할 수 없으니까 N=1일 때는 1~9만 고려
		for (int j = 1; j < 10; j++) {
			arr[1][j] = 1;
		}

		// 현재 끝자리가 j일 때 계단수로 올 수 있는 수는 끝자리 +-1한 수
		// 대부분 +-1해서 두 개 씩 가지치기가 되지만, 0이나 1 고려해줘야하므로 경우의 수 나눔
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < 10; j++) {
				// 현재 끝자리가 0이면 +1만 됨
				if (j == 0) {
					arr[i + 1][j] = arr[i][j + 1] % 1000000000;
				}
				// 현재 끝자리가 9이면 -만 됨
				else if (j == 9) {
					arr[i + 1][j] = arr[i][j - 1] % 1000000000;
				}
				// 1~8이면 +-1 인 수들의 계단수 개수 누적해서 더함
				else {
					arr[i + 1][j] = (arr[i][j - 1] + arr[i][j + 1]) % 1000000000;
				}
			}
		} // dp

		long sum = 0;
		for (int i = 0; i < 10; i++) {
			sum += arr[N][i];
		}
		System.out.println(sum % 1000000000);
		sc.close();
	}//main 
}
