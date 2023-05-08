import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static class Edge {
		int ed, dist;

		public Edge(int ed, int dist) {
			this.ed = ed;
			this.dist = dist;
		}
	}

	static List<Edge>[] edge;
	static boolean[] visited;
	static int n, result, point;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		edge = new ArrayList[n + 1];
		visited = new boolean[n + 1];

		for (int i = 1; i < n + 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			edge[v] = new ArrayList<>();
			for (;;) {
				int ed = Integer.parseInt(st.nextToken());
				if (ed == -1)
					break;
				int dist = Integer.parseInt(st.nextToken());
				Edge e = new Edge(ed, dist);
				edge[v].add(e);
			}
		}
		
		visited[1] = true;
		getPie(1, 0);
		visited[1] = false;
		
		visited[point] = true;
		getPie(point, 0);

		System.out.println(result);
	}

	private static void getPie(int st, int dist) {
		int size = edge[st].size();

		if (dist != 0 && size == 1) {
			if(result < dist) {
				point = st;
				result = dist;
			}
			return;
		}

		for (int i = 0; i < size; i++) {
			int end = edge[st].get(i).ed;

			if (!visited[end]) {
				visited[end] = true;
				getPie(end, dist + edge[st].get(i).dist);
				visited[end] = false;
			}
		}
	}
}