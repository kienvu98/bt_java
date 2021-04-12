package test;

import java.util.Arrays;

public class Bai1 {
	public static void main(String args[]) {
		int a[] = { 1, 2, 2, 1 };
		int b[] = { 2, 2 };
		union(a, b);

	}

	public static void union(int a[], int b[]) {
		Arrays.sort(a);
		Arrays.sort(b);

		int index_a = 0;
		int index_b = 0;
		int c[] = new int[b.length];
		while (index_a < a.length && index_b < b.length) {
			if (a[index_a] == b[index_b]) {
				c[index_b] = a[index_a];
				index_a++;
				index_b++;
			} else if (a[index_a] > b[index_b]) {
				index_b++;
			} else {
				index_a++;
			}
		}

		// xóa các phần tử trùng nhau trong mảng các phần tử giao của 2 mảng
		for (int i = 0; i < c.length - 1; i++) {
			for (int j = i + 1; j < c.length; j++) {
				if (c[i] == c[j]) {
					System.out.println("jfjfj");
					for(int k=j ; k<c.length-1;k++) {
						c[k] = c[k+1];
						k--;
						
					}
				}
			}
		}
		
		print(c);
	}

	

	public static void print(int a[]) {
		for(int i=0; i<a.length;i++) {
			System.out.print(a[i] + " ");
		}
	}
}
