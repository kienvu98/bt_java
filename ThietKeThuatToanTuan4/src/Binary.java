
public class Binary {
	public static void main(String args[]) {
		//binary(25);
		int max= Integer.MAX_VALUE;
		System.out.print(max);
	}
	public static void binary(int n) {
		if(n<1) {
			return ;
		}else {
			int t=n%2;
			binary(n/2);
			System.out.print(t);
		}
	}
}
