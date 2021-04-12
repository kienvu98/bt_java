package bai2.botriphonghoc;

import java.util.ArrayList;

public class BoTriPhongHoc {
	public static void main(String args[]) {
		ArrayList<ThoiGianHop> arrayList= new ArrayList<ThoiGianHop>();
		ThoiGianHop t1= new ThoiGianHop(7, 9);
		arrayList.add(t1);
		ThoiGianHop t2= new ThoiGianHop(2, 4);
		arrayList.add(t2);
		ThoiGianHop t3= new ThoiGianHop(1, 3);
		arrayList.add(t3);
		ThoiGianHop t4= new ThoiGianHop(1, 6);
		arrayList.add(t4);
		ThoiGianHop t5= new ThoiGianHop(3, 7);
		arrayList.add(t5);
		boTriPhongHoc(arrayList);
	}

	public static void boTriPhongHoc(ArrayList<ThoiGianHop> arrayList) {
		// sắp xếp thời gian kết thúc giảm dần
		arrayList.sort((l1, l2) -> {
			if (l1.getEnd() > l2.getEnd()) {
				return 1;
			} else {
				return -1;
			}
		});
		//print(arrayList);
		int [] tmp= new int[arrayList.size()];
		tmp[0]=1;
		int tmpMax;
		// quy hoạch động
		
		for(int i=1;i<tmp.length;i++) {
			tmpMax=0;
			for(int j=0;j<i;j++) {
				if(arrayList.get(i).getStart()>=arrayList.get(j).getEnd()) {
					if(tmp[j]>tmpMax) {
						tmpMax=tmp[j];
					}
				}
			}
			tmp[i]=tmpMax+1;
		}
		System.out.println("bảng phương án tối ưu");
		for(int i=0;i<tmp.length;i++) {
			System.out.print(tmp[i]+" ");
		}
	}

	private static void print(ArrayList<ThoiGianHop> arrayList) {
		// TODO Auto-generated method stub
		for(int i=0;i<arrayList.size();i++) {
			System.out.print(arrayList.get(i).getEnd());
		}
	}
}
