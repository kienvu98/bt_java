package bai2;

public class BienDoiXau {
	public static void main(String args[]) {
		String a = "abcxyz";
		String b = "abcxtzxy";
		char a1[] = a.toCharArray();
		char b1[] = b.toCharArray();
		bienDoiXau(a1, b1);
	}

	public static void bienDoiXau(char[] a1, char[] b1) {
		int tmp[][] = new int[a1.length + 1][b1.length + 1];
		for (int i = 0; i < tmp.length; i++) {
			for (int j = 0; j < tmp[0].length; j++) {
				if (i == 0) {
					tmp[i][j] = j;
				} else if (j == 0) {
					tmp[i][j] = i;
				} else if (a1[i - 1] == b1[j - 1]) {
					tmp[i][j] = tmp[i - 1][j - 1];
				} else if (a1[i-1] != b1[j-1]) {
					tmp[i][j] = Math.min(Math.min(tmp[i - 1][j], tmp[i][j - 1]), tmp[i - 1][j - 1]) + 1;
				}
			}
		}
		System.out.println("bảng phương án");
		print(tmp);
	}

	private static void print(int[][] tmp) {
		// TODO Auto-generated method stub
		for (int i = 0; i < tmp.length; i++) {
			for (int j = 0; j < tmp[0].length; j++) {
				System.out.print(tmp[i][j]+" ");
			}
			System.out.println();
		}
	}
}
