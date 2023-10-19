import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static long[] heap;
    static int size = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        heap = new long[n + 1];

        for (int i = 0; i < n; i++) {
            long operation = Integer.parseInt(br.readLine());

            if (operation == 0) { // 삭제
                if (size > 0) {
                    sb.append(heap[1] + "\n");
                    heap[1] = heap[size--];
                    siftDown(1);
                } else {
                    sb.append(0 + "\n");
                }
            } else { // 삽입
                heap[++size] = operation;
                siftUp(size);
            }
        }

        System.out.println(sb);
    }

    private static void siftUp(int idx) {
        if (idx == 1) return;

        if (heap[idx] > heap[idx / 2]) {
            swap(idx, idx / 2);
            siftUp(idx / 2);
        }
    }

    private static void swap(int i, int j) {
        long temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private static void siftDown(int idx) {
        if (idx * 2 - 1 > size) return; // 자식 노드가 없으면 중단

        if (size >= idx * 2 + 1) { // 자식 노드 중 오른쪽 노드가 있는 경우
            if (heap[idx * 2] > heap[idx * 2 + 1]) { // 왼쪽이 더 크고
                if (heap[idx * 2] > heap[idx]) { // 상위보다 크면
                    swap(idx * 2, idx);
                    siftDown(idx * 2);
                }
            } else { // 오른쪽이 더 크고
                if (heap[idx * 2 + 1] > heap[idx]) { // 상위보다 크면
                    swap(idx * 2 + 1, idx);
                    siftDown(idx * 2 + 1);
                }
            }
        } else { // 오른쪽 노드가 없는 경우
            if (heap[idx * 2] > heap[idx]) {
                swap(idx * 2, idx);
                siftDown(idx * 2);
            }
        }
    }
}