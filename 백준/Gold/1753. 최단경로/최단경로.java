
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static LinkedList<Node>[] costs;
	static boolean[] visited;
	static PriorityQueue<Node> pq = new PriorityQueue<>();
	static int[] dist;

	static int V, E, K;

	static public void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		V = sc.nextInt(); 
		E = sc.nextInt();
		K = sc.nextInt();
		visited = new boolean[V + 1];
		costs = new LinkedList[V + 1];
		for (int i = 1; i <= V; i++)
			costs[i] = new LinkedList<>();

		dist = new int[V + 1];
		for (int i = 1; i <= V; i++)
			dist[i] = Integer.MAX_VALUE;
		
		// 간선 개수만큼 
		for (int i = 0; i < E; i++) {
			int st = sc.nextInt();
			int ed = sc.nextInt();
			int w = sc.nextInt();
			//시작-끝 기록 
			costs[st].add(new Node(ed, w)); 
		}
		
		
		dijkstra(K);
		
		StringBuilder result = new StringBuilder();
		for (int i = 1; i <= V; i++) {
			if (dist[i] != Integer.MAX_VALUE)
				result.append(dist[i] + "\n");
			else
				result.append("INF\n");
		}
		System.out.print(result);
	}

	private static void dijkstra(int K) {
		dist[K] = 0;
		pq = new PriorityQueue<>(); 
		// 우선순위큐에 시작점과 거리 0 추가 
		pq.add(new Node(K, dist[0]));
		
		// 큐 빌 때까지 반복 
		while (!pq.isEmpty()) {
			Node h = pq.poll();
			if (!visited[h.v]) {
				visited[h.v] = true;

				// 두 정점 사이에 여러 간선이 존재할 수 있음!
				for (Node node : costs[h.v]) {
					int newPathCost = dist[h.v] + node.w;
					if (newPathCost < dist[node.v]) { // 여러 간선 존재 시, 가중치가 작은걸로 갱신
						dist[node.v] = newPathCost;
						pq.add(new Node(node.v, dist[node.v]));
					}
				}
			}
		}
		
	}
}

class Node implements Comparable<Node> {
	public int v;
	public int w;

	public Node(int v, int w) {
		this.v = v;
		this.w = w;
	}

	@Override
	public int compareTo(Node o) {
		return this.w - o.w;
	}
}