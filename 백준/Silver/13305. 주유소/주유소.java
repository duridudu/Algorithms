
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] price;
	static int[] dist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		dist = new int[N - 1];
		price = new int[N - 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N - 1; i++) {
			dist[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N - 1; i++) {
			price[i] = Integer.parseInt(st.nextToken());
		}
		long sum = 0;
		long minCost = price[0];
		for (int i = 0; i < N - 1; i++) {
			if (price[i] < minCost) {
				minCost = price[i];
			}
			sum+=(minCost*dist[i]);
		}
//		long sum = dist[0] * price[0];
//		long minPrice = price[0];
//		for (int i=1; i<price.length-1;i++) {
//			if (price[i].compareTo(minPrice) < 0) {
//				
//			}
//		}
//		for (int i = price.length - 1; i >= 1; i--) {
//			sum += (long) dist[i] * minPrice(i);
//		}
		System.out.println(sum);
	}

//	private static int minPrice(int i) {
//		int[] temp = new int[i + 1];
//		temp = Arrays.copyOfRange(price, 0, i + 1);
//		Arrays.sort(temp);
//		int res = temp[0];
//		return res;
//	}
}
