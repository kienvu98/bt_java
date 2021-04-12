package bai1;

public class Prim {
	static int matrix[][] = { { 0, 7, 0, 5, 0, 0, 0 }, { 7, 0, 8, 9, 7, 0, 0 }, { 0, 8, 0, 0, 5, 0, 0 },
			{ 5, 9, 0, 0, 15, 6, 0 }, { 0, 7, 5, 15, 0, 8, 9 }, { 0, 0, 0, 6, 8, 0, 11 }, { 0, 0, 0, 0, 9, 11, 0 } };

	public static void main(String args[]) {
		System.out.println("ma tran ke la :");
		print(matrix);
		System.out.println("tập cạnh là");
		prim(2, matrix);
	}

	public static void prim(int start, int matrix[][]) {
		boolean daQua[] = new boolean[matrix.length];
		int key[] = new int[matrix.length];
		int list[] = new int[matrix.length];
		for (int i = 0; i < matrix.length; i++) {
			daQua[i] = false;
			key[i] = Integer.MAX_VALUE;
			list[i] = 0;
		}
		key[start] = 0;
		for (int i = 0; i < matrix.length - 1; i++) {
			int u = minKey(key, daQua);
			daQua[u] = true;
			for (int v = 0; v < matrix.length; v++) {
				if (!daQua[v] && matrix[u][v] > 0 && matrix[u][v] < key[v]) {
					key[v] = matrix[u][v];
					list[v] = u;
				}
			}
		}

		int matrixKQ[][] = new int[daQua.length][daQua.length];
		for (int i = 0; i < matrixKQ.length; i++) {
			matrixKQ[list[i]][i] = matrixKQ[i][list[i]] = matrix[list[i]][i];

		}
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				if (i > j && matrixKQ[i][j] > 0) {
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

	private static int minKey(int[] key, boolean[] daQua) {
		// TODO Auto-generated method stub
		int min = Integer.MAX_VALUE;
		int u = -1;
		for (int i = 0; i < daQua.length; i++) {
			if (!daQua[i] && key[i] < min) {
				min = key[i];
				u = i;
			}
		}
		return u;
	}
}
