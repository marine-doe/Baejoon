import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Main {
	static int[][] arr;
	static int[] count;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt() - 1;
		int c = sc.nextInt() - 1;
		int k = sc.nextInt();

		arr = new int[100][100];

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		int rs = 3, cs = 3, time = 0;
		while (time <= 100) {
			if (arr[r][c] == k) {
				break;
			}

			time++;

			if (rs >= cs) {
				cs = RowCal(cs);
			} else { // cs > rs
				rs = ColCal(rs);
			}
		}

		if (time > 100) {
			System.out.println(-1);
		} else {
			System.out.println(time);
		}
	}

	private static int ColCal(int rs) {
		int max = 0;
		for (int c = 0; c < 100; c++) {
			Map<Integer, Integer> map = new HashMap<>();
			for (int r = 0; r < rs; r++) {
				if (arr[r][c] > 0) {
					map.putIfAbsent(arr[r][c], 0);
					map.put(arr[r][c], map.get(arr[r][c]) + 1);
				}
			}

			for (int i = 0; i < 100; i++) {
				arr[i][c] = 0;
			}

			max = Math.max(max, map.size() * 2);

			List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
			Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
				@Override
				public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
					int result = o1.getValue().compareTo(o2.getValue());
					if (result == 0) {
						result = o1.getKey().compareTo(o2.getKey());
					}
					return result;
				}
			});

			int idx = 0;
			for (Map.Entry<Integer, Integer> entry : list) {
				if (idx >= 100) {
					break;
				}
				arr[idx][c] = entry.getKey();
				arr[idx + 1][c] = entry.getValue();
				idx += 2;
			}

			for (int i = idx; i < 100; i++) {
				arr[idx][c] = 0;
			}
		}
		return max;
	}

	private static int RowCal(int cs) {
		int max = 0;
		for (int r = 0; r < 100; r++) {
			Map<Integer, Integer> map = new HashMap<>();
			for (int c = 0; c < cs; c++) {
				if (arr[r][c] > 0) {
					map.putIfAbsent(arr[r][c], 0);
					map.put(arr[r][c], map.get(arr[r][c]) + 1);
				}
			}

			arr[r] = new int[100];

			max = Math.max(max, map.size() * 2);

			List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
			Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
				@Override
				public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
					int result = o1.getValue().compareTo(o2.getValue());
					if (result == 0) {
						result = o1.getKey().compareTo(o2.getKey());
					}
					return result;
				}
			});

			int idx = 0;
			for (Map.Entry<Integer, Integer> entry : list) {
				if (idx >= 100) {
					break;
				}
				arr[r][idx] = entry.getKey();
				arr[r][idx + 1] = entry.getValue();
				idx += 2;
			}

			for (int i = idx; i < 100; i++) {
				arr[r][idx] = 0;
			}
		}
		return max;
	}
}