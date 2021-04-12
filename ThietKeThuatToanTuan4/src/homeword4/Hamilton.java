package homeword4;

import java.util.Scanner;

public class Hamilton {
	public static void main(String args[]) {
		int matrix[][] = { { 0, 0, 1, 1, 1 }, { 0, 0, 1, 1, 1 }, { 1, 1, 0, 1, 1 }, { 1, 1, 1, 0, 1 },
				{ 1, 1, 1, 1, 0 } };
		int ketqua[] = new int[matrix.length + 1];
		System.out.println("nhap dinh bat dau");
		Scanner sc = new Scanner(System.in);
		printMatrix(matrix);
		int s = sc.nextInt();
		ketqua[0]=s;
		boolean daqua[]=daQua(matrix.length);
		System.out.println("taapj cac ket qua la: ");
		Try(1, matrix, ketqua, daqua);
		
	}

	private static boolean[] daQua(int length) {
		// TODO Auto-generated method stub
		boolean a[]= new boolean[length];
		for(int i=0;i<length;i++) {
			a[i]=false;
		}
		return a;
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

	public static void Try(int i, int matrix[][], int ketQua[], boolean dqQua[]) {
		for (int j = 0; j < dqQua.length; j++) {
			if ((matrix[ketQua[i - 1]][j] == 1) && !dqQua[j]) {
				ketQua[i] = j;
				dqQua[j] = true;
				if ((i == ketQua.length-1) && (ketQua[i]==ketQua[0])) {
					print(ketQua);
				} else {
					Try(i + 1, matrix, ketQua, dqQua);
				}
				dqQua[j] = false;
				ketQua[i] = -1;
			}
		}
	}

	private static void print(int[] ketQua) {
		// TODO Auto-generated method stub
		for (int i = 0; i < ketQua.length; i++) {
			System.out.print(ketQua[i] + " ");
		}
		System.out.println();
	}
}
