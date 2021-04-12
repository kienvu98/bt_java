package bai1;

public class DayConDonDieu {
	public static void main(String args[]) {
		int[] array = {4,12,3,5,11,15,6,19};
		test(array);
	}

	public static void test(int array[]) {
		int[] tmp = new int[array.length];
		int[] truyVet = new int[array.length];
		// cơ sở quy hoạch động
		tmp[0] = 1;
		int tmpMax;

		// quy hoạch động
		for (int i = 1; i < array.length; i++) {
			tmpMax = 0;
			int h=0;
			for (int j = 0; j < i; j++) {
				if (array[i] > array[j]) {
					if (tmp[j] > tmpMax) {
						tmpMax = tmp[j];
						h=j;
					}
				}
				tmp[i] = tmpMax + 1;
				truyVet[i]=h;
			}
		}
		// truy vết tìm nghiệm
		int max=0;
		for(int i=0;i<array.length;i++) {
			if(tmp[i]>tmp[max]) {
				max=i;
			}
		}
		while(true) {
			int i=max;
			System.out.print(array[i]+" ");
			max=truyVet[i];
			if(truyVet[max]==0) {
				System.out.print(array[max]+" ");
				break;
			}
		}
		
		
	}
}