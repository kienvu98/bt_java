package bai2;

public class Edge {
	private int u;
	private int v;
	private int weigth;

	public int getU() {
		return u;
	}

	public void setU(int u) {
		this.u = u;
	}

	public int getV() {
		return v;
	}

	public void setV(int v) {
		this.v = v;
	}

	public int getWeigth() {
		return weigth;
	}

	public void setWeigth(int weigth) {
		this.weigth = weigth;
	}

	public Edge(int u, int v, int weigth) {
		super();
		this.u = u;
		this.v = v;
		this.weigth = weigth;
	}

}
