package homeword4;

public class TamHau {
	public static void main(String args[]) {
		// vị trí đánh số 1 là các vị trí xếp quân hậu
		System.out.println("các cách xếp quân hậu : ");
		int matrix[][]= new int[8][8];
		Try(0, matrix);
	}

	public static boolean check(int a[][], int col, int row) {
		// kiểm tra hàng ngang
		int i, j;
		for (i = col; i >= 0; i--) {
			if (a[row][i] == 1) {
				return false;
			}
		}
		// kiểm tra đường chéo trên bên trái
		i = row;
		j = col;
		while (i >= 0 && j >= 0) {
			if (a[i][j] == 1) {
				return false;
			}
			i--;
			j--;
		}
		// kiểm tra đường chéo dưới bên trái
		i = row;
		j = col;
		while (i < a.length && j >= 0) {
			if (a[i][j] == 1) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}

	public static void Try(int i, int matrix[][]) {
		for (int v = 0; v < matrix.length; v++) {
			if (check(matrix, i, v)) {
				matrix[v][i]=1;
				if(i==matrix.length-1) {
					print(matrix);
				}else {
					Try(i+1, matrix);
				}
				matrix[v][i]=0;
			}
		}
	}
	
	// hàm in ma trận 
	private static void print(int[][] matrix) {
		// TODO Auto-generated method stub
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix.length;j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();
	}
}
