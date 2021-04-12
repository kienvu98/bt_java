package homeword4;

public class NguoiBanHang {
	static int best = Integer.MAX_VALUE;
	static int[] x = { -1, -1, -1, -1, -1, -1, -1, -1 };
	static int[] bestX = { -1, -1, -1, -1, -1, -1, -1, -1 };

	public static void main(String[] args) {
		int[][] a = { { -1, 3, -1, -1, -1, -1, -1, 3 }, { 3, -1, 5, -1, -1, -1, 6, 3 }, { -1, 5, -1, 7, 40, 1, 3, -1 },
				{ -1, -1, 7, -1, 5, 1, 4, -1 }, { -1, -1, 40, 5, -1, 9, 1, -1 }, { -1, -1, 1, 1, 9, -1, 2, -1 },
				{ -1, 6, 3, 4, 1, 2, -1, 8 }, { 3, 3, -1, -1, -1, -1, 8, -1 } };

		x[0] = 4;

		boolean[] passed = new boolean[a.length];
		for (int i = 0; i < a.length; i++)
			passed[i] = false;
		passed[x[0]] = true;
		tries(1, 0, a, passed);

		for (int i = 0; i < a.length; i++) {
			if (bestX[i] > -1) {
				int j = bestX[i] + 1;
				System.out.print(j + " ");
			}
		}
		System.out.println();
		System.out.println("best = " + best);
	}

	public static void tries(int i, int c, int[][] a, boolean[] passed) {
		for (int v = 0; v < a.length; v++) {
			if (a[x[i - 1]][v] > -1 && !passed[v]) {
				int c1 = c + a[x[i - 1]][v];
				if (c1 < best) {
					x[i] = v;
					passed[v] = true;
					if (x[i] == 0) {
						for (int t = 0; t < a.length; t++)
							bestX[t] = x[t];
						best = c1;
					} else if (i < a.length - 1) {
						tries(i + 1, c1, a, passed);
					}
					passed[v] = false;
					x[i] = -1;
				}
			}
		}
	}
}
