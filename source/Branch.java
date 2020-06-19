package my_work;

public class Branch {
	private Vector vec;
	private Fruit fruit;
	
	public Branch(int height, int top) {
		int length = top - height;
		int x = (int)(Math.random()*length);
		int y = (int)(Math.sqrt(Math.pow(length, 2)-Math.pow(x, 2)));
		Vector vec = new Vector(x, y);
		this.vec = vec;
		this.bearFruit();
	}
	
	public void bearFruit() {
		int rand = (int)(Math.random()*100);
		if (rand<40) {
			Fruit fruit = new Fruit();
			this.fruit = fruit;
		}else {
			this.fruit = null;
		}
	}
	
	public double getLength() {
		return vec.getLength();
	}
	
	public boolean checkFruit() {
		boolean hasFruit = false;
		if (this.fruit != null) {
			hasFruit = true;
		}
		return hasFruit;
	}
	
	public Fruit harvest() {
		Fruit f = this.fruit;
		this.fruit = null;
		return f;
	}
}
