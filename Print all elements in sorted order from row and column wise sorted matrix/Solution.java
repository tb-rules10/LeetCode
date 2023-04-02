import java.util.*;

class MinHeapNode {
	int element;
	int i;
	int j;

	MinHeapNode(int element, int i, int j) {
		this.element = element;
		this.i = i;
		this.j = j;
	}
}

class MinHeap {
	int heapSize;
	MinHeapNode[] harr;

	MinHeap(MinHeapNode[] a, int size) {
		harr = a;
		heapSize = size;

		int i = (heapSize - 1) / 2;
		while (i >= 0) {
			minHeapify(i);
			i--;
		}
	}

	void minHeapify(int i) {
		int l = left(i);
		int r = right(i);
		int smallest = i;
		if (l < heapSize && harr[l].element < harr[i].element) {
			smallest = l;
		}
		if (r < heapSize && harr[r].element < harr[smallest].element) {
			smallest = r;
		}
		if (smallest != i) {
			MinHeapNode temp = harr[i];
			harr[i] = harr[smallest];
			harr[smallest] = temp;
			minHeapify(smallest);
		}
	}

	int left(int i) { return 2 * i + 1; }

	int right(int i) { return 2 * i + 2; }

	MinHeapNode getMin() { return harr[0]; }

	void replaceMin(MinHeapNode x) {
		harr[0] = x;
		minHeapify(0);
	}
}

class Main {
	static int N = 4;

	static void printSorted(int[][] mat) {
		MinHeapNode[] harr = new MinHeapNode[N];
		for (int i = 0; i < N; i++) {
			harr[i] = new MinHeapNode(mat[i][0], i, 1);
		}
		MinHeap heap = new MinHeap(harr, N);

		for (int count = 0; count < N * N; count++) {
			MinHeapNode root = heap.getMin();
			System.out.print(root.element + " ");

			if (root.j < N) {
				root.element = mat[root.i][root.j];
				root.j += 1;
			} else {
				root.element = Integer.MAX_VALUE;
			}

			heap.replaceMin(root);
		}
	}

	public static void main(String[] args) {
		int[][] mat = {
				{10, 20, 30, 40},
				{15, 25, 35, 45},
				{27, 29, 37, 48},
				{32, 33, 39, 50}
		};

		printSorted(mat);
	}
}
