package homeword4;

import java.util.Scanner;

public class LietKeNhiPhan {
	public static void main(String args[]) {
		Scanner sc= new Scanner(System.in);
		System.out.println("nhap n:");
		int n=sc.nextInt();
		int kq[]=new int[n];
		Try(0, kq);
	}

	public static void Try(int i, int kq[]) {
		for (int v = 0; v < 2; v++) {
			kq[i] = v;
			if (i == kq.length - 1) {
				print(kq);
			}
			else {
				Try(i+1, kq);
			}
		}
	}

	private static void print(int[] kq) {
		// TODO Auto-generated method stub
		for(int i=0;i<kq.length;i++) {
			System.out.print(kq[i]);
		}
		System.out.println();
	}
}
