package ontapcuoiki_quaylui;

public class Bai6 {
	public static void main(String args[]) {
		int n = 8;
		int[] x = new int[n + 1];
		int[] t = new int[n + 1];
		x[0] = 1;
		t[0] = 0;
		kiemTra(1, n, x, t);
	}

	public static void kiemTra(int i, int n, int x[], int t[]) {
		for (int v = x[i - 1]; v <= (n - t[i - 1]); v++) {
			x[i] = v;
			t[i] = t[i - 1] + v;
			if (t[i] == n) {
				print(x, i);
			} else {
				kiemTra(i + 1, n, x, t);
			}
		}
	}

	private static void print(int[] x, int i) {
		// TODO Auto-generated method stub
		for (int j = 1; j <= i; j++) {
			System.out.print(x[j] + " ");
		}
		System.out.println();
	}
}
