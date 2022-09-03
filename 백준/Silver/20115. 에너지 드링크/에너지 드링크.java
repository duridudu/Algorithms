import java.util.Arrays;
import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] drinks = new int[N];
		for (int i = 0; i < N; i++) {
			drinks[i] = sc.nextInt();
		} // drinks 입력 완료
		Arrays.sort(drinks);
		// 가장 많은 양의 에너지드링크에 가장 적은 양부터 반씩 채워넣어야 손실이 가장 적다.
		double sum = (double) drinks[N - 1];
		for (int i = 0; i < N - 1; i++) {
			sum += drinks[i] / 2.0;
		}
		System.out.println(sum);
	}//main
}
