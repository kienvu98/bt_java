package bai1;

public class DoiTien {
	public static void main(String args[]) {
		int a[] = { 10, 6, 1 };
		int t=55;
		changeMoney(a, t);
	}

	public static void changeMoney(int a[], int t) {
		int k[] = new int[a.length];
		for (int i = 0; i < k.length; i++) {
			k[i] = 0;
		}
		int j = 0;
		while (j < k.length && t > 0) {
			k[j] = t / a[j];
			t -= k[j] * a[j];
			j = j + 1;
		}
		if (t > 0) {
			System.out.println("khong co loi giai");
		} else {
			print(k);
		}
	}

	private static void print(int[] k) {
		// TODO Auto-generated method stub
		for (int i = 0; i < k.length; i++) {
			System.out.print(k[i] + " ");
		}
	}
}
