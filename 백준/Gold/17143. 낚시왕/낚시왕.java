import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static class Shark implements Comparable<Shark> {
		int x, y, v, d, size;

		public Shark(int x, int y, int v, int d, int size) {
			this.x = x;
			this.y = y;
			this.v = v;
			this.d = d;
			this.size = size;
		}

		@Override
		public int compareTo(Shark o) {
			return Integer.compare(o.size, this.size);
		}
	}

	static PriorityQueue<Shark> sharks = new PriorityQueue<>();
	static PriorityQueue<Shark> temp = new PriorityQueue<>();
	static int[][] map;
	static int r, c, result = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		r = sc.nextInt();
		c = sc.nextInt();
		map = new int[r][c];
		int m = sc.nextInt();
		for (int i = 0; i < m; i++) {
			int x = sc.nextInt() - 1;
			int y = sc.nextInt() - 1;
			int v = sc.nextInt();
			int d = sc.nextInt();
			int size = sc.nextInt();
			Shark shark = new Shark(x, y, v, d, size);
			sharks.offer(shark);
			map[x][y] = size;
		}

		int sec = -1;
		while (++sec < c) {
			for (int i = 0; i < r; i++) {
				if (map[i][sec] > 0) {
					while (!sharks.isEmpty()) {
						Shark cur = sharks.poll();
						if (cur.x == i && cur.y == sec) {
							result += cur.size;
							continue;
						}
						temp.offer(cur);
					}
					break;
				}
			}
			while (!sharks.isEmpty()) {
				temp.offer(sharks.poll());
			}
			SharksMove();
		}

		System.out.println(result);
	}

	private static void SharksMove() {
		map = new int[r][c];
		while (!temp.isEmpty()) {
			Shark cur = temp.poll();
			switch (cur.d) {
			case 1: // 위
				int x = cur.x - cur.v;
				if (x >= 0) {
					cur.x = x;
				} else {
					x = Math.abs(x);
					int quo = x / (r - 1);
					x += quo;
					x = x % (2 * r);
					if (x < r) {
						cur.d = 2;
						cur.x = x;
					} else {
						cur.d = 1;
						cur.x = (2 * r - 1) - x;
					}
				}
				break;
			case 2: // 아래
				x = cur.x + cur.v;
				int quo = x / (r - 1);
				x += quo;
				x = x % (2 * r);
				if (x < r) {
					cur.d = 2;
					cur.x = x;
				} else {
					cur.d = 1;
					cur.x = (2 * r - 1) - x;
				}
				break;
			case 3: // 오른쪽
				int y = cur.y + cur.v;
				quo = y / (c - 1);
				y += quo;
				y = y % (2 * c);
				if (y < c) {
					cur.d = 3;
					cur.y = y;
				} else {
					cur.d = 4;
					cur.y = (2 * c - 1) - y;
				}
				break;
			case 4: // 왼쪽
				y = cur.y - cur.v;
				if (y >= 0) {
					cur.y = y;
				} else {
					y = Math.abs(y);
					quo = y / (c - 1);
					y += quo;
					y = y % (2 * c);
					if (y < c) {
						cur.d = 3;
						cur.y = y;
					} else {
						cur.d = 4;
						cur.y = (2 * c - 1) - y;
					}
				}
				break;
			}
			int p = cur.x;
			int q = cur.y;
			if (cur.size > map[p][q]) {
				map[p][q] = cur.size;
				sharks.offer(cur);
			}
		}
	}
}