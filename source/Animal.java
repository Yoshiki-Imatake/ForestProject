package my_work;

public abstract class Animal {
	protected int energy;
	protected int x;
	protected int y;
	protected int z;
	protected Vector vec;
	
	public Animal(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.energy = 3;
		Vector v = new Vector(0,0,0);
		this.vec = v;
	}
	
	public abstract void move();
	
	public abstract void searchFood();
	
	public abstract void sleep();
	
	public void wait(int time) {
		long start = System.currentTimeMillis();
		long now = System.currentTimeMillis();
		while ((now - start) < (long)(time*1000)) {
			now = System.currentTimeMillis();
		}
	}

	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

	public Vector getVec() {
		return vec;
	}

	public void setVec(Vector vec) {
		this.vec = vec;
	}
	
	
}
