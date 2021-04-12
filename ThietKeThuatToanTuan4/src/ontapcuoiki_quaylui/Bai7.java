package ontapcuoiki_quaylui;

public class Bai7 {

	static int count = 0;

	public static void main(String args[]) {
		int n = 8;
		int m = 9;
		int x[] = new int[n];
		Try(0, x, m);
	}

	public static void Try(int i, int[] x, int m) {
		for (int v = 0; v <= 1; v++) {
			int tmp = count;
			if (check(v, i, x, m)) {
				x[i] = v;
				if (i == x.length - 1) {
					print(x);
				} else {
					Try(i + 1, x, tmp);
				}
			}
			count = tmp;
		}
	}

	private static void print(int[] x) {
		// TODO Auto-generated method stub
		for (int i = 0; i < x.length; i++) {
			System.out.print(x[i]);
		}
		System.out.println();
	}

	private static boolean check(int v, int i, int[] x, int m) {
		// TODO Auto-generated method stub
		if (i < m) {
			return true;
		}
		if (v == x[i - m]) {
			count++;
		} else {
			count = 0;
		}
		if (count == m) {
			return false;
		}
		return true;
	}
}
