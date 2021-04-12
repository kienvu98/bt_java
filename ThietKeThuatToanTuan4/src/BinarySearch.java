import java.util.Scanner;

public class BinarySearch {
	public static void main(String args[]) {
		System.out.println("nhap do dai mang");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println("nhap so tim kiem : ");
		int x = sc.nextInt();
		search(a, x, 0, a.length);
	}

	public static void search(int a[], int x, int left, int right) {
		if (left > right) {
			System.out.println("khong co " + x + " trong mang");
			return;
		} else {
			int mean = (left + right) / 2;
			if (a[mean] == x) {
				System.out.println("thay " + "x" + " o vi tri " + mean);
				return;
			} else {
				if (a[mean] > x) {
					search(a, x, left, mean - 1);
				} else {
					search(a, x, mean + 1, right);
				}
			}
		}
	}
}
