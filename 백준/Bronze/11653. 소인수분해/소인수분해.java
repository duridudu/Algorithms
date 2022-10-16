import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		int i = 2;
		
		// 나누면서 몫이 소수가 되면 소인수분해 멈춘다. 
		while (N!=1 && !isPrime(N)) {
			// 현재 i로 나누어떨어지면 N을 업데이트하고 sb에 추가 
			if (N % i == 0) {
				sb.append(i).append('\n');
				N = N / i;
			} else {
				i++;
			}
		}
		
		// 1이면 아무것도 출력하지 않는다. 
		if (N==1) {
			sb.append("");
		}
		else {
			sb.append(N);			
		}
		System.out.println(sb);
	}

	public static boolean isPrime(int n) {
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
}
