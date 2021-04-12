package bai3;

public class XauConChungDaiNhat {
	public static void main(String args[]) {
		String a="ththkdida";
		String b="hsdkurdida";
		char[] a1= a.toCharArray();
		char[] b1=b.toCharArray();
		xauConChungDaiNhat(a1, b1);
	}

	public static void xauConChungDaiNhat(char a[], char[] b) {
		int[][] tmp = new int[a.length + 1][b.length + 1];
		for (int i = 0; i < tmp.length; i++) {
			for (int j = 0; j < tmp[0].length; j++) {
				if (i == 0 || j == 0) {
					tmp[i][j] = 0;
				} else if (a[i - 1] == b[j - 1]) {
					tmp[i][j] = tmp[i - 1][j - 1] + 1;
				} else if (a[i - 1] != b[j - 1]) {
					tmp[i][j] = Math.max(tmp[i - 1][j], tmp[i][j - 1]);
				}
			}
		}
		System.out.println("bang phương án:");
		print(tmp);
	}

	private static void print(int[][] tmp) {
		// TODO Auto-generated method stub
		for (int i = 0; i < tmp.length; i++) {
			for (int j = 0; j < tmp[0].length; j++) {
				System.out.print(tmp[i][j] + " ");
			}
			System.out.println();
		}
	}
}
