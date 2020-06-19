package my_work;

import java.util.HashMap;
import java.util.Map;

public abstract class Tree {
	private int height;
	private int x;
	private int y;
	
	private Map<Integer, Branch> branches;
	private Hollow hollow;
	
	public Tree() {
	}
	
	public void growBranch() {
		Map<Integer, Branch> branches = new HashMap<Integer, Branch>();
		int lowest = (int)(this.height * 0.3);
		for (int i=lowest; i<this.height; i++) {
			int rand = (int)(Math.random()*100);
			if (rand<20) {
				Branch branch = new Branch(i, height);
				branches.put(i, branch);
			}else {
				branches.put(i, null);
			}
		}
		this.branches = branches;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
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

	public Map<Integer, Branch> getBranches() {
		return branches;
	}
	
	
}
