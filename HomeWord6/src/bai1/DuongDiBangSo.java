package bai1;

import java.util.ArrayList;

public class DuongDiBangSo {
	public static void main(String args[]) {
		int[][] arr = { { 9, 9, 9, 2, 6, 1, 6 }, { 4, 5, 2, 1, 4, 5, 1 }, { 2, 3, 9, 8, 1, 3, 4 },
				{ 5, 7, 2, 1, 9, 8, 1 }, { 9, 8, 2, 1, 4, 7, 6 }, { 3, 7, 1, 3, 6, 8, 1 } };
		duongDiBangSo(arr);
	}

	public static void duongDiBangSo(int array[][]) {
		ArrayList<String> arrayList = new ArrayList<String>();
		int tmp[][] = new int[array.length + 1][array[1].length + 1];
		// quy hoạch động
		for (int j = 0; j < tmp[0].length; j++) {
			for (int i = 0; i < tmp.length; i++) {
				if (i == 0 || j == 0) {
					tmp[i][j] = 0;
				} else if (i == tmp.length - 1) {
					tmp[i][j] = Math.max(tmp[i][j - 1], tmp[i - 1][j - 1]) + array[i - 1][j - 1];
				} else {
					tmp[i][j] = Math.max(Math.max(tmp[i][j - 1], tmp[i + 1][j - 1]), tmp[i - 1][j - 1])
							+ array[i - 1][j - 1];
				}
			}
		}
		System.out.println("bảng phương án: ");
		print(tmp);

		// truy vết tìm nghiệm
		int i = tmp.length - 1;
		int j = tmp[0].length - 1;
		int k;
		// System.out.print(tmp[i][j]);
		while (tmp[i][j] != 0) {
			String t = Integer.toString(i) + " " + Integer.toString(j);
			arrayList.add(t);
			k = tmp[i][j] - array[i - 1][j - 1];
			if (k == tmp[i - 1][j - 1]) {
				j--;
				i--;
			} else if (k == tmp[i][j - 1]) {
				j--;
			} else {
				i++;
				j--;
			}
		}
		System.out.println("đường đi là:");
		for (int v = arrayList.size() - 1; v >= 0; v--) {
			System.out.println(arrayList.get(v));
		}
	}

	private static void print(int[][] tmp) {
		// TODO Auto-generated method stub
		for (int i = 0; i < tmp.length; i++) {
			for (int j = 0; j < tmp[1].length; j++) {
				System.out.print(tmp[i][j] + " ");
			}
			System.out.println();
		}
	}
}
