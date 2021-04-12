package bai2;

import java.util.ArrayList;

public class Kruskal {
	static int matrix[][] = { { 0, 7, 0, 5, 0, 0, 0 }, { 7, 0, 8, 9, 7, 0, 0 }, { 0, 8, 0, 0, 5, 0, 0 },
			{ 5, 9, 0, 0, 15, 6, 0 }, { 0, 7, 5, 15, 0, 8, 9 }, { 0, 0, 0, 6, 8, 0, 11 }, { 0, 0, 0, 0, 9, 11, 0 } };

	public static void main(String args[]) {
		// tạo danh sách các cạnh của đồ thị
		ArrayList<Edge> listEdge = new ArrayList<Edge>();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				if (i > j && matrix[i][j] > 0) {
					Edge edge = new Edge(j, i, matrix[i][j]);
					listEdge.add(edge);
				}
			}
		}
		System.out.println("ma tran ke la:");
		print(matrix);
		
		System.out.println("tap cac canh cua cay bao trum la:");
		krusal(matrix, listEdge);
	}

	public static void krusal(int matrix[][], ArrayList<Edge> listEdge) {
		int kq[][] = new int[matrix.length][matrix.length];

		int list[] = new int[matrix.length];
		for (int i = 0; i < list.length; i++) {
			list[i] = -1;
		}
		// sắp xếp các cạnh của danh sách cạnh
		listEdge.sort((l1, l2) -> {
			if (l1.getWeigth() >= l2.getWeigth()) {
				return 1;
			} else {
				return -1;
			}
		});
		for (int i = 0; i < listEdge.size(); i++) {
			int u = find(list, listEdge.get(i).getU());
			int v = find(list, listEdge.get(i).getV());

			if (u != v) {
				int x = listEdge.get(i).getU();
				int y = listEdge.get(i).getV();
				kq[x][y] = kq[y][x] = listEdge.get(i).getWeigth();
				union(u, v, list);
			}
		}
		//print(kq);
		for (int i = 0; i < kq.length; i++) {
			for (int j = 0; j < kq.length; j++) {
				if (i > j && kq[i][j] > 0) {
					System.out.println(j + " " + i);
				}
			}
		}
	}

	private static void print(int[][] matrix) {
		// TODO Auto-generated method stub
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}

	}

	private static void union(int u, int v, int[] list) {
		// TODO Auto-generated method stub
		if (list[u] > list[v]) {
			list[v] += list[u];
			list[u] = v;
		} else {
			list[u] += list[v];
			list[v] = u;

		}

	}

	private static int find(int[] list, int x) {
		// TODO Auto-generated method stub
		while (list[x] > -1) {
			x = list[x];
		}
		return x;
	}

}
