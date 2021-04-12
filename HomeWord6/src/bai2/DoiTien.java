package bai2;

public class DoiTien {
	public static void main(String args[]) {
		int[] arr = {1,2,3,4 };
		doiTien(arr, 9);
	}

	public static void doiTien(int[] array, int soTien) {
		int tmp[][] = new int[array.length + 1][soTien + 1];
		// quy hoạch động
		for (int i = 0; i < tmp.length; i++) {
			for (int j = 0; j < tmp[0].length; j++) {
				if (j == 0) {
					tmp[i][j] = 0;
				} else if (i == 0) {
					tmp[i][j] = soTien;
				} else if (j < array[i - 1]) {
					tmp[i][j] = tmp[i - 1][j];
				} else {
					tmp[i][j] = Math.min(tmp[i - 1][j], 1 + tmp[i][j - array[i - 1]]);
				}
			}
		}
		print(tmp);
		/*// truy vết tìm nghiệm
		for (int i = tmp.length - 1; i >= 0; i--) {
			for (int j = tmp[0].length-1; j >= 0; j--) {
				if (tmp[i][j] == tmp[i - 1][j]) {
					tmp[i][j] = tmp[i - 1][j];
				} else if (tmp[i][j] == (1 + tmp[i][j - array[i - 1]])) {
					tmp[i][j] =  tmp[i][j - array[i - 1]];
					System.out.print(j+ " ");
					break;
				}
			}
		}*/

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
