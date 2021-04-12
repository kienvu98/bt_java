package homeword4;

import java.util.ArrayList;
import java.util.Scanner;

public class TimDuong {
	static Scanner sc = new Scanner(System.in);

	public static void main(String args[]) {

		int n = sc.nextInt();
		int matrix[][] = intput(n);
		printMatrix(matrix);
		System.out.print("nhap điểm khởi đầu");
		int s = sc.nextInt();
		System.out.print("nhap điểm kết");
		int f = sc.nextInt();
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		arrayList.add(s);
		boolean daQua[] = inputDaQua(n);
		Try(matrix, 1, daQua, arrayList, f);
	}

	private static void printMatrix(int[][] matrix) {
		// TODO Auto-generated method stub
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}

	}

	private static boolean[] inputDaQua(int n) {
		// TODO Auto-generated method stub
		boolean a[] = new boolean[n];
		for (int i = 0; i < n; i++) {
			a[i] = false;
		}
		return a;
	}

	private static int[][] intput(int n) {
		// TODO Auto-generated method stub
		int a[][] = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		return a;
	}

	public static void Try(int matrix[][], int i, boolean daQua[], ArrayList<Integer> kq, int f) {
		for (int v = 0; v < daQua.length; v++) {
			if ((matrix[kq.get(i - 1)][v] == 1) && (!daQua[v])) {
				int xi = v;
				kq.add(xi);
				daQua[v] = true;
				if (xi == f) {
					print(kq);
					return;
				} else {
					Try(matrix, i + 1, daQua, kq, f);
				}
				daQua[v] = false;
			}
		}
	}

	private static void print(ArrayList<Integer> kq) {
		// TODO Auto-generated method stub
		for (Integer integer : kq) {
			System.out.print(integer + " ");
		}
	}
}
