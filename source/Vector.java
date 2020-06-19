package my_work;

public class Vector {
	public int x;
	public int y;
	public int z;
	
	public Vector(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	public Vector(int x, int y) {
		this.x = x;
		this.y = y;
		this.z = 0;
	}
	/**
	 * 水平軸の反射("h")または垂直軸での反射("v")
	 * @param axis 反射軸 "h"または"v"
	 */
	public void Reflect(String axis) {
		switch (axis) {
		case "h":
			this.y = -y;
			break;
		case "v":
			this.x = -x;
			break;
		}
	}
	
	public double getLength() {
		return Math.sqrt(Math.pow(x,2)+Math.pow(y, 2)+Math.pow(z, 2));
	}
}
