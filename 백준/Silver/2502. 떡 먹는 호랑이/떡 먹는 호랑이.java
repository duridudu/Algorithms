
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static int [] dp = new int [30];
	public static int fibo(int n) {
		if(n == 1) return 1;
        if(n == 2) return 1;
        if(dp[n] != 0) return dp[n];
        dp[n] = fibo(n - 2) + fibo(n - 1);
        return dp[n];

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int D = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int a = fibo(D - 2);
		int b = fibo(D - 1);
		int first = 0;
		int second = 0;
		
		for (int y = 1; y < K; y++) {
			for (int x = 1; x <= K/2; x++) {
				if (a * x + b * y == K) {
					first = x;
					second = y;
					break;
				}
			}
		}
		System.out.println(first);
		System.out.println(second);
	}
}
