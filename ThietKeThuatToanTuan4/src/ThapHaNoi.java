import java.util.Scanner;

public class ThapHaNoi {
	public static void main(String args[]) {
		System.out.println("nhap so thap:");
		Scanner sc= new Scanner(System.in);
		int x= sc.nextInt();
		thapHaNoi(x, "A", "B", "C");
	}

	// diem dau a,diem dich c,diem tam b
	public static void thapHaNoi(int n, String a, String b, String c) {
		if (n == 1) {
			System.out.println(a + "---->" + c);
		} else {
			thapHaNoi(n - 1, a, c, b);
			System.out.println(a + "---->" + c);
			thapHaNoi(n - 1, b, a, c);
		}
	}
}
