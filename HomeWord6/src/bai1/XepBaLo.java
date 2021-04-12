package bai1;

import java.util.ArrayList;

public class XepBaLo {
	public static void main(String args[]) {
		int[] weigth = { 2, 1, 2, 1 };
		int[] value = { 3, 2, 2, 1 };
		xepBaLo(weigth, value, 4);
	}

	public static void xepBaLo(int[] weigth, int[] value, int weigthBalo) {
		int tmp[][] = new int[value.length + 1][weigthBalo + 1];
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		// System.out.print(tmp[1].length);
		// quy hoạch động
		for (int i = 0; i < tmp.length; i++) {
			for (int j = 0; j < tmp[0].length; j++) {
				if (i == 0 || j == 0) {
					tmp[i][j] = 0;
				} else if (j < weigth[i - 1]) {
					tmp[i][j] = tmp[i - 1][j];
				} else {
					tmp[i][j] = Math.max(tmp[i - 1][j], value[i - 1] + tmp[i - 1][j - weigth[i - 1]]);
				}
			}
		}
		System.out.println("bảng phương án:");
		print(tmp);
		// truy vết tìm nghiệm
		for (int i = tmp.length - 1; i > 0; i--) {
			for (int j = tmp[0].length - 1; j > 0; j--) {
				if (tmp[i][j] == tmp[i - 1][j]) {
					tmp[i][j] = tmp[i - 1][j];
				} else if (tmp[i][j] == (tmp[i - 1][j - weigth[i - 1]] + value[i - 1])) {
					tmp[i][j] = tmp[i - 1][j - weigth[i - 1]];
					arrayList.add(i);
					break;
				}
			}
		}
		System.out.println("các đồ vật được chọn cho vào balo là:");
		for (int i = arrayList.size() - 1; i >= 0; i--) {
			System.out.print(arrayList.get(i) + " ");
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
