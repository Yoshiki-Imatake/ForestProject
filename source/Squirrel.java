package my_work;

import java.util.Map;

public class Squirrel extends Animal {
	private static int SLEEPTIME;
	private static int AWAKETAME;

	public Squirrel(int x, int y, int z) {
		super(x, y, z);
	}

	@Override
	public void move() {
		Vector vec = super.getVec();
		vec.x = 1;
		vec.y = 2;
		while (true) {
			if (0 <= this.x && this.x < 100 && 0 <= this.y && this.y < 100) {
				Tree tree = Forest.checkTree(this.x, this.y);
				if (tree != null) {
					System.out.println("リスは" + "(" + this.x + "," + this.y + ")" + "で木を見つけた。");
					this.climb(tree);
				}
			}
			if (this.x < 0 || 100 < this.x) {
				vec.Reflect("v");
			}
			if (this.y < 0 || 100 < this.y) {
				vec.Reflect("h");
			}
			this.setX(this.x + vec.x);
			this.setY(this.y + vec.y);
			System.out.println("(" + this.x + "," + this.y + ")");
			this.wait(1);
		}
	}

	@Override
	public void searchFood() {
		
	}
	
	public void searchFoodOnBranch(Branch branch) {
		int speed = 3;
		int dist = 0;
		boolean reachedEdge = false;
		while (true) {
			if (branch.getLength() <= dist) {
				System.out.println("リスは枝の先端に到達した。");
				Fruit fruit = branch.harvest();
				wait(1);
				System.out.println("リスは木の実を見つけた。");
				wait(1);
				System.out.println("リスは木の実を食べた。（エネルギー１増加)");
				energy++;
				wait(1);
				System.out.println("エネルギーが"+energy+"になった。（5で満腹)");
				if (energy >= 5) {
					System.out.println("リスは満腹になった。");
					System.exit(0);
				}
				speed = -speed;
				reachedEdge = true;
				dist += speed;
				continue;
			}
			dist += speed;
			if (dist <= 0 && reachedEdge) {
				dist = 0;
				System.out.println("リスは木の幹に戻った。");
				break;
			} else if (speed > 0) {
				System.out.println("リスは枝の先端に向かって走っている");
			} else if (speed < 0) {
				System.out.println("リスは枝の根本に向かって走っている");
			}
			wait(1);
		}
	}

	@Override
	public void sleep() {

	}

	public void climb(Tree tree) {
		int speed = 3;
		boolean reachedEdge = false;
		while (true) {
			if (tree.getHeight() <= this.z) {
				System.out.println("リスは木のてっぺんに到達した。");
				speed = -speed;
				reachedEdge = true;
				this.z += speed;
				continue;
			}
			this.z += speed;
			// 今のぼった範囲に枝があるか確かめる
			Map<Integer, Branch> branches = tree.getBranches();
			for (int i = this.z - speed; i <= this.z; i++) {
				try {
					Branch branch = branches.get(i);
					if (branch != null) {
						System.out.println("リスは枝を見つけた。");
						wait(1);
						if (branch.checkFruit()) {
							System.out.println("この枝には実がなっているようだ。");
							searchFoodOnBranch(branch);
						}else {
							System.out.println("この枝には実がなっていないようだ。");
						}
					}
				} catch (NullPointerException e) {
					continue;
				}
			}
			if (this.z <= 0 && reachedEdge) {
				this.z = 0;
				System.out.println("リスは地面に降りた。");
				break;
			} else if (speed > 0) {
				System.out.println("リスは木を登っている。"+"高さ："+this.z);
			} else if (speed < 0) {
				System.out.println("リスは木を降りている。"+"高さ："+this.z);
			}
			wait(1);
		}
	}
}
