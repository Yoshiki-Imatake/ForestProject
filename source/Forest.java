package my_work;

import java.util.HashMap;
import java.util.Map;
import java.lang.Math;

public class Forest {
	/**
	 * keyをｙ座標、valueをx座標とTreeオブジェクトのマップとするマップ
	 */
	private static Map<Integer, Map> trees;

	public Forest() {
		
		Map<Integer, Map> trees = new HashMap<Integer, Map>();
		for (int y = 0; y < 100; y++) {
			Map<Integer, Tree> treeRow = new HashMap<Integer, Tree>();
			for (int x = 0; x < 100; x++) {
				int rand = (int) (Math.random() * 100);
				if (rand < 20) {
					Tree tree = new Beech(x, y);
					treeRow.put(x, tree);
				}else {
					treeRow.put(x, null);
				}
			}
			trees.put(y, treeRow);
		}
		this.trees = trees;
	}

	public static Tree checkTree(int x, int y) {
		Map<Integer, Map> row = (Map)trees.get(y);
		Tree tree = (Tree) row.get(x);
		return tree;
	}
	/*
	public Fruit isThereFruit(int x, int y) {

	}
	*/
}
