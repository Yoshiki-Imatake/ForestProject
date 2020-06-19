package my_work;

import java.util.Random;

public class Beech extends Tree{
	
	public Beech(int x, int y) {
		super();
		this.setX(x);
		this.setY(y);
		
		Random rand = new Random();
		int height = rand.nextInt(20) + 10;
		this.setHeight(height);
		this.growBranch();
	}

}
